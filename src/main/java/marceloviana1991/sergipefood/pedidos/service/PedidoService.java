package marceloviana1991.sergipefood.pedidos.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import marceloviana1991.sergipefood.pedidos.dto.PagamentoRequestDto;
import marceloviana1991.sergipefood.pedidos.dto.PedidoRequestDto;
import marceloviana1991.sergipefood.pedidos.dto.PedidoResponseDto;
import marceloviana1991.sergipefood.pedidos.http.PagamentoClient;
import marceloviana1991.sergipefood.pedidos.model.Pedido;
import marceloviana1991.sergipefood.pedidos.model.Status;
import marceloviana1991.sergipefood.pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PagamentoClient pagamento;

    public List<PedidoResponseDto> getAllPedidos(Pageable pageable) {
        return repository.findAll(pageable).stream().map(PedidoResponseDto::new).toList();
    }

    public PedidoResponseDto getPedido(Long id) {
        return new PedidoResponseDto(repository.getReferenceById(id));
    }

    @Transactional
    public PedidoResponseDto savePedido(PedidoRequestDto requestDto) {
        Pedido pedido = new Pedido(requestDto);
        repository.save(pedido);
        PagamentoRequestDto requestClientDto = new PagamentoRequestDto(pedido);
        pagamento.savePagamento(requestClientDto);
        return new PedidoResponseDto(pedido);
    }

    @Transactional
    public void reenviarPagamento(@NotNull Long id) {
        Pedido pedido = repository.getReferenceById(id);
        PagamentoRequestDto requestClientDto = new PagamentoRequestDto(pedido);
        pagamento.savePagamento(requestClientDto);
        pedido.setStatus(Status.REALIZADO);
    }

    @Transactional
    public PedidoResponseDto savePedidoPendente(PedidoRequestDto requestDto) {
        Pedido pedido = new Pedido(requestDto);
        pedido.setStatus(Status.PENDENTE);
        repository.save(pedido);
        return new PedidoResponseDto(pedido);
    }

    @Transactional
    public void aprovaPagamento(Long id) {
        Pedido pedido = repository.getReferenceById(id);
        pedido.setStatus(Status.PAGO);
    }
}
