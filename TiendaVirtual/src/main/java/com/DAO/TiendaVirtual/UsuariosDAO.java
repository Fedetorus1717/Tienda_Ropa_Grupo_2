package com.DAO.TiendaVirtual;

//Esta clase permite el acceso a la base de datos y realizar CRUD

import java.sql.*;
import java.util.ArrayList;


import com.DTO.TiendaVirtual.UsuariosVO;

public class UsuariosDAO {
	
	//Consultar Usuarios
	
	public ArrayList<UsuariosVO> ListaUsuarios()
	{
		ArrayList<UsuariosVO> MiLista = new ArrayList<UsuariosVO>();
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement Consulta = con.getCon().prepareStatement("SELECT * FROM T_Usuarios");
			ResultSet rs = Consulta.executeQuery();
			while(rs.next())
			{
				UsuariosVO Persona = new UsuariosVO();
				Persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usua")));
				Persona.setNombre(rs.getString("Nombre_Usua"));
				Persona.setCorreo(rs.getString("Correo_Usua"));
				Persona.setUsuario(rs.getString("Usuario"));
				Persona.setClave(rs.getString("Clave"));
				
				MiLista.add(Persona);
			}
			rs.close();
			Consulta.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error de Conexion: " + e);
		}
		
		return MiLista;
	}
	
	public ArrayList<UsuariosVO> ConsultarUsuario(int Documento)
	{
		ArrayList<UsuariosVO> MiLista = new ArrayList<UsuariosVO>();
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement Consulta = con.getCon().prepareStatement("SELECT * FROM T_Usuarios WHERE Cedula_Usua =?");
			Consulta.setInt(1, Documento);
			ResultSet rs = Consulta.executeQuery();
			if(rs.next()) 
			{
				UsuariosVO Persona = new UsuariosVO();
				Persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usua")));
				Persona.setNombre(rs.getString("Nombre_Usua"));
				Persona.setCorreo(rs.getString("Correo_Usua"));
				Persona.setUsuario(rs.getString("Usuario"));
				Persona.setClave(rs.getString("Clave"));
				
				MiLista.add(Persona);
			}
			rs.close();
			Consulta.close();
			con.desconectar();
		}	
		catch(Exception e)
		{
			System.out.println("Error de Conexion: " + e);
		}
		return MiLista;
	}
	
	public void RegistrarUsuario(UsuariosVO Persona)
	{
		Conexion con = new Conexion();
		
		try
		{
			Statement Stmt = con.getCon().createStatement();
			Stmt.executeUpdate("INSERT INTO T_Usuarios Values ('"+Persona.getCedula()+"','"
			+Persona.getNombre()+"','"+Persona.getCorreo()+"','"+Persona.getUsuario()+"','"
			+Persona.getClave()+"')");
			System.out.println("Usuario se Registro Exitosamente");
			Stmt.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error de Conexion: " + e);
		}
		
	}
	public void EliminarUsuario(int Documento)
	{
		
		Conexion con = new Conexion();
		Statement Stmt = null;
		
		try
		{
			Stmt = con.getCon().createStatement();
			Stmt.executeUpdate("DELETE FROM T_Usuarios WHERE Cedula_Usua ='"+ Documento + "'");
			System.out.println("Usuario Eliminado");
		}
		catch(SQLException e)
		{
			System.out.println("Error de Conexion: " + e);
		}
	}
	
	public void ActualizarUsuario(int Documento, String Nombre, String Correo)
	{
		
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement Sql = con.getCon().prepareStatement("UPDATE T_Usuarios SET Nombre_Usua=?, Correo_Usua=? WHERE Cedula_Usua = ?");
			Sql.setString(1, Nombre);
			Sql.setString(2,Correo);
			Sql.setInt(3,Documento);
			Sql.executeUpdate();
			System.out.println("Se Actualizo la Informacion del Usuario");
		}
		catch(SQLException e)
		{
			System.out.println("Error de Conexion: " + e);
		}
	}
}
