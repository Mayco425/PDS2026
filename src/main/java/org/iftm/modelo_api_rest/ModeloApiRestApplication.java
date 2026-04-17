package org.iftm.modelo_api_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModeloApiRestApplication implements CommandLineRunner {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public static void main(String[] args) {
        SpringApplication.run(ModeloApiRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //  INSERT Livro
        Livro livro1 = new Livro(null, "Java POO", "Ana Silva", "Programação",
                "TechBooks", 2022, 5, "DISPONIVEL");

        livroRepository.save(livro1);

        // SELECT ALL
        List<Livro> livros = livroRepository.findAll();
        System.out.println("Lista de livros:");
        for (Livro l : livros) {
            System.out.println(l.getTitulo() + " - " + l.getAutor());
        }

        System.out.println("\n-----------------\n");

        //  SELECT POR ID
        Livro livroBuscado = livroRepository.findById(1L).orElse(null);
        if (livroBuscado != null) {
            System.out.println("Livro encontrado: " + livroBuscado.getTitulo());
        }

        System.out.println("\n-----------------\n");

        //  QUERY METHOD
        List<Livro> livrosAutor = livroRepository.findByAutor("Ana Silva");
        System.out.println("Livros por autor:");
        for (Livro l : livrosAutor) {
            System.out.println(l.getTitulo());
        }

        System.out.println("\n-----------------\n");

        // @Query
        List<Livro> disponiveis = livroRepository.buscarLivrosDisponiveis();
        System.out.println("Livros disponíveis:");
        for (Livro l : disponiveis) {
            System.out.println(l.getTitulo());
        }

        System.out.println("\n-----------------\n");

        //  RESERVA (apenas consulta, já que depende de Usuario)
        List<Reserva> reservas = reservaRepository.findAll();
        System.out.println("Total de reservas: " + reservas.size());
    }
}
	

