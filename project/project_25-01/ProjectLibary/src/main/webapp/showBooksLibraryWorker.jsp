<%@page import="com.mysql.cj.log.Log"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>עובדי ספריה</title>
</head>
<body>
	<table
		style="width: 70%; background-color: red; margin-top: 200px; margin-left: 100px; margin-right: 200px;">
		<% int idBook=0;%>
			<tr>
			<td width="119"><b>שם</b></td>
			<td width="168"><b>סופר/ת</b></td>
			<td width="168"><b>השאלה</b></td>
			<td width="168"><b>משתמש</b></td>
		</tr>

		<% Iterator itr;%>
		<% List data = (List)request.getAttribute("booksData");%> 
<% for(itr=data.iterator();itr.hasNext();) 
   {
	  
%>

<tr>
<form method="get" action="LibraryWorkerServlet">
			<input type="hidden" name="idBook" value="<%=itr.next()%>" />
			<td width="119" type="text" name="name"><%=itr.next() %></td>
			<td width="168" name="aouther"><%=itr.next() %></td>
			<td><input type="submit" name="mainPage" value="DELETE"></td>
	
	</form>	</tr>
	<%} %>
	</table>

	<form method="post" action="/ProjectLibary">
		<input type="submit" name="mainPage" value="Go to Main Page...">
	</form>
</body>
</html>



