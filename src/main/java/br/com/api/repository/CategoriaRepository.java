package br.com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	@Query("SELECT NEW Categoria(c.id, c.nome) FROM Categoria c WHERE c.ativo = 1 order by c.nome asc")
	List<Categoria> listar();

}
