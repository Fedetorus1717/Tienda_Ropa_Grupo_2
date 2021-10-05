package com.Controlador.TiendaVirtual;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TiendaVirtual.UsuariosDAO;
import com.DTO.TiendaVirtual.UsuariosVO;

@RestController
public class UsuarioController {
	
	@RequestMapping("/ListaUsuarios")
	public ArrayList<UsuariosVO> ListaUsuarios()
	{
		UsuariosDAO Dao = new UsuariosDAO();
		return Dao.ListaUsuarios();
	}
	
	@RequestMapping("/ConsultarUsuarios")
	public ArrayList<UsuariosVO> ConsultarUsuario(int Documento)
	{
		UsuariosDAO Dao = new UsuariosDAO();
		return Dao.ConsultarUsuario(Documento);
	}
	
	@RequestMapping("/RegistrarUsuarios")
	public void RegistrarUsuario(UsuariosVO Persona)
	{
		UsuariosDAO Dao = new UsuariosDAO();
		Dao.RegistrarUsuario(Persona);
	}
	
	@RequestMapping("/EliminarUsuarios")
	public void EliminarUsuario(int Documento)
	{
		UsuariosDAO Dao = new UsuariosDAO();
		Dao.EliminarUsuario(Documento);
	}
	@RequestMapping("/ActualizarUsuarios")
	
	public void ActualizarUsuario(int Documento, String Nombre, String Correo)
	{
		UsuariosDAO Dao = new UsuariosDAO();
		Dao.ActualizarUsuario(Documento, Nombre, Correo);
	}
}
