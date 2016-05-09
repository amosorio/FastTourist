<table style="width: 80%; margin: 0px auto !important;">
	<tr>
		<td colspan="3">
			<div class="control-group">
				<label class="control-label"><span class="required">*</span>Nombre
					Alojamiento</label>
				<form:input type="text" class="input-xxlarge" required="required"
					style="width: 680px !important;" path="alojamiento.nombre" />
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required">*</span>Ciudad</label>
				<form:input type="text" class="input-medium" required="required"
					path="alojamiento.ciudad" />
			</div>
		</td>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required">*</span>Dirección</label>
				<form:input type="text" class="input-medium" required="required"
					path="alojamiento.direccion" />
			</div>
		</td>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required">*</span>Teléfono</label>
				<form:input type="text" class="input-medium" required="required"
					path="alojamiento.telefono" />
			</div>
		</td>
	</tr>

	<tr>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required">*</span>Habitaciones
					disponibles</label>
				<form:input type="number" class="input-small" required="required"
					path="alojamiento.habitaciones" />
			</div>
		</td>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required">*</span>Capacidad
					de Personas</label>
				<form:input type="number" class="input-small" required="required"
					path="alojamiento.cantPersonas" />
			</div>
		</td>
	</tr>

	<tr>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required">*</span>Fecha
					de Entrada</label>
				<fmt:formatDate value="${servicio.alojamiento.fechaEntrada}"
					type="date" pattern="dd-MM-yyyy" var="theFormattedDateIn" />
				<div class="input-append date" id="dp3"
					data-date="<fmt:formatDate pattern="dd-MM-yyyy" value="${servicio.alojamiento.fechaEntrada}"/>"
					data-date-format="dd-mm-yyyy">
					<form:input class="input-small" size="16" type="text"
						path="alojamiento.fechaEntrada" />
					<span class="add-on"><i class="icon-calendar"></i></span>
				</div>
			</div>
		</td>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required">*</span>Fecha
					de Salida</label>
				<fmt:formatDate value="${servicio.alojamiento.fechaSalida}"
					type="date" pattern="dd-MM-yyyy" var="theFormattedDateOut" />
				<div class="input-append date" id="dp4"
					data-date="<fmt:formatDate pattern="dd-MM-yyyy" value="${servicio.alojamiento.fechaSalida}"/>"
					data-date-format="dd-mm-yyyy">
					<form:input class="input-small" size="16" type="text"
						path="alojamiento.fechaSalida" />
					<span class="add-on"><i class="icon-calendar"></i></span>
				</div>
			</div>
		</td>
	</tr>
	<tr>
		<td><span style="color: #eb4800 !important;">Servicios
				Adicionales</span></td>
	</tr>
	<tr>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Piscina</label>
				<form:checkbox class="input-small" value="true"
					path="alojamiento.piscina" />
			</div>
		</td>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Aire
					Acondicionado</label>
				<form:checkbox class="input-small" value="true"
					path="alojamiento.aire_acondicionado" />
			</div>
		</td>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Wifi</label>
				<form:checkbox class="input-small" value="true"
					path="alojamiento.wifi" />
			</div>
		</td>
	</tr>
</table>