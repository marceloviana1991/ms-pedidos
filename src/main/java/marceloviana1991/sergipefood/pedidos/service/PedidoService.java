package marceloviana1991.sergipefood.pedidos.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
        PagamentoRequestDto requestClientDto = new PagamentoRequestDto(requestDto, pedido);
        pagamento.savePagamento(requestClientDto);
        return new PedidoResponseDto(pedido);
    }

    @Transactional
    public PedidoResponseDto updateStatusPedido(Long id, Status status) {
        Pedido pedido = repository.porIdComItens(id);
        if (pedido == null) {
            throw new EntityNotFoundException();
        }
        pedido.setStatus(status);
        return new PedidoResponseDto(pedido);
    }

    @Transactional
    public void updateStatusPagoPedido(Long id) {
        Pedido pedido = repository.porIdComItens(id);
        if (pedido == null) {
            throw new EntityNotFoundException();
        }
        pedido.setStatus(Status.PAGO);
    }
}
