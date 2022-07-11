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


@WebServlet("/api/EliminarController")
public class EliminarController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");

		
		//pedir una conexion: administradorDeConecion.getConection()
		Connection con = AdministradorDeConexiones.getConnection(); 
		if(con != null) {
			//delete
			String sql = "DELETE FROM PRODUCTO WHERE id="+id; 
			
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				
				//cierre de conexion 
				con.close();
				
				resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
}
