
<%@page import="com.mysql.cj.log.Log"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ספרים</title>
</head>
<body>

	<table
		style="width: 70%; background-color: red; margin-top: 200px; margin-left: 100px; margin-right: 200px;">
	
		<tr>
			<td width="119"><b>ספר</b></td>
			<td width="168"><b>משתמש</b></td>
		</tr>

		<% Iterator itr;%>
		<% List data = (List)request.getAttribute("booksHistory"); 
   for(itr=data.iterator();itr.hasNext();) 
   {
%>	
			<td width="119" type="string" name="User"><%=itr.next() %></td>
			<td width="168" type="string" name="Book"><%=itr.next() %></td> 

		</tr>
		<%} %>
	</table>

	<form action="/ProjectLibary/HomePage.jsp">
		<input type="submit" name="mainPage" value="חזרה לדף הבית">
	</form>
</body>
</html>


