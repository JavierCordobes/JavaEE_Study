package ejercicio5;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AgregarLinea")
public class AgregarLinea extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		
		
		HttpSession session = request.getSession();
		List<Linea> lista;
		Linea l = new Linea();

		l.setCodigo(Integer.valueOf(request.getParameter("codigo")));
		l.setNombre(request.getParameter("nombre"));
		l.setCantidad(Integer.valueOf(request.getParameter("cantidad")));

		if (session.getAttribute("LISTA") != null) {
			lista = (List<Linea>) session.getAttribute("LISTA");
		}else {
			lista = new ArrayList<Linea>();
			session.setAttribute("LISTA", lista);
			
		}
				lista.add(l);

		request.getRequestDispatcher("ejercicio5.jsp").forward(request, response);
	}

}
