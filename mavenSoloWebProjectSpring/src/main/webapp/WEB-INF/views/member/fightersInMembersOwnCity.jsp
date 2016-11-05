<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Here are the fighters in your city: <c:out value="${city}"/>
	
	<table style="width: 100%">
		<tr>
			<th>Fighter id</th>
			<th>Fighter Name</th>
			<th>Number of wins</th>
			<th>Number of lost</th>
			<th>Fighter price</th>
			<th>owner's id</th>
		</tr>



		<c:forEach items="${FightersInYourCity}" var="fighter">

			<tr>
				<td align="center"><c:out value="${fighter.id}" /></td>
				<td align="center"><c:out value="${fighter.name}" /></td>
				<td align="center"><c:out value="${fighter.nOfW}" /></td>
				<td align="center"><c:out value="${fighter.nOfL}" /></td>
				<td align="center"><c:out value="${fighter.price}" /></td>
				<td align="center"><c:out value="${fighter.member.id}" /></td>
				<td align="center"><a href="buy?fighterId=${fighter.id}">buy</a></td>
				<td align="center">   <a href="FightThisFighter?oppoFighterId=${fighter.id}">Fight </a> </td>
			</tr>
		</c:forEach>


	</table>
	
	<a href="/mavenSoloWebProjectSpring/member/MemberHome"> back to home</a> </br>
</body>
</html>