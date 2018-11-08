package br.com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	@Query("SELECT NEW Cidade(c.id, c.nome, c.estado) FROM Cidade c WHERE c.ativo = 1 order by c.nome ASC")
	List<Cidade> listar();

}
