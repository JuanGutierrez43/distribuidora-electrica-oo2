package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.LecturaABM;
import datos.Lectura;

public class ControladorMostrarLecturaJSP extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			long id = Integer.parseInt(request.getParameter("idLectura"));
			LecturaABM lecturaABM = LecturaABM.getInstance();
			Lectura lectura = lecturaABM.traer(id);
			request.setAttribute("lectura", lectura);
			request.getRequestDispatcher("/lectura.jsp").forward(request, response);
		} catch (Exception e) {
			response.sendError(500, "El ID Ingresado no existe en la base de datos.");
		}
	}
}