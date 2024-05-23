<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>מחיקת ספרים</title>
</head>
<body>

<table
		style="width: 70%; background-color: red; margin-top: 200px; margin-left: 100px; margin-right: 200px;">
		<% int idBook=0;%>
			<tr>
			<td width="168"><b>שם</b></td>
			<td width="168"><b>סופר/ת</b></td>
			<td width="168"><b>האם למחוק</b></td>
			
		</tr>

		<% Iterator itr;%>
		<% List data = (List)request.getAttribute("booksData");%> 
<% for(itr=data.iterator();itr.hasNext();) 
   {	  
%>
<tr>
<form method="post" action="DeleteBookServlet">
			<input type="hidden" name="idBook" value="<%=itr.next()%>" />
			<td width="168" type="text" name="name"><%=itr.next() %></td>
			<td width="168" type="text" name="aouther"><%=itr.next() %></td>
			<input type="hidden" name="idBook" value="<%=itr.next()%>" />
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



