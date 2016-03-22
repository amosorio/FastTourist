<%@include file="header.jsp"%>
<section class="navbar main-menu">
	<div class="navbar-inner main-menu">
		<nav id="menu" class="pull-left">
			<ul>
				<li><a href="/presentacion/" class="paginaActiva">Alojamiento</a></li>
				<li><a href="./products.html">Transporte</a>
				<li><a href="./products.html">Alimentacion</a></li>
				<li><a href="./products.html">Paseos Turisticos</a></li>
				<li><a href="./products.html">Paquetes</a></li>
			</ul>
		</nav>
	</div>
</section>
<section class="header_text sub">

	<section class="span3 col">
		<div class="row">
			<div class="block" style="text-align: left !important">
				<h4 class="title">
					<span class="text"><strong>Alojamiento</strong></span>
				</h4>

				<form action="#" method="post" class="form-stacked">

					<div class="control-group">
						<label class="control-label">¿Donde quieres ir?</label>
						<div class="controls">
							<input type="text" name="ciudad"
								placeholder="Ingresa una cuidad u hotel" class="input-xlarge">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">¿Proveedor?</label>
						<div class="controls">
							<select class="input-medium" name="proveedor">
								<option value="">Seleccione..</option>
								<option value="1">Proveedor1</option>
								<option value="2">Proveedor2</option>
								<option value="3">Proveedor3</option>
								<option value="4">Proveedor4</option>
							</select>
						</div>

					</div>
					<div class="control-group">
						<label class="control-label">¿En qué fecha?</label>
						<div class="controls">
							<div class="input-append date" id="dp1" data-date="2016-04-01"
								data-date-format="yyyy-mm-dd">
								<input class="input-small" size="16" type="text" name="fechaEntrada"
									placeholder="Entrada" readonly=""> <span class="add-on"><i
									class="icon-calendar"></i></span>
							</div>
							&nbsp;
							<div class="input-append date" id="dp2" data-date="2016-04-01"
								data-date-format="yyyy-mm-dd">
								<input class="input-small" size="16" type="text" name="fechaSalida"
									placeholder="Salida" readonly=""> <span class="add-on"><i
									class="icon-calendar"></i></span>
							</div>
						</div>
					</div>

					<div class="control-group">
						<table>
							<tr>
								<td width="100px"><label class="control-label">Habitaciones</label></td>
								<td width="100px"><label class="control-label">Personas</label></td>

							</tr>
							<tr>
								<td><select class="input-mini" name="habitaciones">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
								</select></td>
								<td><select class="input-mini" name=personas>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="4">5</option>
										<option value="4">6</option>
								</select></td>
							</tr>
						</table>
					</div>
					<hr>
					<div class="actions">
						<input type="submit" value="Buscar.." tabindex="9"
							class="btn btn-inverse large">
					</div>

				</form>
			</div>
		</div>
	</section>
	<section class="span0 col" style="margin-left:60px">
  	</section>
	<section class="span4 col">
	<div class="row">
		<div class="span8">
			<ul class="thumbnails listing-products">
				<c:forEach items="${servicios}" var="servicio" begin="0" end="1"> 
					<li class="span4">
						<div class="product-box">
							<span class="sale_tag"></span> 
							<a href="product_detail.html">
								<img alt="${servicio.nombre}" src="${pageContext.request.contextPath}${servicio.rutaGaleria}" style="height:230px; max-with:342px">
							</a>
							<br /> 
							<a href="product_detail.html" class="title">${servicio.nombre}</a>
							<br /> 
							<p class="name">${servicio.alojamiento.nombre}</p>
							<a href="product_detail.html" class="title">$${servicio.precio}</a>
							<p><b>Descuento $${servicio.descuento}</b></p>
							<c:if test="${servicio.alojamiento.wifi}">
								<a href="product_detail.html" class="title" title="Wifi"><span><i class="icon-signal"></i></span></a>
							</c:if>
							<c:if test="${servicio.alojamiento.piscina}">
								<a href="product_detail.html" class="title" title="Piscina"><span><i class="icon-heart"></i></span></a>
							</c:if>
							<c:if test="${servicio.alojamiento.aire_acondicionado}">
							   <a href="product_detail.html" class="title" title="Aire Acondicionado"><span><i class="icon-cog"></i></span></a>
							</c:if>
							<br/>
							<a href="product_detail.html" class="category">${servicio.alojamiento.ciudad}</a>
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
							<a href="product_detail.html">
								<img alt="${servicio.nombre}" src="${pageContext.request.contextPath}${servicio.rutaGaleria}" style="height:230px; max-with:342px">
							</a>
							<br /> 
							<a href="product_detail.html" class="title">${servicio.nombre}</a>
							<br /> 
							<p class="price">${servicio.alojamiento.nombre}</p>
							<a href="product_detail.html" class="title">$${servicio.precio}</a>
							<p><b>Descuento $${servicio.descuento}</b></p>
							<c:if test="${servicio.alojamiento.wifi}">
								<a href="product_detail.html" class="title" title="Wifi"><span><i class="icon-signal"></i></span></a>
							</c:if>
							<c:if test="${servicio.alojamiento.piscina}">
								<a href="product_detail.html" class="title" title="Piscina"><span><i class="icon-heart"></i></span></a>
							</c:if>
							<c:if test="${servicio.alojamiento.aire_acondicionado}">
							   <a href="product_detail.html" class="title" title="Aire Acondicionado"><span><i class="icon-cog"></i></span></a>
							</c:if>
							<br/>
							<a href="product_detail.html" class="category">${servicio.alojamiento.ciudad}</a>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</section>

<%@include file="footer.jsp"%>
