<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="common/Header.jspf" %>
</head>

<body>
<%@ include file="common/NavigatorCommon.jspf" %>
	<div class="container-fluid">
			<form id="homeForm" method="post">
				<div class="container">
					<div class="p-2 mb-2 bg-light border rounded-3" style="width: 100%">
						<div class="container-fluid py-1">
							<div class="row align-items-md-stretch">
								<div class="col-md-4" style="text-align: center;">
									<img class="img-responsive p-3" style="width: 80%;" src="<c:url value="/assets/logo.png"/>"/>
									<h1>¡Hola!</h1>
									<p>
										Si aun no tienes cuenta, puedes registrarte haciendo click en el boton de abajo.
									</p>
									<input type="submit" class="btn btn-success mr-1" value="REGISTRARSE" name="btnRedirigir" formaction="Home.html">
								</div>

								<div class="col-md-8" style="text-align: center;">
									<div class="d-flex col col-12 mh-2 justify-content-center p-2">
										<div class="row w-auto justify-content-center">
											<img class="img-responsive p-3" style="width: 30%;" src="<c:url value="/assets/login.png"/>"/>

											<input class="form-control mt-2" placeholder="Ingrese usuario">
									

											<input class="form-control mt-2" type="password" placeholder="Ingrese contraseña">
									
											<input type="submit" class="btn btn-primary mt-2" value="INGRESAR" name="btnRedirigir" formaction="Home.html">
										</div>

									</div>

									<hr>
								</div>
							</div>

						</div>
					</div>
				</div>
			</form>
		</div>
	</body>

	</html>