<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>מחיקת na,naho</title>
</head>
<body>

<table
		style="width: 70%; background-color: red; margin-top: 200px; margin-left: 100px; margin-right: 200px;">
		<% int idUser=0;%>
			<tr>
			<td width="168"><b>שם משתמש</b></td>
			<td width="168"><b>סיסמה</b></td>
			<td width="168"><b>האם למחוק?</b></td>
			
		</tr>

		<% Iterator itr;%>
		<% List data = (List)request.getAttribute("studentsData");%> 
<% for(itr=data.iterator();itr.hasNext();) 
   {	  
%>
<tr>
<form method="post" action="DeleteStudentServlet">
			<input type="hidden" name="idUser" value="<%=itr.next()%>" />
			<td width="168" type="text" name="UserName"><%=itr.next() %></td>
			<td width="168" type="text" name="Password"><%=itr.next() %></td>
			
			<td><input type="submit" name="mainPage" value="מחיקה"></td>
	
	</form>	</tr>
	<%} %>
	</table>
	<form action="/ProjectLibary/libraryWorker.jsp">
		<input type="submit" name="mainPage"
			value="חזרה לדף הבית">
		</td>
	</form>

</body>
</html>



