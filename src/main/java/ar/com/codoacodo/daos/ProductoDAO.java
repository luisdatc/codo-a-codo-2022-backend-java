package ar.com.codoacodo.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.codoacodo.connection.AdministradorDeConexiones;
import ar.com.codoacodo.dto.Producto;

public class ProductoDAO {

	/*metodos del crud*/
	public Producto obtenerPorId(Long id) {
		
		String sql = "SELECT * FROM PRODUCTO WHERE ID="+id; 

		//connection
		//conexion OK
		Connection con = AdministradorDeConexiones.getConnection(); 
		
		Producto prodFromDb = null;
		//statement
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if(rs.next()) {//si existe hay uno solo
				//rs > sacando los datos
				Long idProducto = rs.getLong(1);//tomar la primera columna 
				String nombre = rs.getString(2);
				Float precio = rs.getFloat(3);
				Date fecha = rs.getDate(4);
				String imagen = rs.getString(5);
				String codigo = rs.getString(6);
						
				//campos crear un objeto???
				prodFromDb = new Producto(idProducto,nombre,precio,fecha,imagen,codigo);
			}
		} catch (SQLException e) {
			// errores 
			e.printStackTrace();
		}
		return prodFromDb;
	}
	
	
	public List<Producto> listarProductos() {
		
		String sql = "SELECT * FROM PRODUCTO "; 

		Connection con = AdministradorDeConexiones.getConnection(); 
		
		List<Producto> list = new ArrayList<>();
		//statement
		try {
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {//si existe hay uno solo
				//rs > sacando los datos
				Long idProducto = rs.getLong(1);//tomar la primera columna 
				String nombre = rs.getString(2);
				Float precio = rs.getFloat(3);
				Date fecha = rs.getDate(4);
				String imagen = rs.getString(5);
				String codigo = rs.getString(6);
						
				//campos crear un objeto???
				Producto prodFromDb = new Producto(idProducto,nombre,precio,fecha,imagen,codigo);
				
				list.add(prodFromDb);
			}
			//cierre conexion
			con.close();
			
		} catch (SQLException e) {
			// errores 
			e.printStackTrace();
		}
		return list;
	}
	
	/*crea un producto en la db*/
	public void crearProducto(String nombre, Float precio, String imagen, String codigo) {
		
		Connection con = AdministradorDeConexiones.getConnection(); 
		
		if(con != null) {
			//insert en la db > SQL: INSERT INTO....
			String sql = "INSERT INTO PRODUCTO (nombre, precio,fecha_creacion,imagen,codigo)";
			sql += "VALUES('"+nombre+"',"+precio+",CURRENT_DATE,'"+imagen+"','"+codigo+"')";
			
			try {
				Statement st = con.createStatement();
				st.execute(sql);
				
				//cierre de conexion 
				con.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	public void actualizarProducto(String codigo, String nombre, String precio) {
		Connection con = AdministradorDeConexiones.getConnection(); 
		if(con != null) {

			//update
			String sql ="UPDATE PRODUCTO "
					+ "set NOMBRE ='"+nombre+"', "
					+ "precio='"+precio+"'"
					+ " WHERE codigo = '"+codigo+"'";
			
			try {
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				
				con.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	public List<Producto> buscar(String clave) {
		
		String sql = "SELECT * FROM PRODUCTO WHERE nombre LIKE '%"+clave+"%'";

		Connection con = AdministradorDeConexiones.getConnection(); 
		
		List<Producto> listado = new ArrayList<Producto>();

		//statement
		try {
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			//viene un solo registrp
			if(rs.next()) {//si existe hay uno solo
				//rs > sacando los datos
				Long idProducto = rs.getLong(1);//tomar la primera columna 
				String nombre = rs.getString(2);
				Float precio = rs.getFloat(3);
				Date fecha = rs.getDate(4);
				String imagen = rs.getString(5);
				String codigo = rs.getString(6);
						
				//campos crear un objeto???
				Producto prodFromDb = new Producto(idProducto,nombre,precio,fecha,imagen,codigo);
				
				listado.add(prodFromDb);
			}
		} catch (SQLException e) {
			// errores 
			e.printStackTrace();
		}
		
		return listado;
	}
}
