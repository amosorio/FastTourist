<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<div class="block">
		<c:if test="${not empty lists}">
			<ul class="nav-list nav">					
				<c:forEach var="listValue" items="${lists}">
					<li>${listValue}</li>
				</c:forEach>				
			</ul>
		</c:if>
	</div>
</body>
</html>