<%@include file="header.jsp"%>
		<section class="navbar main-menu">
			<div class="navbar-inner main-menu">				
				<nav id="menu" class="pull-left">
					<ul>
						<li><a href="/presentacion/">Alojamiento</a></li>
						<li><a href="/presentacion/transporte/" class="paginaActiva">Transporte</a>
						<li><a href="./products.html">Alimentacion</a></li>	
						<li><a href="/presentacion/paseos/paseos">Paseos Turisticos</a></li>
						<li><a href="./products.html">Paquetes</a></li>																					
					</ul>
				</nav>
			</div>
		</section>
		<section class="header_text sub" style="margin-bottom:2px !important">
		<img class="pageBanner" src="${pageContext.request.contextPath}/resources/themes/images/bannerTransporte.jpg" alt="New products" >
		<h4><span>${servicio.nombre}</span></h4>
		</section>
		<section class="main-content">				
			<div class="row">						
				<div class="span9">
					<div class="row">			
						<br/>			
						<table class="table table-striped" style="width:95% !important; margin-left:40px">
							<thead>
								<tr>
									<th>Agencia</th>
									<th>Fecha Salida</th>
									<th>Origen</th>
									<th>Destino</th>
									<th>Descripcion</th>
									<th>Detalles</th>
									<th>Proveedor</th>
									<th>Categoria</th>
									<th>Tipo</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><img alt="" src="${servicio.rutaGaleria}" width="100px" title="Vista 1"></td>
									<td><fmt:formatDate type="both" value="${servicio.transporte.fechaSalida}"/></td>
									<td><span>${servicio.transporte.origen}</span></td>
									<td><span>${servicio.transporte.destino}</span></td>
									<td><span>${servicio.transporte.nombre} - ${servicio.nombre}</span></td>
									<td><span>${servicio.descripcion}</span></td>
									<td><span>${servicio.usuario.nombre}</span></td>
									<td><span>${servicio.categoria.nombre}</span></td>
									<td><span>${servicio.transporte.tipotransporte.nombre}</span></td>
								</tr>			    
							</tbody>
						</table>												
					</div>
					<%@include file="moduloPreguntas.jsp"%>	
				</div>
				<div class="span3 col">
					
					<div class="block">	
						<c:forEach var="i" begin="1" end="${promCalificacion}">
						  <span class="icon-star"></span>
						</c:forEach>
						<br/>
						<h4 class="title">Precio:<strong> $${servicio.precio}</strong></h4>	
						<h4 class="title">Descuento:<strong> $${servicio.descuento}</strong></h4>
						<form action="#" method="post" class="form-inline">
								<p class="buttons center">
								<label>Cantidad:</label>
								<input type="number" class="input-mini" placeholder="" name="carrito" max="1" min="1" required="required">
								<br/><br/>
								<button class="btn btn-inverse" type="submit">Agregar Al Carrito</button>
								</p>
						</form>
						<h5 class="title">Puestos Disponibles:<strong> ${servicio.transporte.cantPersonas}</strong></h5>
					</div>
				</div>
			</div>
		</section>			
<%@include file="footer.jsp"%>