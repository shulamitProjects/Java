<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>דף הרשמה</title>
</head>
<body>

	<form method="get" action="registration/controller/StudentServlet">
		<%String type=""; %><table
			style="width: 70%; background-color: green; margin-top: 200px; margin-left: 100px; margin-right: 200px;">

			<tr>
				<td>
					<h3 style="color: brown">שלום תלמיד</h3>
				</td>
			</tr>
			<tr>
				<td>הכנס/י שם משתמש/ת</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>הכנס/י סיסמה </td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
			<td><input type="hidden" name="type" value="student" /></td>
				<td><input type="submit"  value="כניסה"></td>
			</tr>
		</table>
	</form>
</body>
</html>