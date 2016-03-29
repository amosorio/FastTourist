<%@include file="header.jsp"%>
<section class="navbar main-menu">
	<div class="navbar-inner main-menu">
		<nav id="menu" class="pull-left">
			<ul>
				<li><a href="/presentacion/">Alojamiento</a></li>
				<li><a href="/presentacion/transporte/">Transporte</a>
				<li><a href="/presentacion/alimentacion/">Alimentación</a></li>
				<li><a href="/presentacion/paseos/paseos">Paseos Turísticos</a></li>
				<li><a href="/presentacion/paquetes/">Paquetes</a></li>
			</ul>
		</nav>
	</div>
</section>
<section class="header_text sub">
	<img class="pageBanner"
		src="${pageContext.request.contextPath}/resources/themes/images/pageBanner.png"
		alt="New products">
</section>
<section class="main-content" style="margin-top: -25px">
	<h4 class="title" align="center">
		<span class="text">Registro y Autenticación</span>
	</h4>
	<div class="row">
		<div class="span5">
			<h4 class="title">
				<span class="text"><strong>Formulario </strong> de
					Autenticación</span>
			</h4>
			<form action="/registro/auth" method="post">
				<input type="hidden" name="next" value="/">
				<fieldset>
					<div class="control-group">
						<label class="control-label">Correo Electrónico</label>
						<div class="controls">
							<input type="text" placeholder="Ingresa tu email"
								id="username" name="correo"class="input-xlarge" required="required">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Contraseña</label>
						<div class="controls">
							<input type="password" placeholder="Ingresa tu contraseña"
								id="password" name="password" class="input-xlarge" required="required">
						</div>
					</div>
					<div class="control-group">
						<input tabindex="3" class="btn btn-inverse large" type="submit"
							value="Ingresar">
						<hr>
						<p class="reset">
							Recuperar tu <a tabindex="4" href="#"
								title="Recuperar el usuario o contraseña">Nombre de usuario
								o contraseña</a>
						</p>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="span7">
			<h4 class="title">
				<span class="text"><strong>Formulario</strong> de Registro</span>
			</h4>
			<form action="#" method="post" class="form-stacked">
				<fieldset>
					<div class="control-group">
						<label class="control-label">* Usuario</label>
						<div class="controls">
							<input type="text" name="nombre"
								placeholder="Ingresa tu nombre" class="input-xlarge" required="required">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">* Apellidos</label>
						<div class="controls">
							<input type="text" name="apellido" class="input-xlarge"
								placeholder="Ingresa tus apellidos" required="required">
						</div>
						<div class="control-group">
							<label class="control-label">* Email:</label>
							<div class="controls">
								<input type="text" name="email" placeholder="Ingresa tu email"
									class="input-xlarge" required="required">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">* Contraseña:</label>
							<div class="controls">
								<input type="password" name="password"
									placeholder="Ingresa tu contraseña" class="input-xlarge" required="required">
							</div>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">* Dirección</label>
						<div class="controls">
							<input type="text" name="direccion" class="input-medium"
								placeholder="Ingresa tu direccion" required="required">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">* Teléfono</label>
						<div class="controls">
							<input type="text" name="telefono" class="input-medium"
								placeholder="Ingresa tu número telefónico" required="required">
						</div>
					</div>

					<div class="control-group">
						<table>
							<tr>
								<td width="100px"><label class="control-label">* Tipo
										Usuario</label></td>
							</tr>
							<tr>
								<td><select class="input-medium" name="tipoUsuario">
										<option value="2">Cliente</option>
										<option value="1">Proveedor</option>
								</select></td>
							</tr>
						</table>
					</div>

					<hr>
					<div class="actions">
						<input tabindex="9" class="btn btn-inverse large" type="submit"
							value="Crear tu cuenta">
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</section>

<c:if test="${response != null}">
	<script type="text/javascript">
	    $(window).load(function(){
	        $('#myModal').modal('show');
	    });
	</script>
</c:if>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog modal-sm">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					onclick="$('.modal').hide()">&times;</button>
				<h4 class="modal-title">Información de la compra</h4>
			</div>
			<div class="modal-body">
				<h5><strong style="color:#eb4800;">${response}</h5>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal"
					onclick="$('.modal').hide()">Aceptar</button>
			</div>
		</div>

	</div>
</div>
<%@include file="footer.jsp"%>