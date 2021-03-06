package br.com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.model.Profissao;
import br.com.api.repository.arquitetura.RepositorioGenerico;

public interface ProfissaoRepository extends JpaRepository<Profissao, Long>, RepositorioGenerico<Profissao, Long>{

	@Query("SELECT NEW Profissao(p.id, p.nome) FROM Profissao p WHERE p.ativo = 1 order by p.nome asc")
	List<Profissao> listarProfissao();

}
