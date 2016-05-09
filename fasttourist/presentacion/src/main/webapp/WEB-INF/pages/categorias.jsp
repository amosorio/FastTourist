<%@include file="header.jsp"%>
<section class="navbar main-menu">
	<div class="navbar-inner main-menu">
		<nav id="menu" class="pull-left">
			<ul>
				<li><a href="/presentacion/adminProveedor/"><span 
						class="icon-home"></span> Servicios</a></li>
				<li><a href="/presentacion/transporte/"><span
						class="question-sign"></span> Respuestas</a>
				<li><a href="/presentacion/alimentacion/"><span
						class="icon-file"></span> Historicos</a></li>
				<li><a href="/presentacion/paseos/paseos"><span
						class="icon-refresh"></span> Transacciones</a></li>
				<li><a href="/presentacion/paquetes/"><span
						class="icon-ban-circle"></span> Solicitar Baja</a></li>
				<li><a href="/presentacion/adminProveedor/categorias/" class="paginaActiva">
					<span class="paginaActiva" class="icon-plus"></span> Categorías Adicionales</a></li>
				<li><a href="/presentacion/adminProveedor/editar-info/"><span
						class="icon-pencil"></span> Editar Info</a></li>
			</ul>
		</nav>
	</div>
</section>
<section class="header_text sub"></section>
<section class="main-content" style="margin-top: -30px">
	<div class="row">
		<%@include file="menuProveedor.jsp"%>
		<div class="span9 col">
			<h4 style="text-align: center; color: #eb4800;">Categorías
				adicionales</h4>

			<!-- Aqui van las categorias adicionales traidas de BD -->

			<!-- Aqui va la opcion de crear una nueva categoria -->

			<h4 style="text-align: center; color: #eb4800;">Crear una nueva
				categoría</h4>

			<form action="#" method="post" class="form-stacked">

				<table align="center" class="authors-list">
					<tr>
						<td>Atributo</td>
						<td>Valor</td>
					</tr>
					<tr>
						<td><input type="text" name="atributo" /></td>
						<td><input type="text" name="valor" /></td>
					</tr>
				</table>
				<div style="text-align: center">
					<a style="text-align: center" href="#" title="" class="add-author">Añadir
						atributo</a><br><br>
							<input class="btn btn-success" type="submit"
							value="Guardar">
						<a class="btn btn-danger" href="<c:url value='#'/>">Cancelar</a>
				</div>
			</form>


				<script>
			jQuery(function(){
			    var counter = 1;
			    jQuery('a.add-author').click(function(event){
			        event.preventDefault();
			        counter++;
			        var newRow = jQuery('<tr><td><input type="text" name="atributo' +
			            counter + '"/></td><td><input type="text" name="valor' +
			            counter + '"/></td></tr>');

			        jQuery('table.authors-list').append(newRow);
			    });
			});			
			</script>
					</div>
	</div>
</section>

<%@include file="footer.jsp"%>