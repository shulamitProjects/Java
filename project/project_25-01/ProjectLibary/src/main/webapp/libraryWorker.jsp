<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>דף עובד ספרייה</title>
</head>
<body>
<%List lst=(List)request.getAttribute("booksData"); %>

<form method="post" action="/ProjectLibary/Registration.jsp">
	<input type="submit"  value="הוספת משתמש"></td>
	
</form>

<form method="get" action="ShowAllExistStudents">
	<input type="submit"  value="מחיקת משתמש"></td>
</form>

<form method="post" action="/ProjectLibary/AddBook.jsp">
	<input type="submit"  value="הוספת ספר"></td>
	
</form>
<form method="get" action="BooksServlet">
	<input type="submit"  value="מחיקת ספר"></td>
</form>




</body>
</html>