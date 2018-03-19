package Practica4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Parameter(...) es del html
		String usuario = request.getParameter("username");
		//Lo añadimos a la petición.
		request.setAttribute("Nombre", usuario);
		
		String password = request.getParameter("pass");
		//Lo añadimos a la petición.
		request.setAttribute("Password", password);
		
		String email = request.getParameter("email");
		//Lo añadimos a la petición.
		request.setAttribute("Email", email);	
		
		String dni = request.getParameter("dni");
		//Lo añadimos a la petición.
		request.setAttribute("DNI", dni);
		
		DTOUsuarios dto = new DTOUsuarios(usuario, password, email, dni);
		DAOUsuarios du = new DAOUsuarios();
		ArrayList <DTOUsuarios> lista = du.leeUsuarios();
		PrintWriter out = response.getWriter();
		if(lista.equals(dto)) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Usuario ya registrado correctamente</h1>");
			out.println("</body>");
			out.println("</html>");	
		}else {
			du.addUsuario(usuario, password, email, dni);
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Usuario registrado correctamente</h1>");
			out.println("</body>");
			out.println("</html>");	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
