package marceloviana1991.sergipefood.pedidos.dto;

import java.math.BigDecimal;
import java.util.List;

public record PedidoRequestDto(
        BigDecimal valor,
        String nome,
        List<ItemDoPedidoRequestDto> itens
) {
}
