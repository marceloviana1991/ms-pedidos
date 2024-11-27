package marceloviana1991.sergipefood.pedidos.dto;

import java.util.List;

public record PedidoRequestDto(
        List<ItemDoPedidoRequestDto> itens
) {
}
