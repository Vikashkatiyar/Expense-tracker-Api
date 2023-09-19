package com.learning.expensetracker.filters;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.server.WebFilterChain;

import com.learning.expensetracker.Constants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String authHeader = httpRequest.getHeader("Authorization");
		if (authHeader != null) {
			String[] authHeaderArr = authHeader.split("Bearer ");
			if (authHeaderArr.length > 1 && authHeaderArr[1] != null) {
				String token = authHeaderArr[1];
				try {
					Claims claims = Jwts.parser().setSigningKey(Constants.API_SECRET_KEY).parseClaimsJws(token)
							.getBody();
					httpRequest.setAttribute("userId", Integer.parseInt(claims.get("userId").toString()));
				} catch (Exception e) {
					httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "invalid/expired token");
					return;
				}
			} else {
				httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be Bearer [token]");
				return;
			}
		} else {
			httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be provided");
			return;
		}
		chain.doFilter(request, response);
	}

}
