package Practica4;

import java.util.ArrayList;

public interface DAOUsuariosInterfaz {

	public ArrayList<DTOUsuarios> leeUsuarios();
	
	public boolean buscarUsuario(String nombre, String password);
	
	public void addUsuario(String nombre, String password, String email, String dni);
	
	
}
