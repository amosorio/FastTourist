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
			<section class="google_map">
				<iframe width="100%" height="300" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" 
				src="https://www.google.com/maps/embed/v1/place?q=Bogotá,+Colombia&key=AIzaSyAN0om9mFmy1QN6Wf54tXAowK4eT0ZUPrU">
				</iframe>
			</section>
			
			<section class="header_text sub">
				<h4><span>Contactenos</span></h4>
			</section>
			<section class="main-content">				
				<div class="row">				
					<div class="span3">
						<div>
							<h5>INFORMACION ADICIONAL</h5>
							<p><strong>Telefono:</strong>&nbsp;(123) 456-7890<br>
							<strong>Fax:</strong>&nbsp;+04 (123) 456-7890<br>
							<strong>Email:</strong>&nbsp;<a href="#">fast_tourist@gmail.com.co</a>								
							</p>
							<br/>
						</div>
					</div>
					<div class="span8">
						<p>Queremos que la experiencia de nuestros clientes en FastTourist desde el momento de la compra hasta el momento de uso del servicio, sea una experiencia excepcional. </p>
						<form method="post" action="#">
							<fieldset>
								<div class="clearfix">
									<label for="name"><span>Nombre:</span></label>
									<div class="input">
										<input tabindex="1" size="18" id="name" name="name" type="text" value="" class="input-xlarge" placeholder="Nombre">
									</div>
								</div>
								
								<div class="clearfix">
									<label for="email"><span>Email:</span></label>
									<div class="input">
										<input tabindex="2" size="25" id="email" name="email" type="text" value="" class="input-xlarge" placeholder="Email">
									</div>
								</div>
								
								<div class="clearfix">
									<label for="message"><span>Mensaje:</span></label>
									<div class="input">
										<textarea tabindex="3" class="input-xlarge" id="message" name="body" rows="7" placeholder="Mensaje"></textarea>
									</div>
								</div>
								
								<div class="actions">
									<button tabindex="3" type="submit" class="btn btn-inverse">Enviar Mensaje</button>
								</div>
							</fieldset>
						</form>
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
    </body>
</html>