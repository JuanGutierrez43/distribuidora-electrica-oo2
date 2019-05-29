package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import datos.Lectura;
import negocio.LecturaABM;

public class ControladorMostrarLectura extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			try {
				long id = Integer.parseInt(request.getParameter("idLectura"));
				LecturaABM lecturaAbm = LecturaABM.getInstance();
				Lectura lectura = lecturaAbm.traer(id);
				response.setStatus(200);
				PrintWriter salida = response.getWriter();
				salida.println( "" );
				salida.println( "<!DOCTYPE 4.01 Transitional//EN\">" );
				salida.println( "<HTML>" );
				salida.println( " <HEAD>" );
				salida.println( " <TITLE>EdeUNLa</TITLE>" );
				salida.println( " </HEAD>" );
				salida.println( " <BODY>" );
				salida.println( " ID : " +lectura.getIdLectura()+ "<BR>" );
				salida.println( " Fecha : " +lectura.getFecha()+ "<BR>" );
				salida.println( " Inspector: " +lectura.getInspector()+ "<BR>" );
				salida.println( " Medidor : " +lectura.getMedidor()+ "<BR>" );
				salida.println( "<A href=\"/EdeUNLa/index.html\">Volver...</A>" );
				salida.println( " </BODY>" );
				salida.println( "</HTML>" );
			}catch (Exception e) {
				response.sendError(500, "El ID Ingresado no existe en la base de datos." );
			}
	}
}