<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hi <c:out value="${memberLoggedIn.name}"></c:out> Your balance is: <c:out value="${memberLoggedIn.balance}"></c:out> </br>

<!-- show your fighter list -->
<a href="/mavenSoloWebProjectSpring/member/AllFighterList"> see your fighters</a> </br>

<!-- Add fighter --> 
<a href="/mavenSoloWebProjectSpring/member/AddFighterCat"> add cat</a> </br>


<a href="/mavenSoloWebProjectSpring/member/AddFighterDog"> add dog</a> </br>

<!-- show other fighters In Your City  --> 

<a href="/mavenSoloWebProjectSpring/member/FightersInYourCity"> show other fighters In Your City </a> </br>

<!-- log out --> 

<a href="/mavenSoloWebProjectSpring/member/Logout"> log out </a> </br>
</body>
</html>