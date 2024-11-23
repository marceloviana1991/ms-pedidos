package marceloviana1991.sergipefood.pedidos.repository;

import marceloviana1991.sergipefood.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens where p.id = :id")
    Pedido porIdComItens(Long id);

}
