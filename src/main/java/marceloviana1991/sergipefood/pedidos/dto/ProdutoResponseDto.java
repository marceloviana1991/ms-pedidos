package marceloviana1991.sergipefood.pedidos.dto;

import marceloviana1991.sergipefood.pedidos.model.Produto;

public record ProdutoResponseDto(
        Long id,
        String nome,
        Double preco
) {
    public ProdutoResponseDto(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getPreco()
        );
    }
}
