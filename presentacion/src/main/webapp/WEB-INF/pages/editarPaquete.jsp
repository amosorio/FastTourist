<%@include file="header.jsp"%>
<section class="navbar main-menu">
	<div class="navbar-inner main-menu">
		<nav id="menu" class="pull-left">
			<ul>
				<li><a href="/presentacion/adminAlojamiento/"
					class="paginaActiva">Servicios</a></li>
				<li><a href="/presentacion/transporte/">Respuestas</a>
				<li><a href="/presentacion/alimentacion/">Historicos</a></li>
				<li><a href="/presentacion/paseos/paseos">Transacciones</a></li>
				<li><a href="/presentacion/paquetes/">Solicitar Baja</a></li>
			</ul>
		</nav>
	</div>
</section>
<section class="header_text sub"></section>
<section class="main-content" style="margin-top: -30px">
	<div class="row">

		<%@include file="menuProveedor.jsp"%>
		<div class="span9 col">

			<form:form action="#" method="post" class="form-stacked"
				commandName="paquete">
				<table style="width: 80%; margin: 0px auto !important;">
					<tr>
						<td colspan="3">
							<div class="control-group">
								<label class="control-label"><span class="required">*</span>Nombre
									Paquete</label>
								<form:input type="text" class="input-xxlarge"
									required="required" path="nombre"
									style="width: 680px !important;" />
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<div class="control-group">
								<label class="control-label"><span class="required">*</span>Descripción</label>
								<form:textarea class="input-xxlarge" required="required"
									rows="4" path="descripcion" style="width: 680px !important;" />

							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="control-group">
								<label class="control-label"><span class="required">*</span>Fecha
									de Creación</label>
								<fmt:formatDate value="${paquete.fechaCreacion}" type="date"
									pattern="dd-MM-yyyy" var="theFormattedDateIn" />
								<div class="input-append date" id="dp3"
									data-date="<fmt:formatDate pattern="dd-MM-yyyy" value="${paquete.fechaCreacion}"/>"
									data-date-format="dd-mm-yyyy">
									<form:input class="input-small" size="16" type="text"
										path="fechaCreacion" />
									<span class="add-on"><i class="icon-calendar"></i></span>
								</div>
							</div>
						</td>
						<td>
							<div class="control-group">
								<label class="control-label"><span class="required">*</span>Fecha
									de Expiración</label>
								<fmt:formatDate value="${paquete.fechaExpiracion}" type="date"
									pattern="dd-MM-yyyy" var="theFormattedDateOut" />
								<div class="input-append date" id="dp4"
									data-date="<fmt:formatDate pattern="dd-MM-yyyy" value="${paquete.fechaExpiracion}"/>"
									data-date-format="dd-mm-yyyy">
									<form:input class="input-small" size="16" type="text"
										path="fechaExpiracion" />
									<span class="add-on"><i class="icon-calendar"></i></span>
								</div>
							</div>
						</td>
					</tr>
					</table>
					
					
					
					<table style="width: 80%; margin: 0px auto !important;">
						<tr>
						<td colspan="4"><h5 style="text-align: left;color:#eb4800;">Servicios agregados</h5></td>
						</tr>
						<tr style="text-align: left">
							<th width="10%">Item</th>
							<th width="40%">Nombre</th>
							<th width="20%">Categoria</th>
							<th width="20%">Fecha Creación</th>
							<th width="10%">Precio</th>
						</tr>
					<c:forEach items="${paquete.servicios}" var="servicio">
						<tr>
							<td><input type="checkbox" value="${servicio.idservicios}" checked="checked"  name="checks" ></td>
							<td>${servicio.nombre}</td>
							<td>${servicio.categoria.nombre}</td>
							<td><fmt:formatDate type="both"
									value="${paquete.fechaCreacion}"/></td>
							<td>${servicio.precio}</td>
						</tr>
					</c:forEach>
					
					<c:forEach items="${servicios}" var="servicio" >
						<tr>
							<td><input type="checkbox" value="${servicio.idservicios}" name="checks"></td>
							<td>${servicio.nombre}</td>
							<td>${servicio.categoria.nombre}</td>
							<td><fmt:formatDate type="both"
									value="${paquete.fechaCreacion}"/></td>
							<td>${servicio.precio}</td>
						</tr>
					</c:forEach>

					<tr>
						<td colspan="3" align="center"><form:button
								class="btn btn-info pull-center" id="crearButton"
								disabled="false">Actualizar Servicio</form:button></td>
					</tr>
				</table>

			</form:form>
		</div>
	</div>
</section>

<script type="text/javascript">
	function assign()
	   { 
		var values = [];
		var cbs = document.getElementsByName("checks");
		for(var i=0,cbLen=cbs.length;i<cbLen;i++){
		  if(cbs[i].checked){
		    values.push(cbs[i].value);
		  }
		}
		window.location = 'http://localhost:8080/presentacion/pagar/carrito/' + values;
		
	}
<c:if test="${editExitoso}">
	<script type="text/javascript">
		$(window).load(function() {
			$('#myModal').modal('show');
		});
	</script>
</c:if>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					onclick="$('.modal').hide()">&times;</button>
				<h4 class="modal-title">Información</h4>
			</div>
			<div class="modal-body">
				<h5>
					<strong style="color: #eb4800;">El paquete se ha
						actualizado exitosamente! 
				</h5>
			</div>
			<div class="modal-footer">
				<a href="/presentacion/adminProveedor/paquetes/"><button
						class="btn btn-inverse" type="button">Aceptar</button></a>
			</div>
		</div>

	</div>
</div>
<%@include file="footer.jsp"%>