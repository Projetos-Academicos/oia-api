package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Perfil;
import br.com.api.repository.arquitetura.RepositorioGenerico;

public interface PerfilRepository extends JpaRepository<Perfil, Long>, RepositorioGenerico<Perfil, Long>{

}
