<%@include file="header.jsp"%>
		<section class="navbar main-menu">
			<div class="navbar-inner main-menu">				
				<nav id="menu" class="pull-left">
					<ul>
						<li><a href="/presentacion/">Alojamiento</a></li>
						<li><a href="/presentacion/transporte/">Transporte</a>
						<li><a href="/presentacion/alimentacion/">Alimentacion</a></li>	
						<li><a href="/presentacion/paseos/paseos" class="paginaActiva">Paseos Turisticos</a></li>
						<li><a href="/presentacion/paquetes/">Paquetes</a></li>
						<c:if test="${not empty usuarioAutenticado}">	
							<li><a href="/presentacion/mensajeria/">
								<span class="icon-envelope"></span> Mensajeria</a></li>
						</c:if>																				
					</ul>
				</nav>
			</div>
		</section>
		<section class="header_text sub">

		<section class="span3 col">
			<div class="block" style="text-align: left !important">
				<h4 class="title">
					<span class="text"><strong>Paseos Ecologicos</strong></span>
				</h4>
				<form action="#" method="post" class="form-stacked">

					<div class="control-group">
						<label class="control-label">Filtrar por Nombre</label>
						<div class="controls">
							<input type="text" name="nombre" placeholder="Ingresa nombre del paseo"
								class="input-large">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Filtrar por lugar</label>
						<div class="controls">
							<input type="text" name="lugar" placeholder="Ingresa lugar"
								class="input-large">
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">Filtrar por Servicio</label>
						<div class="controls">
							<input type="text" name="servicio" placeholder="Ingresa nombre del servicio"
								class="input-large">
						</div>
					</div>

					<hr>
					<div class="actions">
						<input tabindex="9" class="btn btn-inverse large" type="submit"
							value="Buscar">
					</div>

				</form>
			</div>
		</section>

<!-- Aqui van algunos paseos de la BD -->
<section class="span0 col" style="margin-left:60px">
</section>
<section class="span4 col">
	<div class="row">
		<div class="span8">
			<!--  div class="span8">
				<h4 class="title">
					<span class="text">
						<strong>Paseos </strong> Ecol�gicos m�s solicitados
					</span>
				</h4>
			</div-->
			<ul class="thumbnails listing-products">
				<c:forEach items="${servicios}" var="servicio" begin="0" end="1"> 
					<li class="span4">
						<div class="product-box">
							<span class="sale_tag"></span> 
							<a href="/presentacion/paseos/getServicio/${servicio.idservicios}/" class="title">${servicio.paseosecologico.nombre}
								<img alt="${servicio.paseosecologico.nombre}" src="${servicio.paseosecologico.fotos}" style="height:230px; max-with:342px">
							</a>
							<br /> 
							<a href="/presentacion/paseos/getServicio/${servicio.idservicios}/" class="title">${servicio.paseosecologico.nombre}</a>
							<p class="name">${servicio.paseosecologico.nombre}</p>
							<p class="title">$${servicio.precio}</p>
							<p><b>Descuento $${servicio.descuento}</b></p>
							<p class="category">${servicio.paseosecologico.lugar}</p>
							<p class="buttons center">	
								<a href="/presentacion/paseos/getServicio/${servicio.idservicios}/" class="title">			
									<button class="btn" type="button" >Ver Detalle</button>
								</a>
							</p>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	</section>
</section>

<section class="main-content">
	<div class="row">
		<div class="span12">
			<ul class="thumbnails listing-products">
				<c:forEach items="${servicios}" var="servicio" begin="2">
					<li class="span4">
						<div class="product-box">
							<span class="sale_tag"></span> 
							<a href="/presentacion/paseos/getServicio/${servicio.idservicios}/" class="title">${servicio.paseosecologico.nombre}</a>
								<img alt="${servicio.nombre}" src="${servicio.rutaGaleria}" style="height:230px; max-with:342px">
							</a>
							<br/> 
							<a href="/presentacion/paseos/getServicio/${servicio.idservicios}/" class="title">${servicio.paseosecologico.nombre}</a>
							<p class="name">${servicio.paseosecologico.nombre}</p>
							<p class="title">$${servicio.precio}</p>
							<p><b>Descuento $${servicio.descuento}</b></p>
							<p class="category">${servicio.paseosecologico.lugar}</p><br>
							<p class="buttons center">
								<a href="/presentacion/paseos/getServicio/${servicio.idservicios}/" class="title">	
									<button class="btn" type="button" >Ver Detalle</button>
								</a>
							</p>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</section>

<%@include file="footer.jsp"%>			
