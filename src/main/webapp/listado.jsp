<%@page import="java.util.List"%>
<%@page import="ar.com.codoacodo.dto.Producto"%>
<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	</head>

	<body>
		<!-- ACA VA EL NAVBAR -->
		<%@include file="navbar.jsp" %>
		<main>
			<div class="container">
				<section>
					<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">ID</th>
					      <th scope="col">NOMBRE</th>
					      <th scope="col">PRECIO</th>
					      <th scope="col">C&Oacute;ODIGO</th>
					    </tr>
					  </thead>
					  <%
					  //codigo java
					  //obtener el listado desde el request
					  //se guardo bajo el nombre listado
					  List<Producto> listado = (List<Producto>)request.getAttribute("listado");
					  %>
					  <tbody>
					  <!-- ESTO SE REPITE TANTA CANTIDAD DE VECES COMO ARTICULOS TENGA -->
					  <%
					  for( Producto unProducto : listado) {
					  %>
					    <tr>
					      <th scope="row"> <%=unProducto.getIdProducto()%>     </th>
					      <td><%=unProducto.getNombre()%></td>
					      <td><%=unProducto.getPrecio()%></td>
					      <td><%=unProducto.getCodigo()%></td>
					    </tr>
					    <%
					  	 }
					    %>
					  </tbody>
					</table>
				</section>
			</div>
		</main>
	</body>
</html>