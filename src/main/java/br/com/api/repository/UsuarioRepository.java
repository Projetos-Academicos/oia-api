package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
