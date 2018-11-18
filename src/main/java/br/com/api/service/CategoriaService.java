package br.com.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Categoria;
import br.com.api.repository.CategoriaRepository;

@Service
public class CategoriaService extends ServiceGenerico<Categoria, Long, CategoriaRepository> {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public CategoriaRepository getRepositorio() {
		return this.categoriaRepository;
	}

	@Override
	Categoria persistirEntidade(Categoria model) {
		return this.categoriaRepository.save(model);
	}

}
