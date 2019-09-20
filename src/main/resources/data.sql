INSERT INTO EMPRESA(id, nome, descricao) VALUES
    (1, 'Patrulha da Noite', 'Patrulha da Noite SA'),
    (2, 'Tech', 'Tech World');
INSERT INTO CANDIDATO(id, nome, email, senha) VALUES(1, 'Jhon Snow', 'jhon@stark.com', '123');
INSERT INTO VAGA(id, titulo, descricao, data_criacao, status, empresa_id) VALUES
    (1, 'Patrulheiro', 'Patrulheiro além da muralha', '2019-09-09 18:00:00', 'ATIVA', 1),
    (2, 'Programador Java', 'Programador Java Pleno', '2019-09-20 00:00:00', 'ATIVA', 2);