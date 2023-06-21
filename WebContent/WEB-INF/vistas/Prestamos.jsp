<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <html>

      <head>

          <script type="text/javascript">
            $(document).ready(function () {
              $('#tabla_prestamos').DataTable();
            });

          </script>
	<%@ include file="common/Header.jspf"%>
</head>

<body>
	<%@ include file="common/NavigatorCommon.jspf"%>
          <div class="container-fluid">
            <form action="articulos.html" method="post">
              <div class="p-5 bg-light border rounded-3" style="width: 100%">
                <div class="d-flex  align-content-center bd-highlight mb-3">
                  <div class="me-auto p-2 bd-highlight align-self-center">
                    <h1>PRESTAMOS</h1>
                  </div>
                  <div class="p-2 bd-highlight align-self-center">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addItemModal">
                      AGREGAR PRESTAMO
                    </button>
                  </div>
                </div>

                <div class="row mx-2 d-flex flex-wrap align-middle justify-content-evenly">
                  <div class="col-md-auto table-responsive w-100">
                    <table id="tabla_articulos" class="table table-hover text-center">
                      <thead>
                        <tr>
                          <th class="text-center" scope="col"> Numero </th>
                          <th class="text-center" scope="col"> Fecha </th>
                          <th class="text-center" scope="col"> DNI </th>
                          <th class="text-center" scope="col"> Nombre y apelldio </th>
                          <th class="text-center" scope="col"> Monto </th>
                          <th class="text-center" scope="col"> Cuotas </th>
                          <th></th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${listaPrestamos}" var="item">
                          <c:if test="${item.monto > 0}">                        
                          <tr>
                            <td>${item.numPrestamo} </td>
                            <td>${item.fecha}</td>
                            <td>${item.cliente.DNI}</td>
                            <td>${item.cliente.nombre + ' ' + item.cliente.apellido}</td>
                            <td>${item.monto}</td>
                            <td>${item.cuotas}</td>
                            <td>
                              <button type="button" class="btn btn-success" data-bs-toggle="modal"
                                data-bs-target="#modifyItemModal">
                                MODIFICAR
                              </button>
                            </td>
                            <td>
                              <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#deleteItemModal">
                                ELIMINAR
                              </button>
                            </td>
                          </c:if>
                        </c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </form>
            <div class="row align-items-md-stretch">
             <div class="d-flex justify-content-center" style="text-align: center;">
                	<h3 class="w-auto">${Mensaje}</h3>	
             </div>
             </div>
          </div>

          <!-- Modal ELIMINAR PRESTAMO -->
          <div class="modal fade" id="deleteItemModal" tabindex="-1" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                <form action="eliminar_prestamo.html" method="post">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">¿DESEA ELIMINAR EL SIGUIENTE PRESTAMO?</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">                  
                  	 <!--  AGREGAR CUERPO DEL MODAL -->                            
                  </div>                   
                  <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">CANCELAR</button>
                    <input type="submit" class="btn btn-primary" name="btnAceptar" value="Aceptar">
                  </div>
                </form>
              </div>
            </div>
          </div>

          <!-- Modal MODIFICAR PRESTAMO -->
          <div class="modal fade" id="modifyItemModal" tabindex="-1" aria-labelledby="exampleModalLabel"
            aria-hidden="true">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                <form action="modificar_prestamo.html" method="post">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">MODIFICAR PRESTAMO</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                   	
                   	<!--  AGREGAR CUERPO DEL MODAL -->  

                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">CANCELAR</button>
                    <input type="submit" class="btn btn-primary" name="btnAceptar" value="Aceptar">
                  </div>
                </form>
              </div>
            </div>
          </div>

          <!-- Modal AGREGAR PRESTAMO -->
          <div class="modal fade" id="addItemModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                <form action="alta_prestamo.html" method="post">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">AGREGAR PRESTAMO</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <!--  AGREGAR CUERPO DEL MODAL -->  
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">CANCELAR</button>
                    <input type="submit" class="btn btn-primary" name="btnAceptar" value="Aceptar">
                  </div>
                </form>
              </div>
            </div>
          </div>

      </body>

      </html>