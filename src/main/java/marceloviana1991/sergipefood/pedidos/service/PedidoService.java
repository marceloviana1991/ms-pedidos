package marceloviana1991.sergipefood.pedidos.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import marceloviana1991.sergipefood.pedidos.dto.PedidoRequestDto;
import marceloviana1991.sergipefood.pedidos.dto.PedidoResponseDto;
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
        return new PedidoResponseDto(pedido);
    }

    @Transactional
    public void aprovaPagamento(Long id) {
        Pedido pedido = repository.getReferenceById(id);
        pedido.setStatus(Status.CONFIRMADO);
    }
}
