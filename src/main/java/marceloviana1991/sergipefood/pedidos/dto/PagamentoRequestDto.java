package marceloviana1991.sergipefood.pedidos.dto;

import marceloviana1991.sergipefood.pedidos.model.Pedido;

import java.math.BigDecimal;

public record PagamentoRequestDto(
        BigDecimal valor,
        String nome,
        Long pedidoId,
        Long formaDePagamentoId
) {
    public PagamentoRequestDto(PedidoRequestDto pedidoDto, Pedido pedido) {
        this(
                pedidoDto.valor(),
                pedidoDto.nome(),
                pedido.getId(),
                pedidoDto.formaDePagamentoId()
        );
    }
}
