package br.com.dimdim.pcs.controller;

import br.com.dimdim.pcs.model.Estoque;
import br.com.dimdim.pcs.repository.EstoqueRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    private final EstoqueRepository repository;

    public EstoqueController(EstoqueRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Estoque> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Estoque salvar(@RequestBody Estoque estoque) {
        return repository.save(estoque);
    }

    @PutMapping("/{id}")
    public Estoque atualizar(@PathVariable Long id, @RequestBody Estoque estoque) {
        estoque.setId(id);
        return repository.save(estoque);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
