package br.com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.model.Cidade;
import br.com.api.repository.arquitetura.RepositorioGenerico;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, RepositorioGenerico<Cidade, Long>{

	@Query("SELECT NEW Cidade(c.id, c.nome, c.estado) FROM Cidade c WHERE c.ativo = 1 order by c.nome ASC")
	List<Cidade> listarCidade();

}
