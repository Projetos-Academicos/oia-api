package br.com.api.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Utils {

	public static String encodarSenha(final String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}


	public static String getLoginUsuarioLogado() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null){
			String login = authentication.getPrincipal().toString();
			return login;
		}
		return null;
	}

}
