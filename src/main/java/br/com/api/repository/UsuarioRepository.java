package br.com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.model.Usuario;
import br.com.api.repository.arquitetura.RepositorioGenerico;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, RepositorioGenerico<Usuario, Long> {

	@Query("SELECT NEW Usuario(u.id, u.nome, u.login) FROM Usuario u WHERE u.id = ?1")
	Usuario consultaSimplesPorId(Long id);

	@Query("SELECT NEW Usuario(u.id, u.nome, u.login) FROM Usuario u WHERE u.login = ?1")
	Usuario consultaSimplesPorLogin(String login);

	Long countByLogin(String login);

	Optional<Usuario> findByAtivoAndLogin(boolean ativo, String login);
}
