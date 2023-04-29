package com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/HolaMundoServlet")
public class HolaMundoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		PrintWriter out = resp.getWriter(); 
		out.println("<html>");
		out.println("<body>");
		out.println("Hola Mundo Felicidades Por Crear Tu Primer Servlet");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("se ejecuto el servlet");
		
	}

}
