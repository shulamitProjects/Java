<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add book</title>
</head>
<body>
	<form method="post" action="registration/controller/BooksServlet">
		<table
			style="width: 70%; background-color: red; margin-top: 200px; margin-left: 100px; margin-right: 200px;">

			<tr>
				<td>
					<h3 style="color: brown">הספרים</h3>
				</td>
			</tr>
			<tr>
				<td>הכנס/י שם ספר :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>הכנס/י שם סופר/ת:</td>
				<td><input type="text" name="aouther"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="AddBook" value="הוספה"></td>

			</tr>
		</table>
	</form>
</body>
</html>