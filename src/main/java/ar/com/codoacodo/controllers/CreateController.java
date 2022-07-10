package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import ar.com.codoacodo.connection.AdministradorDeConexiones;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//herencia
//create controller es hijo de 

@WebServlet("/CreateController")
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
		if(con != null) {
			//insert en la db > SQL: INSERT INTO....
			String sql = "INSERT INTO PRODUCTO (nombre, precio,fecha_creacion,imagen,codigo)";
			sql += "VALUES('"+nombre+"',"+precio+",CURRENT_DATE(),'"+imagen+"','"+codigo+"')";
			
			try {
				Statement st = con.createStatement();
				st.execute(sql);
				
				//cierre de conexion 
				con.close();
				
				resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
}
