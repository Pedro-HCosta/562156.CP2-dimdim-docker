package br.com.dimdim.pcs.repository;

import br.com.dimdim.pcs.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
