package br.com.api.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.api.model.Usuario;
import br.com.api.repository.UsuarioRepository;

@Service
public class AppUserDetailService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		Set<SimpleGrantedAuthority> autorizacoes = new HashSet<>();
		usuario.getPermissoes().forEach( p -> autorizacoes.add( new SimpleGrantedAuthority(p.getDescricao().toUpperCase())));

		return autorizacoes;
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Usuario> usuarioOptional = this.usuarioRepository.findByLogin(login);

		Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
		return new User(login, usuario.getSenha(), this.getPermissoes(usuario));
	}

}
