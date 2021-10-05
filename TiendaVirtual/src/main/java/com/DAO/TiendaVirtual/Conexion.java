package com.DAO.TiendaVirtual;

import java.sql.*;

public class Conexion {
	
	String BD = "DB_Tienda_Ropa_Grupo_2";
	String Login = "root";
	String Password = "Admin_2021";
	String url = "jdbc:mysql://localhost/"+BD;
	
	Connection con=null;
	
	//Constructor de Conexion
	public Conexion()
	{
		try {
			//Obtenemos el driver para Mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obtenemos la Conexion
			con = DriverManager.getConnection(url,Login,Password);
			
			if (con!=null) {
				System.out.println("Conexión a base de datos "+BD+" Exitosa\n");
			}
		}
		catch(SQLException e) {
			System.out.println("Error de Conexion SQL" +e);
		}catch(ClassNotFoundException e) {
			System.out.println("Error Clase no Encontrada" +e);
		}catch(Exception e) {
			System.out.println("Error de Conexion" +e);
		}
	}
	/**Permite retornar la Conexion*/
	public Connection getCon() {
		return con;
	}
	public void desconectar() {
		con = null;
	}
}
