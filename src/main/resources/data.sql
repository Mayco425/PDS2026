INSERT INTO tb_livro (titulo, autor, categoria, editora, ano_publicacao, quantidade_exemplares, status)
VALUES 
('Java Básico', 'João Silva', 'Programação', 'TechBooks', 2020, 5, 'DISPONIVEL'),
('Spring Boot', 'Maria Souza', 'Programação', 'DevBooks', 2022, 3, 'DISPONIVEL'),
('Banco de Dados', 'Carlos Lima', 'TI', 'DBEditora', 2019, 2, 'EMPRESTADO');

INSERT INTO tb_reserva (data_reserva, status, codigo_usuario, codigo_livro)
VALUES
('2024-01-10', 'ATIVA', 1, 1),
('2024-01-11', 'CANCELADA', 1, 2);