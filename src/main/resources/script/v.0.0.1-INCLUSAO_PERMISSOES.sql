INSERT INTO permissao (descricao) values ('CADASTRAR_VAGA');
INSERT INTO permissao (descricao) values ('ALTERAR_VAGA');
INSERT INTO permissao (descricao) values ('CONSULTAR_VAGA');
INSERT INTO permissao (descricao) values ('DELETAR_VAGA');

INSERT INTO usuario (ativo, login, senha, nome, contato, profissao_id) VALUES (1, 'admin', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', 'TesteLogin', '333632886', 5);

INSERT INTO usuario_permissao (usuario_id, permissao_id) values (3, 1); 
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (3, 2); 
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (3, 3); 
INSERT INTO usuario_permissao (usuario_id, permissao_id) values (3, 4); 