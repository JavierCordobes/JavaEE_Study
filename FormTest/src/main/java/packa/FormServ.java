package packa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServ
 */
public class FormServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String[] tecnologia = request.getParameterValues("tecnologia");
		String genero = request.getParameter("genero");
		String ocupacion = request.getParameter("ocupacion");
		String[] libreta = request.getParameterValues("libreta");
		String comentario = request.getParameter("comentario");

		out.print("<html>");
		out.print("<head>");
		out.print("<title>Datos del Formulario</title>");
		out.print("</head>");

		out.print("<body>");
		out.print("<h3>Datos Recibidos desde el Formulario:</h3>");
		out.println("Usuario: " + usuario);
		out.print("<br>");
		out.println("Password: " + password);
		out.print("<br>");
		for (String t : tecnologia) {
			out.println("Tecnologia: " + t);
			out.print("<br>");
		}
		out.println("Genero: " + genero);
		out.print("<br>");

		out.println("Ocupacion: " + ocupacion);
		out.print("<br>");

		if (libreta != null) {
			for (String l : libreta) {
				out.println("Libreta:  " + l);
				out.print("<br>");
			}
		}
		out.println("Comentario: " + comentario);
		out.print("<br>");
		out.print("<br>");
		out.print("<br>");

		// importo los headers para ver la informacion
		out.print("<h3>Info de los headers</h3>");
		out.print("<br>");

		Enumeration headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String headerSelect = (String) headers.nextElement();

			out.print("<b>" + headerSelect + ":</b> ");

			out.print(request.getHeader(headerSelect));
			out.print("<br>");

		}

		out.print("</body>");
		out.print("</html>");

		out.close();
	}

}
