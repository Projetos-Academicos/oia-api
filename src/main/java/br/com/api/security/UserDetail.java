package br.com.api.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.api.model.Usuario;

public class UserDetail extends User{

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public UserDetail(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getLogin(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
}
