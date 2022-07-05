package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.sql.Connection;

import ar.com.codoacodo.connection.AdministradorDeConexiones;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//herencia
//create controller es hijo de 


public class CreateController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recibe los datos del front
		
		//pedir una conexion 
		//en req viene los datos que manda el formulario html
		//clave = valor 
		



		String nombre = req.getParameter("nombre");
		String precio = req.getParameter("precio");//convertir en float
		String fechaCreacion = ""; //damos nosotros
		String imagen = req.getParameter("imagen");
		String codigo = req.getParameter("codigo");
		//pedir una conexion: administradorDeConecion.getConection()
		Connection con = AdministradorDeConexiones.getConnection(); 
		if(con !=null) {

			String sql = 	"INSERT INTO PRODUCTO (nombre, precio,fecha_creacion,imagen,codigo)";
			sql += "VALUES('"+nombre+"',"+precio+",CURDATE(),'"+imagen+"','"+codigo+"')";
			
			//
			
		}
		
		
	}
	
	
}
