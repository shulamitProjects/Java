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
			<td width="119"><b>שם</b></td>
			<td width="168"><b>סופר/ת</b></td>
			<td width="168"><b>האם מושאל?</b></td>
			<td width="168"><b>למי מושאל?</b></td>
		</tr>

		<% Iterator itr;%>
		<% List data = (List)request.getAttribute("booksData"); 
   for(itr=data.iterator();itr.hasNext();) 
   {
%>
		<tr>
			<td width="119"><%=itr.next() %></td>
			<td width="168"><%=itr.next() %></td>
			<td width="168"><%=itr.next() %></td>
			<td width="168"><button>החזרה</button></td>
			<form method="post" action="/ProjectLibary">
				<input type="submit" name="mainPage" value="Return Book">
			</form>

		</tr>
		<%} %>
	</table>
	<form method="post" action="/ProjectLibary">
		<input type="submit" name="mainPage" value="חזרה לדף הבית">
	</form>
</body>
</html>

