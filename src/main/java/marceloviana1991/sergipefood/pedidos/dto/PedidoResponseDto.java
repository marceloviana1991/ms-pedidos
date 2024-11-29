package marceloviana1991.sergipefood.pedidos.dto;

import marceloviana1991.sergipefood.pedidos.model.Pedido;
import marceloviana1991.sergipefood.pedidos.model.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponseDto(
        Long id,
        LocalDateTime dataHora,
        Status status,
        List<ItemDoPedidoResponseDto>itens
) {
    public PedidoResponseDto(Pedido pedido) {
        this(
                pedido.getId(),
                pedido.getDataHora(),
                pedido.getStatus(),
                pedido.getItens().stream().map(ItemDoPedidoResponseDto::new).toList()
        );
    }
}
