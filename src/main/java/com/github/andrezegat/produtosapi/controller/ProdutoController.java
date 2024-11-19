package com.github.andrezegat.produtosapi.controller;

import com.github.andrezegat.produtosapi.controller.repository.ProdutoRepository;
import com.github.andrezegat.produtosapi.model.Produto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoRepository repository;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        produto.setId(UUID.randomUUID().toString());
        return repository.save(produto);
    }

    @GetMapping("{id}")
    public Produto buscarPorId(@PathVariable("id") String id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void apagarProduto(@PathVariable("id") String id) {
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public void apagarProduto(@PathVariable("id") String id,
                              @RequestBody Produto produto) {
        produto.setId(id);
        repository.save(produto);
    }

    @GetMapping
    public List<Produto> buscarProdutos(@RequestParam("nome") String nome) {
        return repository.findByNome(nome);
    }
}
