<%@include file="header.jsp"%>
<section class="navbar main-menu">
	<div class="navbar-inner main-menu">
		<nav id="menu" class="pull-left">
			<ul>
				<li><a href="/presentacion/">Alojamiento</a></li>
				<li><a href="/presentacion/transporte/">Transporte</a>
				<li><a href="/presentacion/alimentacion/">Alimentaci�n</a></li>
				<li><a href="/presentacion/paseos/paseos" class="paginaActiva">Paseos Tur�sticos</a></li>
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

	<a href="/presentacion/paseo/getPaseo/13/">Ver detalle de paseo</a>
</section>

<%@include file="footer.jsp"%>
