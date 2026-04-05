package org.iftm.modelo_api_rest.repositories;

import java.util.List;

import org.iftm.modelo_api_rest.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LivroRepository extends JpaRepository<Livro, Long>{

    //  QueryMethods 

    List<Livro> findByTitulo(String titulo);

    List<Livro> findByAutor(String autor);

    List<Livro> findByCategoria(String categoria);

    List<Livro> findByStatus(String status);

    List<Livro> findByAnoPublicacao(int anoPublicacao);

    //  @Query
    @Query("SELECT l FROM Livro l WHERE l.quantidadeExemplares > 0")
    List<Livro> buscarLivrosDisponiveis();
}