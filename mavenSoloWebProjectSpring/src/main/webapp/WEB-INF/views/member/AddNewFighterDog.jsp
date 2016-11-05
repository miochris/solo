<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sf:form action="AddFighterDog" method ="post" modelAttribute="dog">


	<br>
	<label>Fighter Name <sf:input path="name" /></label>
	<br>
	<label>Num of Wins<sf:input path="nOfW" /></label>
	<br>
	<label>Num of Lost<sf:input path="nOfL" /></label>
	<br>
	<label>Speed<sf:input path="speed" /></label>
	<br>
	<label>Price<sf:input path="price" /></label>
	<br>
	<input type="Submit" name="Submit" value="AddFighter" />
	</sf:form>


</body>
</html>