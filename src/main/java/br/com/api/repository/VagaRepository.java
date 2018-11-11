package br.com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.model.Vaga;
import br.com.api.repository.arquitetura.RepositorioGenerico;

public interface VagaRepository extends JpaRepository<Vaga, Long>, RepositorioGenerico<Vaga, Long> {

	@Query("SELECT NEW Vaga(v.id, v.ativo, v.titulo, v.descricao, v.orcamento, v.prazo, v.cidade.id, v.cidade.nome, v.cidade.estado, v.statusVaga, v.categoria.id, v.categoria.nome, v.usuarioVaga.id, v.usuarioVaga.nome)"
			+ " FROM Vaga v WHERE v.ativo = 1 and v.id = ?1")
	Vaga consultarVaga(Long id);

	@Query("SELECT NEW Vaga(v.id, v.ativo, v.titulo, v.descricao, v.orcamento, v.prazo, v.cidade.id, v.cidade.nome, v.cidade.estado, v.categoria.id, v.categoria.nome, v.usuarioVaga.id, v.usuarioVaga.nome)"
			+ "FROM Vaga v WHERE v.ativo = 1 and v.statusVaga = 'ABERTA' and v.usuarioVaga.id <> ?1")
	List<Vaga> listarVagasAbertasParaCandidatos(Long idUsuario);

	@Query("SELECT NEW Vaga(v.id, v.ativo, v.titulo, v.descricao, v.orcamento, v.prazo, v.cidade.id, v.cidade.nome, v.cidade.estado, v.statusVaga, v.categoria.id, v.categoria.nome, v.usuarioVaga.id, v.usuarioVaga.nome)"
			+ " FROM Vaga v WHERE v.ativo = 1 and v.usuarioVaga.id = ?1")
	List<Vaga> listarVagasPorIdUsuario(Long idUsuario);
}
