package Practica4;

import java.io.Serializable;

public class DTOUsuarios implements Serializable {
//Datos de nuestra tabla
	private String nombre;
	private String apellido;
	private String email;
	private String dni;

	public DTOUsuarios() {
		this.nombre="";
		this.email="";
		this.dni="";
		this.apellido="";
	}
	
	public DTOUsuarios(String nombre, String apellido, String email, String dni) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.email=email;
		this.dni=dni;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
}
