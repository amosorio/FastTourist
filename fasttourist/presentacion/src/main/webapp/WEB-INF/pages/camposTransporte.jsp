<table style="width: 80%; margin: 0px auto !important;">
	<tr>
		<td colspan="4">
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Nombre
					Transporte</label>
				<form:input type="text" class="input-xxlarge" required="required"
					style="width: 680px !important;" path="transporte.nombre" />
			</div>
		</td>
	</tr>

	<tr>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Sillas
					disponibles </label>
				<form:input type="number" class="input-small" required="required"
					path="transporte.cantPersonas" />
			</div>
		</td>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Fecha
					de Salida</label>
				<fmt:formatDate value="${servicio.transporte.fechaSalida}"
					type="date" pattern="dd-MM-yyyy" var="theFormattedDateIn" />
				<div class="input-append date" id="dp5"
					data-date="<fmt:formatDate pattern="dd-MM-yyyy" value="${servicio.transporte.fechaSalida}"/>"
					data-date-format="dd-mm-yyyy">
					<form:input class="input-small" size="16" type="text"
						path="transporte.fechaSalida" />
					<span class="add-on"><i class="icon-calendar"></i></span>
				</div>
			</div>
		</td>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Tipo
					de Transporte</label>
				<form:select class="input-medium"
					path="transporte.tipotransporte.idtipotransporte">

					<option value="1"
						<c:if test="${servicio.transporte.tipotransporte.idtipotransporte == '1'}">selected</c:if>>Aéreo</option>
					<option value="2"
						<c:if test="${servicio.transporte.tipotransporte.idtipotransporte == '2'}">selected</c:if>>Terrestre</option>
					<option value="3"
						<c:if test="${servicio.transporte.tipotransporte.idtipotransporte == '3'}">selected</c:if>>Marítimo</option>

				</form:select>
			</div>
		</td>
	</tr>

	<tr>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Origen</label>
				<form:input type="text" class="input-medium" required="required"
					path="transporte.origen" />
			</div>
		</td>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Destino</label>
				<form:input type="text" class="input-medium" required="required"
					path="transporte.destino" />
			</div>
		</td>
	</tr>
</table>