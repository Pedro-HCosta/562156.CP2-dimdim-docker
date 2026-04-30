package br.com.dimdim.pcs.controller;

import br.com.dimdim.pcs.model.Pedido;
import br.com.dimdim.pcs.model.Cliente;
import br.com.dimdim.pcs.repository.PedidoRepository;
import br.com.dimdim.pcs.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoController(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido) {
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId()).orElseThrow();
        pedido.setCliente(cliente);
        return pedidoRepository.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId()).orElseThrow();
        pedido.setId(id);
        pedido.setCliente(cliente);
        return pedidoRepository.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}
