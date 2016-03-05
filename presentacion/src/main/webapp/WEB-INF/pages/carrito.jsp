<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Bootstrap E-commerce Templates</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
		<!-- bootstrap -->
		<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">      
		<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		
		<link href="${pageContext.request.contextPath}/resources/themes/css/bootstrappage.css" rel="stylesheet"/>
		
		<!-- global styles -->
		<link href="${pageContext.request.contextPath}/resources/themes/css/flexslider.css" rel="stylesheet"/>
		<link href="${pageContext.request.contextPath}/resources/themes/css/main.css" rel="stylesheet"/>

		<!-- scripts -->
		<script src="${pageContext.request.contextPath}/resources/themes/js/jquery-1.7.2.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>				
		<script src="${pageContext.request.contextPath}/resources/themes/js/superfish.js"></script>	
		<script src="${pageContext.request.contextPath}/resources/themes/js/jquery.scrolltotop.js"></script>
		<!--[if lt IE 9]>			
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="themes/js/respond.min.js"></script>
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
							<li><a href="/presentacion/registro">Ingresar</a></li>					
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
			<h4><span>Carrito de Compras</span></h4>
			</section>
			<section class="main-content">				
				<div class="row">
					<div class="span12">					
						<h4 class="title"><span class="text"><strong>Tu</strong> Carrito</span></h4>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Remover</th>
									<th>Imagen</th>
									<th>Nombre del Producto</th>
									<th>Cantidad</th>
									<th>Precio Unitario</th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox" value="option1"></td>
									<td><a href="product_detail.html"><img alt="" src="${pageContext.request.contextPath}/resources/themes/images/ladies/9.jpg"></a></td>
									<td>Fusce id molestie massa</td>
									<td><input type="text" placeholder="1" class="input-mini"></td>
									<td>$2,350.00</td>
									<td>$2,350.00</td>
								</tr>			  
								<tr>
									<td><input type="checkbox" value="option1"></td>
									<td><a href="product_detail.html"><img alt="" src="${pageContext.request.contextPath}/resources/themes/images/ladies/1.jpg"></a></td>
									<td>Luctus quam ultrices rutrum</td>
									<td><input type="text" placeholder="2" class="input-mini"></td>
									<td>$1,150.00</td>
									<td>$2,450.00</td>
								</tr>
								<tr>
									<td><input type="checkbox" value="option1"></td>
									<td><a href="product_detail.html"><img alt="" src="${pageContext.request.contextPath}/resources/themes/images/ladies/3.jpg"></a></td>
									<td>Wuam ultrices rutrum</td>
									<td><input type="text" placeholder="1" class="input-mini"></td>
									<td>$1,210.00</td>
									<td>$1,123.00</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td><strong>$3,600.00</strong></td>
								</tr>		  
							</tbody>
						</table>
						
						<hr>
						<p class="cart-total right">
							<strong>Sub-Total</strong>:	$100.00<br>
							<strong>Eco Tax (-2.00)</strong>: $2.00<br>
							<strong>VAT (17.5%)</strong>: $17.50<br>
							<strong>Total</strong>: $119.50<br>
						</p>
						<hr/>
						<p class="buttons center">				
							<button class="btn" type="button">Actualizar</button>
							<button class="btn" type="button">Continuar</button>
							<button class="btn btn-inverse" type="submit" id="checkout">Comprar</button>
						</p>					
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
			$(document).ready(function() {
				$('#checkout').click(function (e) {
					document.location.href = "checkout.html";
				})
			});
		</script>		
    </body>
</html>