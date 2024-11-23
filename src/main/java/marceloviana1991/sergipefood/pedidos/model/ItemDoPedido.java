package marceloviana1991.sergipefood.pedidos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marceloviana1991.sergipefood.pedidos.dto.ItemDoPedidoResponseDto;

@Entity
@Table(name = "item_do_pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDoPedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private Integer quantidade;

    private String descricao;

    @ManyToOne(optional=false)
    private Pedido pedido;

    public ItemDoPedido(ItemDoPedidoResponseDto itemDoPedidoResponseDto, Pedido pedido) {
        this.quantidade = itemDoPedidoResponseDto.quantidade();
        this.descricao = itemDoPedidoResponseDto.descricao();
        this.pedido = pedido;
    }
}
