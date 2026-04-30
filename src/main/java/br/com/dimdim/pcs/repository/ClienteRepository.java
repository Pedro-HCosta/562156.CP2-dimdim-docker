package br.com.dimdim.pcs.repository;

import br.com.dimdim.pcs.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
