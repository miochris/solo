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

<!--  add new member -->
<a href="/mavenSoloWebProjectSpring/admin/adminAddMember">Add a new member</a><br> 

<!--  show member list -->


<a href="/mavenSoloWebProjectSpring/admin/AllMemberList">List all members</a><br> 

<!--  show All Fighter list  -->
<a href="/mavenSoloWebProjectSpring/admin/AllFighterList">List all fighters</a><br> 



<label>show fighters in one city 	</label>
<a href="/mavenSoloWebProjectSpring/admin/FightersInLondon">London</a>
<a href="/mavenSoloWebProjectSpring/admin/FightersInNY">NY</a> 
<a href="/mavenSoloWebProjectSpring/admin/FightersInTOKYO">TOKYO</a><br> 

<!--  show a member's fighters  -->

<a href="/mavenSoloWebProjectSpring/admin/OneMemberFighter">show one member;s fighters</a> <br>
<!-- logout -->
<a href="/mavenSoloWebProjectSpring/admin/Logout">Log Out</a> 
	<!--  



	show one member's Fighter list

	<form action="AdminServlet" method="post">
	show  fighter of member <input name="member" />  

		<input
			type="Submit" name="Submit" value="OneMembersFighterList" />
	</form>
	
show Fighters in One city 	
		<form action="AdminServlet" method="post">

		show  fighter in same city <input name="city" /> 
		
		<input type="Submit" name = "Submit" value="FightersInOneCity" />
	</form>
	
	
	Log out 
	
	<form action="AdminServlet" method="post">

		
		
		<input type="Submit" name = "Submit" value="LogOut" />
	</form>
-->
</body>
</html>