
-- ------------------------------------------ SUBUIR PRA PRODUÇÃO ------------------------------------------ --

-- POPULANDO PERMISSOES

INSERT INTO permissao (ativo, data_inclusao, descricao) VALUES (true, '2018-11-11 00:00', 'CADASTRAR_VAGA');
INSERT INTO permissao (ativo, data_inclusao, descricao) VALUES (true, '2018-11-11 00:00', 'ALTERAR_VAGA');
INSERT INTO permissao (ativo, data_inclusao, descricao) VALUES (true, '2018-11-11 00:00', 'CONSULTAR_VAGA');
INSERT INTO permissao (ativo, data_inclusao, descricao) VALUES (true, '2018-11-11 00:00', 'DELETAR_VAGA');
INSERT INTO permissao (ativo, data_inclusao, descricao) VALUES (true, '2018-11-11 00:00', 'CARREGAR_LISTAS');
INSERT INTO permissao (ativo, data_inclusao, descricao) VALUES (true, '2018-11-11 00:00', 'CARREGAR_LISTAS');
INSERT INTO permissao (ativo, data_inclusao, descricao) VALUES (true, '2018-11-11 00:00', 'CONSULTAR_USUARIO');

-- -------------------------------------------------------------------------------------------------------------- --

-- POPULANDO PERFIS

INSERT INTO perfil (ativo, data_inclusao, nome) VALUES (true, '2018-11-11 00:00', 'ADMIN');
INSERT INTO perfil (ativo, data_inclusao, nome) VALUES (true, '2018-11-11 00:00', 'USUARIO');

-- -------------------------------------------------------------------------------------------------------------- --

-- POPULANDO PERFIL_PERMISSAO

INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (1,1);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (1,2);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (1,3);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (1,4);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (1,5);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (1,6);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (1,7);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (2,1);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (2,2);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (2,3);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (2,4);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (2,5);
INSERT INTO perfil_permissao (perfil_id, permissao_id) VALUES (2,6);

-- -------------------------------------------------------------------------------------------------------------- --

-- POPULANDO CATEGORIAS

INSERT INTO categoria (ativo, data_inclusao, nome) VALUES (true, '2018-11-11 00:00', 'Reformas em geral');
INSERT INTO categoria (ativo, data_inclusao, nome) VALUES (true, '2018-11-11 00:00', 'Jardinagem');
INSERT INTO categoria (ativo, data_inclusao, nome) VALUES (true, '2018-11-11 00:00', 'Esportes');
INSERT INTO categoria (ativo, data_inclusao, nome) VALUES (true, '2018-11-11 00:00', 'Tecnologia');
INSERT INTO categoria (ativo, data_inclusao, nome) VALUES (true, '2018-11-11 00:00', 'Outros');

-- -------------------------------------------------------------------------------------------------------------- --

-- POPULANDO PROFISSAO

INSERT INTO profissao (ativo, data_inclusao, nome, categoria_id) VALUES (true, '2018-11-11 00:00', 'Pedreiro', 1);
INSERT INTO profissao (ativo, data_inclusao, nome, categoria_id) VALUES (true, '2018-11-11 00:00', 'Pintor', 1);
INSERT INTO profissao (ativo, data_inclusao, nome, categoria_id) VALUES (true, '2018-11-11 00:00', 'Ajudante de Pedreiro', 1);
INSERT INTO profissao (ativo, data_inclusao, nome, categoria_id) VALUES (true, '2018-11-11 00:00', 'Jadineiro', 2);
INSERT INTO profissao (ativo, data_inclusao, nome, categoria_id) VALUES (true, '2018-11-11 00:00', 'Cortador de Grama', 2);
INSERT INTO profissao (ativo, data_inclusao, nome, categoria_id) VALUES (true, '2018-11-11 00:00', 'Massagista', 3);
INSERT INTO profissao (ativo, data_inclusao, nome, categoria_id) VALUES (true, '2018-11-11 00:00', 'Personal Trainner', 3);
INSERT INTO profissao (ativo, data_inclusao, nome, categoria_id) VALUES (true, '2018-11-11 00:00', 'Programador Android', 4);
INSERT INTO profissao (ativo, data_inclusao, nome, categoria_id) VALUES (true, '2018-11-11 00:00', 'Programador Web', 4);
INSERT INTO profissao (ativo, data_inclusao, nome, categoria_id) VALUES (true, '2018-11-11 00:00', 'Técnico em Informatica', 4);
INSERT INTO profissao (ativo, data_inclusao, nome, categoria_id) VALUES (true, '2018-11-11 00:00', 'Outros', 5);


-- -------------------------------------------------------------------------------------------------------------- --

-- POPULANDO CIDADE

