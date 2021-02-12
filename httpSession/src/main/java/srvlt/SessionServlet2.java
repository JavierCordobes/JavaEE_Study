package srvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet2
 */

@WebServlet("/SessionServlet2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();

		String titulo = null;
		// pedir el atributo contadorVisitas a la session
		Integer contadorVisitas = (Integer) session.getAttribute("contadorVisitas");
		// si es nulo es la primera vez que accedemos a la session
		if (contadorVisitas == null) {
			contadorVisitas = 1;
			titulo = "Bienvenido por primera vez";
		} else {
			contadorVisitas++;
			titulo = "Bienvenido de nuevo";
		}
		// agerga nuevo valor a la session
		session.setAttribute("contadorVisitas", contadorVisitas);

		PrintWriter out = response.getWriter();
		out.print(titulo);
		out.print("<br/>");
		out.print("nro de accesos al recurso: " + contadorVisitas);
		out.print("<br/>");
		out.print("ID de la session:" + session.getId());
	}
}
