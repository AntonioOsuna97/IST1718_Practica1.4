package Practica4;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String usuario = request.getParameter("username");
		String pass = request.getParameter("pass");
		//url a asignar dependiendo de si es administrador o no.
		String url="";
		DAOUsuarios du = new DAOUsuarios();
		ArrayList <DTOUsuarios> lista = du.leeUsuarios();
		//Posicion para recorrer la lista
		int posicion=0;
		for(posicion=0;posicion<lista.size();posicion++) {
			if(lista.get(posicion).getNombre().equals(usuario) && usuario.equals("Admin")
					&& lista.get(posicion).getPassword().equals(pass)) {
				request.setAttribute("nombre", lista.get(posicion).getNombre());
				request.setAttribute("password", lista.get(posicion).getPassword());
				request.setAttribute("email", lista.get(posicion).getEmail());
				request.setAttribute("dni", lista.get(posicion).getDni());
				url="/WEB-INF/usuario.jsp";
			}else if(lista.get(posicion).getNombre().equals(usuario) && !usuario.equals("Admin")
			&& lista.get(posicion).getPassword().equals(pass))  {
				request.setAttribute("nombre", lista.get(posicion).getNombre());
				request.setAttribute("password", lista.get(posicion).getPassword());
				request.setAttribute("email", lista.get(posicion).getEmail());
				request.setAttribute("dni", lista.get(posicion).getDni());
				url="/WEB-INF/usuariodatos.jsp";
			}
			
		}
		
		
		//Significa que el usuario no existe
		if(!url.equals("/WEB-INF/usuario.jsp") && !url.equals("/WEB-INF/usuariodatos.jsp")) {
			url="/WEB-INF/registro.html";
		}
		
		request.setAttribute("lista", lista);
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

