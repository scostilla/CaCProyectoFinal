package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import infraestructure.persistence.IPersistence;
import infraestructure.persistence.mysql.MysqlRepositoryImpl;
import mappers.OradorMapper;
import models.Orador;

@WebServlet(urlPatterns = "/endpoint")
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IPersistence sistemaPersistencia = new MysqlRepositoryImpl();
	OradorMapper mapper = new OradorMapper();

	public PrimerServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.err.println("******************************doGet******************************");

		ArrayList<Orador> oradores = sistemaPersistencia.getAll();

		String oradoresJson = mapper.toJson(oradores);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().write(oradoresJson);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.err.println("******************************doPost******************************");
		String nombre = request.getParameter("nombreInput");
		String apellido = request.getParameter("apellidoInput");
		String tema = request.getParameter("temaInput");

		System.out.println("nombre y apellido ingresado: " + nombre + " " + apellido + " - Tema: " + tema);

		Orador orador = new Orador(nombre, apellido, tema);

		sistemaPersistencia.guardarOrador(orador);

		String oradorJsonFake = String.format(

				"{\"id\": \"%s\", \"nombre\": \"%s\"  }",
				orador.getId(), orador.getNombre()

		);

		OradorMapper mapper = new OradorMapper();

		String oradorJson = mapper.toJson(orador);

		response.getWriter().write(oradorJson);

	}

}
