package org.iftm.modelo_api_rest.controllers;

import java.util.List;

import org.iftm.modelo_api_rest.entity.Livro;
import org.iftm.modelo_api_rest.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    // Inserir
    @PostMapping
    public Livro inserir(@RequestBody Livro livro) {
        return livroService.inserir(livro);
    }

    // Inserir vários
    @PostMapping("/lista")
    public List<Livro> inserirTodos(@RequestBody List<Livro> livros) {
        return livroService.inserirTodos(livros);
    }

    // Atualizar
    @PutMapping
    public Livro atualizar(@RequestBody Livro livro) {
        return livroService.atualizar(livro);
    }

    // Excluir por id
    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id) {
        livroService.apagar(id);
    }

    // Excluir todos
    @DeleteMapping
    public void apagarTodos() {
        livroService.apagarTodos();
    }

    // Consulta por autor
    @GetMapping("/autor/{autor}")
    public List<Livro> buscarPorAutor(@PathVariable String autor) {
        return livroService.buscarPorAutor(autor);
    }

    // Consulta por categoria
    @GetMapping("/categoria/{categoria}")
    public List<Livro> buscarPorCategoria(@PathVariable String categoria) {
        return livroService.buscarPorCategoria(categoria);
    }

    // Consulta usando @Query
    @GetMapping("/disponiveis")
    public List<Livro> buscarDisponiveis() {
        return livroService.buscarDisponiveis();
    }
}