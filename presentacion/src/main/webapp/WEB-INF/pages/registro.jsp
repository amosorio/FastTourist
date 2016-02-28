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
				<h4><span>Registrarse</span></h4>
			</section>			
			<section class="main-content">				
				<div class="row">
					<div class="span5">					
						<h4 class="title"><span class="text"><strong>Formulario </strong> de Autenticación</span></h4>
						<form action="#" method="post">
							<input type="hidden" name="next" value="/">
							<fieldset>
								<div class="control-group">
									<label class="control-label">Usuario</label>
									<div class="controls">
										<input type="text" placeholder="Ingresa tu nombre de usuario" id="username" class="input-xlarge">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Contraseña</label>
									<div class="controls">
										<input type="password" placeholder="Ingresa tu contraseña" id="password" class="input-xlarge">
									</div>
								</div>
								<div class="control-group">
									<input tabindex="3" class="btn btn-inverse large" type="submit" value="Ingresar">
									<hr>
									<p class="reset">Recuperar tu <a tabindex="4" href="#" title="Recuperar el usuario o contraseña">Nombre de usuario o contraseña</a></p>
								</div>
							</fieldset>
						</form>				
					</div>
					<div class="span7">					
						<h4 class="title"><span class="text"><strong>Formulario</strong> de Registro</span></h4>
						<form action="#" method="post" class="form-stacked">
							<fieldset>
								<div class="control-group">
									<label class="control-label">Usuario</label>
									<div class="controls">
										<input type="text" placeholder="Ingresa tu nombre de usuario" class="input-xlarge">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Email:</label>
									<div class="controls">
										<input type="password" placeholder="Ingresa tu email" class="input-xlarge">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Contraseña:</label>
									<div class="controls">
										<input type="password" placeholder="Ingresa tu contraseña" class="input-xlarge">
									</div>
								</div>							                            
								<hr>
								<div class="actions"><input tabindex="9" class="btn btn-inverse large" type="submit" value="Crear tu cuenta"></div>
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
		<script>
			$(document).ready(function() {
				$('#checkout').click(function (e) {
					document.location.href = "checkout.html";
				})
			});
		</script>		
    </body>
</html>