package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

}
