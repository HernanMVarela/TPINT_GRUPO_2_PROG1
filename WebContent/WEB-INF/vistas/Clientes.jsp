<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
$(document).ready( function () {
    $('#tabla_clientes').DataTable();
} );
</script>
<%@ include file="common/Header.jspf"%>
</head>

<body>
	<%@ include file="common/NavigatorCommon.jspf"%>

<div class="container-fluid">
	<div class="p-5 bg-light text-dark border rounded-3" style="width: 100%">
		<form action="clientes.html" method="post">
			<div class="d-flex  align-content-center bd-highlight mb-3">
				<div class="me-auto p-2 bd-highlight align-self-center">
					<h1 >CLIENTES</h1>
				</div>
				<div class="p-2 bd-highlight align-self-center">
					<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addClientModal">
			  			AGREGAR CLIENTE
					</button>
				</div>		
			</div>
	
		  <div class="row mx-2 d-flex flex-wrap align-middle justify-content-evenly">
			  <div class="col-md-auto table-responsive w-100">
                    <table id="tabla_clientes" class="table table-hover text-center">
                      <thead>
                        <tr>
                          <th class="text-center" scope="col"> DNI </th>
                          <th class="text-center" scope="col"> Nombre </th>
                          <th class="text-center" scope="col"> Apellido </th>
                          <th class="text-center" scope="col"> Dirección </th>
                          <th class="text-center" scope="col"> CP </th>
                          <th class="text-center" scope="col"> Provincia </th>
                          <th class="text-center" scope="col"> Nacionalidad </th>
                          <th class="text-center" scope="col"> Fecha de nacimiento </th>
                          <th class="text-center" scope="col"> Email </th>
                          <th class="text-center" scope="col"> Telefono </th>
                          <th></th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${listaClientes}" var="item">
                          <c:if test="${item.estado eq true}">                        
                          <tr>
                            <td>${item.persona.DNI} </td>
                            <td>${item.persona.nombre}</td>
                            <td>${item.persona.apellido}</td>
                            <td>${item.direccion}</td>
                            <td>${item.codpostal}</td>
                            <td>${item.Localidad.provincia.getNombre()}</td>
                            <td>${item.nacionalidad}</td>
                            <td>${item.persona.fecha_nac}</td>
                            <td>${item.persona.correo}</td>
                            <td>${item.persona.telefono}</td>
                            <td>
                              <button type="button" class="btn btn-success" data-bs-toggle="modal"
                                data-bs-target="#modifyItemModal" 
                                onclick="abrirModificarModal('${item.nombre}',
                                                             '${item.marca}',
                                                             '${item.descripcion}',
                                                             '${item.tipo}',
                                                             '${item.precio_venta}',
                                                             '${item.estado}')">
                                MODIFICAR
                              </button>
                            </td>
                            <td>
                              <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#deleteItemModal" onclick="abrirEliminarModal('${item.nombre}',
                                                                                              '${item.marca}',
                                                                                              '${item.descripcion}',
                                                                                              '${item.tipo}',
                                                                                              '${item.precio_venta}',
                                                                                              '${item.estado}')">
                                ELIMINAR
                              </button>
                            </td>
                          </c:if>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
		  	</div>		
		</form>
		<div class="row align-items-md-stretch">
            <div class="d-flex justify-content-center" style="text-align: center;">
               	<h3 class="w-auto">${Mensaje}</h3>	
            </div>
       </div>
	</div>	
</div>

<!-- Modal ELIMINAR CLIENTE -->
<div class="modal fade" id="deleteClientModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">ELIMINAR CLIENTE</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ¿DESEA ELIMINAR EL CLIENTE SELECCIONADO?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">CANCELAR</button>
        <button type="button" class="btn btn-success">CONFIRMAR</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal MODIFICAR CLIENTE -->
