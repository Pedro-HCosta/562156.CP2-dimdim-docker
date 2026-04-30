package br.com.dimdim.pcs.controller;

import br.com.dimdim.pcs.model.Estoque;
import br.com.dimdim.pcs.model.Produto;
import br.com.dimdim.pcs.repository.EstoqueRepository;
import br.com.dimdim.pcs.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    private final EstoqueRepository estoqueRepository;
    private final ProdutoRepository produtoRepository;

    public EstoqueController(EstoqueRepository estoqueRepository, ProdutoRepository produtoRepository) {
        this.estoqueRepository = estoqueRepository;
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Estoque> listar() {
        return estoqueRepository.findAll();
    }

    @PostMapping
    public Estoque salvar(@RequestBody Estoque estoque) {
        Produto produto = produtoRepository.findById(estoque.getProduto().getId()).orElseThrow();
        estoque.setProduto(produto);
        return estoqueRepository.save(estoque);
    }

    @PutMapping("/{id}")
    public Estoque atualizar(@PathVariable Long id, @RequestBody Estoque estoque) {
        Produto produto = produtoRepository.findById(estoque.getProduto().getId()).orElseThrow();
        estoque.setId(id);
        estoque.setProduto(produto);
        return estoqueRepository.save(estoque);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        estoqueRepository.deleteById(id);
    }
}
