
<%@page import="com.mysql.cj.log.Log"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Books</title>
</head>
<body>



	<table
		style="width: 70%; background-color: red; margin-top: 200px; margin-left: 100px; margin-right: 200px;">

		<% int id=(int)request.getAttribute("id");%>
		<% int idBook=0;%>

		<tr>
			<td width="119"><b>שם</b></td>
			<td width="168"><b>סופר/ת</b></td>
			<td width="168"><b>האם הושאל</b></td>
		</tr>

		<% Iterator itr;%>
		<% List data = (List)request.getAttribute("booksData"); 
   for(itr=data.iterator();itr.hasNext();) 
   {

%>
		<form method="post" action="BorrowServlet">
			<input type="hidden" name="id" value="<%=id%>" />
			<input type="hidden" name="idBook" value="<%=itr.next()%>" />
			<td width="119" type="text" name="name"><%=itr.next() %></td>
			<td width="168" name="aouther"><%=itr.next() %></td> 
			<% if(itr.next().equals("true")){%>
			<td><input type="submit" name="mainPage" value="החזרה"></td>
			<%}else  {%>
			<td><input type="submit" name="mainPage" value="השאלה"></td>
			<%} %>

		</form>

		</tr>
		<%} %>
	</table>
<form method="get" action="HistoryServlet">
<input type="hidden" name="idPerson" value="<%=id%>" />
<input type="hidden" name="type" value="student"/>
<input type="submit" value="היסטוריה">
</form>
	<form method="post" action="/ProjectLibary">
		<input type="submit" name="mainPage" value="חזרה לדף הבית">
	</form>
</body>
</html>


