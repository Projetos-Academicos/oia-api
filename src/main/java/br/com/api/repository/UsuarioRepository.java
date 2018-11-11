package br.com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Usuario;
import br.com.api.repository.arquitetura.RepositorioGenerico;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, RepositorioGenerico<Usuario, Long> {

	Optional<Usuario> findByLogin(String login);
}
