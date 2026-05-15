package org.iftm.modelo_api_rest.services;

import java.util.List;

import org.iftm.modelo_api_rest.entity.Livro;
import org.iftm.modelo_api_rest.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;


    public boolean validarTitulo(Livro livro) {
        return livro.getTitulo() != null && !livro.getTitulo().isEmpty();
    }

    public boolean validarQuantidade(Livro livro) {
        return livro.getQuantidadeExemplares() > 0;
    }

    public boolean validarAno(Livro livro) {
        return livro.getAnoPublicacao() > 0;
    }

    public boolean validarLivro(Livro livro) {
        return validarTitulo(livro) &&
               validarQuantidade(livro) &&
               validarAno(livro);
    }


    public Livro inserir(Livro livro) {
        if (validarLivro(livro)) {
            return livroRepository.save(livro);
        }
        throw new RuntimeException("Livro inválido.");
    }

    public List<Livro> inserirTodos(List<Livro> livros) {
        for (Livro livro : livros) {
            if (!validarLivro(livro)) {
                throw new RuntimeException("Livro inválido.");
            }
        }
        return livroRepository.saveAll(livros);
    }

    public Livro atualizar(Livro livro) {
        if (validarLivro(livro)) {
            return livroRepository.save(livro);
        }
        throw new RuntimeException("Livro inválido.");
    }

    public void apagar(Long id) {
        livroRepository.deleteById(id);
    }

    public void apagarTodos() {
        livroRepository.deleteAll();
    }

    
    public List<Livro> buscarPorAutor(String autor) {
        return livroRepository.findByAutor(autor);
    }

    public List<Livro> buscarPorCategoria(String categoria) {
        return livroRepository.findByCategoria(categoria);
    }

    public List<Livro> buscarDisponiveis() {
        return livroRepository.buscarLivrosDisponiveis();
    }
}