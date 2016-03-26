<form action="#" method="post" class="form-inline">
	<p class="buttons left">
		<label><strong>¿Deseas Calificar el servicio?</strong></label> <br/>
		<table>
			<tr>
				<td><input type="text" class="input-xxlarge" placeholder="Ingresa tu comentario" name="inputComentario"></td>
				<td>&nbsp &nbsp</td>
				<td>
					<labe>Calificación:</labe>
					<select class="input-medium" name=valor required="required">
										<option value="">Seleccione....</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
					</select>
				</td>
				<td>
					<c:if test="${permisos == 'ok'}">
						<button class="btn btn-danger" type="submit">Enviar</button>
					</c:if>
					<c:if test="${permisos == 'Nok'}">
					<button class="btn btn-danger" type="submit" disabled="disabled">Enviar</button>
					</c:if>
				</td>
			</tr>
		
		</table>
		<br/>	
	</p>
</form>
<hr>
<c:forEach items="${servicio.calificaciones}" var="calificacion">
	<table>
		<tr>
			<td rowspan="3" style="padding: 20px; text-align: center"><img
				src="${pageContext.request.contextPath}/resources/themes/images/avatar-reviews.png"
				title="${calificacion.usuario.nombre}" /></td>
			<td><fmt:formatDate type="date" value="${calificacion.fecha}" /></td>
		</tr>
		<tr>
			<td width="400px"><span style="color: #eb4800">Comentario:</span>
				<strong>${calificacion.comentario}</strong></td>
		</tr>
		<tr>
			<td><span style="color: #eb4800">Calificación:</span> <c:forEach
					var="i" begin="1" end="${calificacion.valor}">
					<span class="icon-star"></span>
				</c:forEach></td>
		</tr>
		<tr>
			<td style="text-align: center">${calificacion.usuario.nombre}
				${calificacion.usuario.apellido}</td>
		</tr>
		<tr>
			<td style="text-align: center">${calificacion.usuario.email}</td>
		</tr>
	</table>
	<hr>
</c:forEach>