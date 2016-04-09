<table style="width: 80%; margin: 0px auto !important;">
	<tr>
		<td colspan="4">
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Nombre
					Alimentación</label>
				<form:input type="text" class="input-xxlarge" required="required"
					style="width: 680px !important;" path="alimentacion.nombre"/>
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Tipo
					de Alimentación</label>
				<form:select class="input-medium"
					path="alimentacion.tipoalimentacion.idtipoAlimentacion">
					<option value="1"
						<c:if test="${servicio.alimentacion.tipoalimentacion.idtipoAlimentacion == '1'}">selected</c:if>>Una
						comida</option>
					<option value="2"
						<c:if test="${servicio.alimentacion.tipoalimentacion.idtipoAlimentacion == '2'}">selected</c:if>>Media
						pensión</option>
					<option value="3"
						<c:if test="${servicio.alimentacion.tipoalimentacion.idtipoAlimentacion == '3'}">selected</c:if>>Pensión
						completa</option>
					<option value="4"
						<c:if test="${servicio.alimentacion.tipoalimentacion.idtipoAlimentacion == '4'}">selected</c:if>>Todo
						incluido</option>
				</form:select>
			</div>
		</td>
</table>