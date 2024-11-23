package marceloviana1991.sergipefood.pedidos.dto;

import marceloviana1991.sergipefood.pedidos.model.ItemDoPedido;

public record ItemDoPedidoResponseDto(
        Long id,
        Integer quantidade,
        String descricao
) {
    public ItemDoPedidoResponseDto(ItemDoPedido itemDoPedido) {
        this(
                itemDoPedido.getId(),
                itemDoPedido.getQuantidade(),
                itemDoPedido.getDescricao()
        );
    }
}