<div class="modal fade" id="modifyClientModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">MODIFICAR CLIENTE</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
       <div class="row align-items-md-stretch">
     	   <div class="form-group col-md-4">
               <label style="float: left">Apellido</label>
               <input class="form-control" placeholder="Ingrese apellido">
           </div>
           <div class="form-group col-md-4">
               <label style="float: left">Nombre</label>
               <input class="form-control" placeholder="Ingrese nombre">
           </div>
           <div class="form-group col-md-4">
               <label style="float: left">Sexo</label>
			   <input class="form-control" placeholder="Ingrese nombre">
           </div>           
       </div>
       
       <div class="row align-items-md-stretch mt-1">
           <div class="form-group col-md-9">
               <label style="float: left">DNI</label>
               <input type="number" name="DNI" class="form-control" placeholder="Ingrese DNI">
           </div>
           <div class="form-group col-md-3">
               <label style="float: left">Fecha de Nacimiento</label>
               <input class="form-control" type="date" name="date">
           </div>
       </div>

       <hr>
       
        <div class="row align-items-md-stretch">
     	   <div class="form-group col-md-6">
               <label style="float: left">Direccion</label>
               <input class="form-control" placeholder="Ingrese direccion">
           </div>
           <div class="form-group col-md-6">
               <label style="float: left">Localidad</label>
               <input class="form-control" placeholder="Ingrese localidad">
           </div>                   
       </div>
       
       <hr>
       
        <div class="row align-items-md-stretch">
     	   <div class="form-group col-md-6">
               <label style="float: left">Correo Electronico</label>
               <input class="form-control" placeholder="Ingrese correo electronico">
           </div>
           <div class="form-group col-md-6">
               <label style="float: left">Numero de Telefono</label>
               <input class="form-control" type="number" placeholder="Ingrese numero de telefono">
           </div>                   
       </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">CANCELAR</button>
        <button type="button" class="btn btn-success">CONFIRMAR</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal AGREGAR CLIENTE -->
<form action="alta_cliente.html" method="post">
<div class="modal fade" id="addClientModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">AGREGAR CLIENTE</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="row align-items-md-stretch">
     	   <div class="form-group col-md-4">
               <label style="float: left">Apellido</label>
               <input class="form-control" name="apellidoNuevo" placeholder="Ingrese apellido">
           </div>
           <div class="form-group col-md-4">
               <label style="float: left">Nombre</label>
               <input class="form-control" name="nombreNuevo" placeholder="Ingrese nombre">
           </div>
           <div class="form-group col-md-4">
                <label style="float: left">DNI</label>
				<input type="number" name="DNINuevo" class="form-control" placeholder="Ingrese DNI">
           </div>           
       </div>
       
       <div class="row align-items-md-stretch mt-1">
           <div class="form-group col-md-6">
               <label style="float: left">Nacionalidad</label>
               <input class="form-control" type="text" name="nacioNuevo">
           </div>
           <div class="form-group col-md-6">
               <label style="float: left">Fecha de nacimiento</label>
               <input class="form-control" type="date" name="fechaNuevo">
           </div>
       </div>

       <hr>
       
       <div class="row align-items-md-stretch mt-1">
           <div class="form-group col-md-6">
               <label style="float: left">Dirección</label>
               <input class="form-control" type="text" name="direcNuevo">
           </div>
           <div class="form-group col-md-2">
               <label style="float: left">CP</label>
               <input class="form-control" type="text" name="codpostalNuevo">
           </div>
           <div class="form-group col-md-4">
               <label style="float: left">Localidad</label>
               <select class="form-select" name="localidad">
			   	<c:forEach items="${listaLocalidades}" var="Localidad">
			       <option id="${Localidad.ID}" value="${Localidad.ID}">${Localidad.nombre}</option>
			   	</c:forEach>
			   </select>
           </div>
       </div>
       
       <hr>
       
        <div class="row align-items-md-stretch">
     	   <div class="form-group col-md-6">
               <label style="float: left">Correo Electronico</label>
               <input class="form-control" placeholder="Ingrese correo electronico">
           </div>
           <div class="form-group col-md-6">
               <label style="float: left">Numero de Telefono</label>
               <input class="form-control" type="number" placeholder="Ingrese numero de telefono">
           </div>                   
       </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">CANCELAR</button>
        <input type="submit" class="btn btn-primary" name="btnAceptar" value="Aceptar">
      </div>
    </div>
  </div>
</div>
</form>
	
</body>
</html>