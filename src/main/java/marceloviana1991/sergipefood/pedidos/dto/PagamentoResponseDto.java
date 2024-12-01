package marceloviana1991.sergipefood.pedidos.dto;

import marceloviana1991.sergipefood.pedidos.model.Status;

public record PagamentoResponseDto(
        Long id,
        Double valor,
        Status status,
        Long pedidoId
) {
}
