package marceloviana1991.sergipefood.pedidos.repository;


import marceloviana1991.sergipefood.pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
