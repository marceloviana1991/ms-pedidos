package marceloviana1991.sergipefood.pedidos.dto;

public record PagamentoRequestDto(
        Double valor,
        Long pedidoId
) {
}