INSERT INTO cidade (ativo, data_inclusao, nome, estado) VALUES (true, '2018-11-11 00:00', 'Recife', 'PE');
INSERT INTO cidade (ativo, data_inclusao, nome, estado) VALUES (true, '2018-11-11 00:00', 'Olinda', 'PE');
INSERT INTO cidade (ativo, data_inclusao, nome, estado) VALUES (true, '2018-11-11 00:00', 'Jaboatão', 'PE');
INSERT INTO cidade (ativo, data_inclusao, nome, estado) VALUES (true, '2018-11-11 00:00', 'Camaragibe', 'PE');
INSERT INTO cidade (ativo, data_inclusao, nome, estado) VALUES (true, '2018-11-11 00:00', 'Cabo de Santo Agostinho', 'PE');
INSERT INTO cidade (ativo, data_inclusao, nome, estado) VALUES (true, '2018-11-11 00:00', 'Outros', 'PE');

-- -------------------------------------------------------------------------------------------------------------- --

-- POPULANDO USUARIO

INSERT INTO usuario (ativo, data_inclusao, contato, login, nome, senha, perfil_id, profissao_id) 
		VALUES (true, '2018-11-11 00:00', '81994633530', 'zlima', 'Ricardo Lima', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', 1, 9);
INSERT INTO usuario (ativo, data_inclusao, contato, login, nome, senha, perfil_id, profissao_id) 
		VALUES (true, '2018-11-11 00:00', '81987496841', 'jefferson', 'Jefferson Euclides', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', 2, 8);
INSERT INTO usuario (ativo, data_inclusao, contato, login, nome, senha, perfil_id, profissao_id) 
		VALUES (true, '2018-11-11 00:00', '81123456789', 'maria', 'Maria Teste', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', 2, 2);
INSERT INTO usuario (ativo, data_inclusao, contato, login, nome, senha, perfil_id, profissao_id) 
		VALUES (true, '2018-11-11 00:00', '819987456321', 'teste', 'Teste teste', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.', 2, 5);

-- -------------------------------------------------------------------------------------------------------------- --

-- POPULANDO VAGA

INSERT INTO vaga (ativo, data_inclusao, descricao, orcamento, prazo, status_vaga, titulo, categoria_id, cidade_id, usuario_selecionado_id, usuario_vaga_id)
		VALUES (true, '2018-11-11 00:00', 'Preciso de alguem pra cortar minha grama', 10000, 1, 'ABERTA', 'Cortar minha grama', 2, 1, null, 3);
INSERT INTO vaga (ativo, data_inclusao, descricao, orcamento, prazo, status_vaga, titulo, categoria_id, cidade_id, usuario_selecionado_id, usuario_vaga_id)
		VALUES (true, '2018-11-11 00:00', 'Rebocar pareide do quarto 10x2', 15000, 2, 'ABERTA', 'Rebocar pareide', 1, 4, null, 2);
INSERT INTO vaga (ativo, data_inclusao, descricao, orcamento, prazo, status_vaga, titulo, categoria_id, cidade_id, usuario_selecionado_id, usuario_vaga_id)
		VALUES (true, '2018-11-11 00:00', 'teste', 100000, 15, 'PREENCHIDA', 'teste', 4, 2, 1, 4);
INSERT INTO vaga (ativo, data_inclusao, descricao, orcamento, prazo, status_vaga, titulo, categoria_id, cidade_id, usuario_selecionado_id, usuario_vaga_id)
		VALUES (true, '2018-11-11 00:00', 'Massagem anti estresse e revigorante', 8000, 1, 'ABERTA', 'Precisa-se de Massagista', 3, 5, null, 3);
INSERT INTO vaga (ativo, data_inclusao, descricao, orcamento, prazo, status_vaga, titulo, categoria_id, cidade_id, usuario_selecionado_id, usuario_vaga_id)
		VALUES (true, '2018-11-11 00:00', 'Pintor', 15000, 2, 'ABERTA', 'Pintar a sala 7x7', 1, 3, null, 4);

-- -------------------------------------------------------------------------------------------------------------- --

-- POPULANDO CANDIDATOS_VAGAS

INSERT INTO candidatos_vagas (candidato_id, vaga_id ) VALUES (1,1);
INSERT INTO candidatos_vagas (candidato_id, vaga_id ) VALUES (1,2);
INSERT INTO candidatos_vagas (candidato_id, vaga_id ) VALUES (1,3);
INSERT INTO candidatos_vagas (candidato_id, vaga_id ) VALUES (1,4);
INSERT INTO candidatos_vagas (candidato_id, vaga_id ) VALUES (2,1);
INSERT INTO candidatos_vagas (candidato_id, vaga_id ) VALUES (2,3);
INSERT INTO candidatos_vagas (candidato_id, vaga_id ) VALUES (2,4);
INSERT INTO candidatos_vagas (candidato_id, vaga_id ) VALUES (3,2);
INSERT INTO candidatos_vagas (candidato_id, vaga_id ) VALUES (3,3);

-- -------------------------------------------------------------------------------------------------------------- --