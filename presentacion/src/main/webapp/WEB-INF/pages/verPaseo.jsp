<%@include file="header.jsp"%>
		<section class="navbar main-menu">
			<div class="navbar-inner main-menu">				
				<nav id="menu" class="pull-left">
					<ul>
						<li><a href="/presentacion/">Alojamiento</a></li>
						<li><a href="/presentacion/transporte/">Transporte</a>
						<li><a href="./products.html">Alimentacion</a></li>	
						<li><a href="/presentacion/paseo/" class="paginaActiva">Paseos Turisticos</a></li>
						<li><a href="./products.html">Paquetes</a></li>																					
					</ul>
				</nav>
			</div>
		</section>
		<section class="header_text sub" style="margin-bottom:2px !important">
		<img class="pageBanner" src="${pageContext.request.contextPath}/resources/themes/images/banner-ecologico.jpg" alt="New products" >
		<h4><span>${servicio.nombre}</span></h4>
		</section>
		<section class="main-content">				
			<div class="row">						
				<div class="span9">
					<div class="row">
						<div class="span4">
							<a href="${servicio.rutaGaleria}" class="thumbnail" data-fancybox-group="group1" title="Vista 1"><img alt="" src="${servicio.rutaGaleria}"></a>												
							<ul class="thumbnails small">								
								<li class="span1">
									<a href="${servicio.rutaGaleria}" class="thumbnail" data-fancybox-group="group1" title="Vista 2"><img src="${servicio.rutaGaleria}" alt=""></a>
								</li>								
								<li class="span1">
									<a href="${servicio.rutaGaleria}" class="thumbnail" data-fancybox-group="group1" title="Vista 3"><img src="${servicio.rutaGaleria}" alt=""></a>
								</li>													
								<li class="span1">
									<a href="${servicio.rutaGaleria}" class="thumbnail" data-fancybox-group="group1" title="Vista 4"><img src="${servicio.rutaGaleria}" alt=""></a>
								</li>
								<li class="span1">
									<a href="${servicio.rutaGaleria}" class="thumbnail" data-fancybox-group="group1" title="Vista 5"><img src="${servicio.rutaGaleria}" alt=""></a>
								</li>
							</ul>
						</div>												
						<div class="span5">
							
							<address>
								<strong>Fecha:</strong> <span style="color:#eb4800"> <fmt:formatDate type="date" value="${servicio.fechaCreacion}"/></span><br>
								<strong>Paseo Turistico:</strong> <span>${servicio.paseosecologico.nombre}</span><br>
								<strong>Lugar:</strong> <span>${servicio.paseosecologico.lugar}</span><br>
								<strong>Proveedor:</strong> <span>${servicio.usuario.nombre} ${servicio.usuario.apellido}</span><br>
								<strong>Categoría:</strong> <a href="/presentacion/paseos/" class="category">${servicio.categoria.nombre}</a><br>							
							</address>	
							<strong>Descripcion:</strong>
							<br>
							<span>${servicio.descripcion}</span>
																
						</div>					
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
						<br/>
						<form class="form-inline">
								<p class="buttons center">
								<label>Cantidad:</label>
								<input type="number" class="input-mini" placeholder="1">
								<br/><br/>
								<button class="btn btn-inverse" type="submit">Agregar Al Carrito</button>
								</p>
						</form>
						
					</div>
				</div>
			</div>
		</section>			
<%@include file="footer.jsp"%>