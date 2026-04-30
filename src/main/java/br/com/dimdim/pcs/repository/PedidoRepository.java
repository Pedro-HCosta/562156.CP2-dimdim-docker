package br.com.dimdim.pcs.repository;

import br.com.dimdim.pcs.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
