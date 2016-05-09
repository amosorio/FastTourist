
<table style="width: 80%; margin: 0px auto !important;">

	<tr>
		<td colspan="4">
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Nombre
					Paseo ecológico</label>
				<form:input type="text" class="input-xxlarge" required="required"
					style="width: 680px !important;" path="paseosecologico.nombre" />
			</div>
		</td>
	</tr>

	<tr>
		<td colspan="3">
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Detalles</label>
				<form:textarea type="text" class="input-xxlarge" required="required"
					rows="3" style="width: 680px !important;"
					path="paseosecologico.descripcion" maxlength="500" />
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="3">
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Requerimientos</label>
				<form:input class="input-xxlarge" required="required"
					style="width: 680px !important;"
					path="paseosecologico.requerimientos" />
			</div>
		</td>
	</tr>

	<tr>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Lugar</label>
				<form:input type="text" class="input-medium" required="required"
					path="paseosecologico.lugar" />
			</div>
		</td>
		<td>
			<div class="control-group">
				<label class="control-label"><span class="required"></span>Duración</label>
				<form:input type="number" class="input-small" required="required"
					path="paseosecologico.duracion" />
			</div>
		</td>
	</tr>
	<tr>
		
		<td colspan="3">
		<label class="control-label"><span class="required"></span>Foto</label>
		<form:input type="text" class="input-xxlarge"
				style="width: 680px !important;" required="required"
				path="paseosecologico.fotos" /></td>
	</tr>


</table>
