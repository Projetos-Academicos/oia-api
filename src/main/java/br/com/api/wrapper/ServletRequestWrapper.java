package br.com.api.wrapper;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.catalina.util.ParameterMap;

public class ServletRequestWrapper extends HttpServletRequestWrapper{

	private String refreshToken;

	public ServletRequestWrapper(HttpServletRequest request, String refreshToken) {
		super(request);
		this.refreshToken = refreshToken;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		ParameterMap<String, String[]> map = new ParameterMap<>(this.getRequest().getParameterMap());
		map.put("refresh_token", new String[] {this.refreshToken});
		map.setLocked(true);
		return map;
	}

}
