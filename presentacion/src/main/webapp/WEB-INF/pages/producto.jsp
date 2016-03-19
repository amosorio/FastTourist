<%@include file="header.jsp"%>
		<section class="header_text sub">
		<img class="pageBanner" src="${pageContext.request.contextPath}/resources/themes/images/pageBanner.png" alt="New products" >
			<h3><span>${servicio.nombre}</span></h3>
		</section>
		<section class="main-content">				
			<div class="row">						
				<div class="span9">
					<div class="row">
						<div class="span4">
							<a href="${pageContext.request.contextPath}/resources/themes/images/ladies/1.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 1"><img alt="" src="${pageContext.request.contextPath}/resources/themes/images/ladies/1.jpg"></a>												
							<ul class="thumbnails small">								
								<li class="span1">
									<a href="${pageContext.request.contextPath}/resources/themes/images/ladies/2.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 2"><img src="${pageContext.request.contextPath}/resources/themes/images/ladies/2.jpg" alt=""></a>
								</li>								
								<li class="span1">
									<a href="${pageContext.request.contextPath}/resources/themes/images/ladies/3.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 3"><img src="${pageContext.request.contextPath}/resources/themes/images/ladies/3.jpg" alt=""></a>
								</li>													
								<li class="span1">
									<a href="${pageContext.request.contextPath}/resources/themes/images/ladies/4.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 4"><img src="${pageContext.request.contextPath}/resources/themes/images/ladies/4.jpg" alt=""></a>
								</li>
								<li class="span1">
									<a href="${pageContext.request.contextPath}/resources/themes/images/ladies/5.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 5"><img src="${pageContext.request.contextPath}/resources/themes/images/ladies/5.jpg" alt=""></a>
								</li>
							</ul>
						</div>
						<div class="span3">
							<address>
								<strong>Proveedor:</strong> <span>${servicio.usuario.nombre} ${servicio.usuario.apellido}</span><br>
								<strong>Categoría:</strong> <span>${servicio.categoria.nombre}</span><br>
								<strong>Fecha Creación:</strong> <span>${servicio.fechaCreacion}</span><br>							
							</address>	
							<strong>Descripcion:</strong>
							<br>
							<span>${servicio.descripcion}</span>
																
						</div>					
					</div>
					<div class="row">
						<div class="span9">
							<ul class="nav nav-tabs" id="myTab">
								<li class="active"><a href="#home">Preguntas</a></li>
								<li class=""><a href="#profile">Calificación</a></li>
							</ul>							 
							<div class="tab-content">
								<div class="tab-pane active" id="home">Sed ut perspiciatis unde omnis iste natus error sit 
								voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo 
								inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. 
								Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, 
								sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.
								 Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur,
								  adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et 
								  dolore magnam aliquam quaerat voluptatem</div>
								<div class="tab-pane" id="profile">
									<table class="table table-striped shop_attributes">	
										<tbody>
											<tr class="">
												<th>Size</th>
												<td>Large, Medium, Small, X-Large</td>
											</tr>		
											<tr class="alt">
												<th>Colour</th>
												<td>Orange, Yellow</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>							
						</div>						
						
					</div>
				</div>
				<div class="span3 col">
					<div class="block">	
						<h2><strong>Precio: $ ${servicio.precio}</strong></h2>	
						<h4><strong>Descuento: ${servicio.descuento}</strong></h4>
						<h4><strong>Comprados: ${cantidad_comprados}</strong></h4>				
						<br/>
						<form class="form-inline">
								<label>Cantidad:</label>
								<input type="text" class="span1" placeholder="1"><br>
								<button class="btn btn-inverse" type="submit">Agregar al carrito</button>
								
						</form>
						
					</div>
				</div>
			</div>
		</section>			
<%@include file="footer.jsp"%>