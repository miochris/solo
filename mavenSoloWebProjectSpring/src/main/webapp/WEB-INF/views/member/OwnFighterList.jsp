<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fighter List</title>
<style>


</style>
</head>
<body>

	Here are your fighters
	<table style="width:100%">
	<br>
	<tr>
		<th>Fighter Name</th>
		<th>Fighter Type</th>
		<th>Fighter price</th>
		<th>Num of wins</th>
		<th>Num of lost</th>
		<th>Strength</th>
	</tr>



	<c:forEach items="${OneMembersFighterList}" var="fighter">

			<tr>
				<td align="center"><c:out value="${fighter.name}" /></td>
				<td align="center"><c:out value="${fighter.type}" /></td>
				<td align="right"><c:out value="${fighter.price}" /></td>
				<td align="right"><c:out value="${fighter.nOfW}" /></td>
				<td align="right"><c:out value="${fighter.nOfL}" /></td>
				<td align="right"><c:out value="${fighter.strength}" /></td>
			</tr>
		</c:forEach>

</table>

<a href="/mavenSoloWebProjectSpring/member/MemberHome"> back to home</a> </br>
</body>
</html>