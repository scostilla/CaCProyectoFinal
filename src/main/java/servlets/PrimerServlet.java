package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrimerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("doGet - Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombreInput");
		String apellido= request.getParameter("apellidoInput");
		String tema= request.getParameter("temaInput");

		System.out.println("nombre y apellido ingresado: "+nombre+" "+apellido+" - Tema: "+tema);
		//response.getWriter().write("nombre y apellido ingresado: "+nombre+" "+apellido+" creado correctamente");
		response.sendRedirect("confirmacion.html");
		
		
	}
	
	

}
