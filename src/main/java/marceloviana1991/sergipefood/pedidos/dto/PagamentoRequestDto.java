package marceloviana1991.sergipefood.pedidos.dto;

import marceloviana1991.sergipefood.pedidos.model.Pedido;

import java.math.BigDecimal;

public record PagamentoRequestDto(
        BigDecimal valor,
        String nome,
        Long pedidoId
) {
    public PagamentoRequestDto(Pedido pedido) {
        this(
                pedido.getValor(),
                pedido.getNome(),
                pedido.getId()
        );
    }
}
