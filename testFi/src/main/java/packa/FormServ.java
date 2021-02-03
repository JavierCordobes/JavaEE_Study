package packa;

import java.io.IOException;
import java.io.PrintWriter;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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

		
		out.println("<h1> usuario: " + usuario + "</h1>");
		out.println("<h1> password: " + password + "</h1>");
		for(String t: tecnologia) {
			out.println("<h1> tecnologia: " + t + "</h1>");
		}	
		out.println("<h1> genero: " + genero + "</h1>");
	
		out.println("<h1> ocupacion: " + usuario + "</h1>");
		for(String l: libreta) {
			out.println("<h1> libreta: " + l + "</h1>");
		}
		
		out.println("<h1> comentario: " + comentario + "</h1>");
		out.close();
	}

}
