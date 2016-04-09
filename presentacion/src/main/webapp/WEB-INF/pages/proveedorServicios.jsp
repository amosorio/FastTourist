<%@include file="header.jsp"%>
<section class="navbar main-menu">
	<div class="navbar-inner main-menu">
		<nav id="menu" class="pull-left">
			<ul>
				<li><a href="/presentacion/adminProveedor/"
					class="paginaActiva"><span class="icon-home"></span> Servicios</a></li>
				<li><a href="/presentacion/transporte/"><span
						class="question-sign"></span> Respuestas</a>
				<li><a href="/presentacion/alimentacion/"><span
						class="icon-file"></span> Historicos</a></li>
				<li><a href="/presentacion/paseos/paseos"><span
						class="icon-refresh"></span> Transacciones</a></li>
				<li><a href="/presentacion/paquetes/"><span
						class="icon-ban-circle"></span> Solicitar Baja</a></li>
			</ul>
		</nav>
	</div>
</section>
<section class="header_text sub"></section>
<section class="main-content" style="margin-top: -30px">
	<div class="row">
		<%@include file="menuProveedor.jsp"%>
		<div class="span9 col">
			<table class="table table-striped">
				<thead>
					<tr
						style="font-size: 11px; color: #eb4800; text-transform: uppercase;">
						<th width="10%" align="center">Foto</th>
						<th width="10%" align="center">Creación</th>
						<th width="10%" align="center">Categoría</th>
						<th width="30%" align="center">Detalle</th>
						<th width="10%" align="center">Precio</th>
						<th width="10%" align="center">Descuento</th>
						<th width="10%" align="center">Estado</th>
						<th width="5%" align="center">Editar</th>
						<th width="5%" align="center">Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${servicios}" var="servicio">
						<tr>
							<td><img alt="" src="${servicio.rutaGaleria}" width="80px"
								title="Vista"></td>
							<td><fmt:formatDate type="both"
									value="${servicio.fechaCreacion}" /></td>
							<td><span>${servicio.categoria.nombre}</span></td>
							<td><span>${servicio.nombre}</span> - <span>${servicio.alojamiento.nombre}</span></td>
							<td><span>${servicio.precio}</span></td>
							<td><span>${servicio.descuento}</span></td>
							<c:choose>
								<c:when test="${servicio.activo}">
									<td><span>Activo</span></td>
								</c:when>
								<c:otherwise>
									<td><span>Inactivo</span></td>
								</c:otherwise>
							</c:choose>

							<td>
								<p class="buttons center">
									<a
										href="/presentacion/adminProveedor/edit/${servicio.idservicios}/"
										class="icon-zoom-in"></a>
								</p>
							</td>
							<td>
								<p class="buttons center">
									<a
										href="/presentacion/adminProveedor/delete/${servicio.idservicios}/"
										class="icon-remove"></a>
								</p>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>

<%@include file="footer.jsp"%>
