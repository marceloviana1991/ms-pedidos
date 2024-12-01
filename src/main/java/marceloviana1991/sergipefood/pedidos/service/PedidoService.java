package marceloviana1991.sergipefood.pedidos.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import marceloviana1991.sergipefood.pedidos.dto.*;
import marceloviana1991.sergipefood.pedidos.model.Pedido;
import marceloviana1991.sergipefood.pedidos.model.Produto;
import marceloviana1991.sergipefood.pedidos.model.Status;
import marceloviana1991.sergipefood.pedidos.repository.PedidoRepository;
import marceloviana1991.sergipefood.pedidos.repository.ProdutoRepository;
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
    private ProdutoRepository produtoRepository;

    public List<PedidoResponseDto> getAllPedidos(Pageable pageable) {
        return repository.findAll(pageable).stream().map(PedidoResponseDto::new).toList();
    }

    public PedidoResponseDto getPedido(Long id) {
        return new PedidoResponseDto(repository.getReferenceById(id));
    }

    @Transactional
    public PedidoResponseDto savePedido(PedidoRequestDto requestDto) {
        Pedido pedido = new Pedido(requestDto, produtoRepository);
        repository.save(pedido);
        return new PedidoResponseDto(pedido);
    }

    @Transactional
    public void aprovaPagamento(Long id) {
        Pedido pedido = repository.getReferenceById(id);
        pedido.setStatus(Status.CONFIRMADO);
    }

    public double getValorTotal(List<ItemDoPedidoRequestDto> itens) {
        double valorTotal = 0.;
        for(ItemDoPedidoRequestDto item : itens) {
            Produto produto = produtoRepository.getReferenceById(item.idProduto());
            valorTotal += produto.getPreco() * (double)item.quantidade();
        }
        return valorTotal;
    }
}
