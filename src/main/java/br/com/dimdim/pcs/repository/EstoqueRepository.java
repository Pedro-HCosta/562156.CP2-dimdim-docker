package br.com.dimdim.pcs.repository;

import br.com.dimdim.pcs.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
