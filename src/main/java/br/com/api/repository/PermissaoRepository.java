package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Permissao;
import br.com.api.repository.arquitetura.RepositorioGenerico;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>, RepositorioGenerico<Permissao, Long>{

}
