package com.alura.gerenciador.servlet;

import java.io.IOException;

import com.alura.gerenciador.accion.Accion;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = "/entrada")
public class ControladorFilter implements Filter {

	public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain chain) 
			throws IOException, ServletException {
		
		System.out.println("ControladorFilter");
		
		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		HttpServletResponse response = (HttpServletResponse) ServletResponse;
		String paramAccion = request.getParameter("accion");
		
		String nombreDeClase = "com.alura.gerenciador.accion."+paramAccion;
		String nombre;
		try {
			Class clase = Class.forName(nombreDeClase);
			Accion accion = (Accion)clase.newInstance();
		    nombre = accion.ejecutar(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] tipoYDireccion = nombre.split(":");
		
        if(	tipoYDireccion[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+ tipoYDireccion[1]);
			rd.forward(request, response);
        }else{
		    response.sendRedirect(tipoYDireccion[1]);
        }
        
	}
		
}
