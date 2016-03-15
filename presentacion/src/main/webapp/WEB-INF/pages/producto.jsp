<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
		<meta charset="utf-8">
		<title>Bootstrap E-commerce Templates</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
		<!-- bootstrap -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">      
		<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		
		<link href="themes/css/bootstrappage.css" rel="stylesheet"/>

		<!--[if lt IE 9]>			
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->
		<!-- bootstrap -->
		<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">      
		<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		
		<link href="${pageContext.request.contextPath}/resources/themes/css/bootstrappage.css" rel="stylesheet"/>
		
		<!-- global styles -->
		<link href="${pageContext.request.contextPath}/resources/themes/css/jquery.fancybox.css" rel="stylesheet"/>
		<link href="${pageContext.request.contextPath}/resources/themes/css/main.css" rel="stylesheet"/>

		<!-- scripts -->
		<script src="${pageContext.request.contextPath}/resources/themes/js/jquery-1.7.2.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>				
		<script src="${pageContext.request.contextPath}/resources/themes/js/superfish.js"></script>	
		<script src="${pageContext.request.contextPath}/resources/themes/js/jquery.scrolltotop.js"></script>
		<script src="${pageContext.request.contextPath}/resources/themes/js/jquery.fancybox.js"></script>
		<!--[if lt IE 9]>			
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->
	</head>
<body>

	<div id="top-bar" class="container">
		<div class="row">
			<div class="span4">
				<form method="POST" class="search_form">
					<input type="text" class="input-block-level search-query" Placeholder="eg. San Andres">
				</form>
			</div>
			<div class="span8">
				<div class="account pull-right">
					<ul class="user-menu">				
						<li><a href="#">Mi Cuenta</a></li>
						<li><a href="/presentacion/carrito">Mi Carrito</a></li>
						<li><a href="/presentacion/ingresar">Ingresar</a></li>					
						<li><a href="/presentacion/registro">Registrarse</a></li>		
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div id="wrapper" class="container">
		<section class="navbar main-menu">
			<div class="navbar-inner main-menu">				
				<a href="index.html" class="logo pull-left"><img src="${pageContext.request.contextPath}/resources/themes/images/logo.png" class="site_logo" alt="" height="37px"></a>
				<nav id="menu" class="pull-right">
					<ul>
						<li><a href="/presentacion/">Inicio</a></li>
						<li><a href="./products.html">Enviar Mensajes</a>					
							<ul>
								<li><a href="./products.html">Lacinia nibh</a></li>									
								<li><a href="./products.html">Eget molestie</a></li>
								<li><a href="./products.html">Varius purus</a></li>									
							</ul>
						</li>															
						<li><a href="./products.html">Mis transacciones</a></li>					
					</ul>
				</nav>
			</div>
		</section>
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
		<section id="footer-bar">
			<div class="row">
				<div class="span3">
					<h4>Navegación</h4>
					<ul class="nav">
						<li><a href="/presentacion/">Inicio</a></li>  
						<li><a href="/presentacion/nosotros">Sobre Nosotros</a></li>
						<li><a href="/presentacion/contactenos">Contactenos</a></li>
						<li><a href="/presentacion/carrito">Mi Carrito</a></li>
						<li><a href="/presentacion/registro">Ingresar</a></li>							
					</ul>					
				</div>
				<div class="span4">
					<h4>Mi Cuenta</h4>
					<ul class="nav">
						<li><a href="#">Mi Cuenta</a></li>
						<li><a href="#">Mis Transacciones</a></li>

					</ul>
				</div>
				<div class="span5">
					<p class="logo"><img src="${pageContext.request.contextPath}/resources/themes/images/logo.png" class="site_logo" alt=""></p>
					<p>FastTourist es un producto de FastFactory s.a</p>
					<br/>
					<span class="social_icons">
						<a class="facebook" href="#">Facebook</a>
						<a class="twitter" href="#">Twitter</a>
						<a class="skype" href="#">Skype</a>
						<a class="vimeo" href="#">Vimeo</a>
					</span>
				</div>					
			</div>	
		</section>
		<section id="copyright">
			<span>Copyright 2016 FastFactory All right reserved.</span>
		</section>
	</div>
	<script src="themes/js/common.js"></script>
	<script>
		$(function () {
			$('#myTab a:first').tab('show');
			$('#myTab a').click(function (e) {
				e.preventDefault();
				$(this).tab('show');
			})
		})
		$(document).ready(function() {
			$('.thumbnail').fancybox({
				openEffect  : 'none',
				closeEffect : 'none'
			});
			
			$('#myCarousel-2').carousel({
	                  interval: 2500
	              });								
		});
	</script>
</body>
</html>