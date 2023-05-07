package com.alura.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebFilter(urlPatterns = "/entrada")
public class AutorizacionFilter implements Filter {

	public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain chain) 
			throws IOException, ServletException {
		
		System.out.println("AutorizacionFilter");
		
		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		String paramAccion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
		
		Boolean esUnUsuarioNoLogado = (sesion.getAttribute("loginUsuario")==null);
		Boolean esUnaAccionProtegida = !(paramAccion.equals("Login") || paramAccion.equals("LoginForm"));
		
		if(esUnUsuarioNoLogado && esUnaAccionProtegida) {
			response.sendRedirect("entrada?accion=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}


}
