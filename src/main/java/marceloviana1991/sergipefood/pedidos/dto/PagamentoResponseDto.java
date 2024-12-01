package marceloviana1991.sergipefood.pedidos.dto;

import marceloviana1991.sergipefood.pedidos.model.Status;

import java.math.BigDecimal;

public record PagamentoResponseDto(
        Long id,
        BigDecimal valor,
        String nome,
        Status status,
        Long pedidoId
) {
}
