package marceloviana1991.sergipefood.pedidos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marceloviana1991.sergipefood.pedidos.dto.ItemDoPedidoRequestDto;

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

    @ManyToOne(optional=false)
    private Pedido pedido;

    @ManyToOne
    private Produto produto;

    public ItemDoPedido(ItemDoPedidoRequestDto itemDoPedidoRequestDto, Pedido pedido, Produto produto) {
        this.quantidade = itemDoPedidoRequestDto.quantidade();
        this.pedido = pedido;
        this.produto = produto;
    }
}
