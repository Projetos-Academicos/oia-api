package br.com.api.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.constantes.ConstantesURL;

@RestController
public class TokenResController {


	@DeleteMapping(value = ConstantesURL.REALIZAR_LOGOUT)
	public void revogarToken(HttpServletRequest req, HttpServletResponse resp) {
		Cookie cookie = new Cookie("refreshToken", null);
		cookie.setHttpOnly(true);
		cookie.setSecure(false);
		cookie.setPath(req.getContextPath() + "/oauth/token");
		cookie.setMaxAge(0);

		resp.addCookie(cookie);
		resp.setStatus(HttpStatus.NO_CONTENT.value());
	}
}
