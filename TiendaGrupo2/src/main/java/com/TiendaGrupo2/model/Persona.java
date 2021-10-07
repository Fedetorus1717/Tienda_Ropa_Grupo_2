package com.TiendaGrupo2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_Usuarios")
public class Persona {
	
	@Id
	private int Cedula;
	private String Nombre;
	private String Correo;
	private String Usuario;
	private String Clave;
	
	public Persona()
	{
		
	}

	public Persona(int cedula, String nombre, String correo, String usuario, String clave) {
		super();
		Cedula = cedula;
		Nombre = nombre;
		Correo = correo;
		Usuario = usuario;
		Clave = clave;
	}

	public int getCedula() {
		return Cedula;
	}

	public void setCedula(int cedula) {
		Cedula = cedula;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}
	
}
