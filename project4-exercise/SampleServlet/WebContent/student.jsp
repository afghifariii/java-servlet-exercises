<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Student</h1>
	<form action="StudentServlet" method="post">
		<label for="name">Name :</label> <input type="text" name="name"
			id="name" />
		<button type="submit">Add</button>
	</form>

	<ol>
		<%
			if (request.getSession() != null) {
				for (String c : request.getSession().getValueNames()) {
					out.print("<li> " + request.getSession().getAttribute(c) + " </li>"
							+ "<form action=\"StudentServlet\" method=\"GET\">"
							+ "<input name=\"idx\" type=\"hidden\" value=\""+ c +"\" />"
							+ "<button type=\"submit\">"+"Remove"+"</button>"
							+ "</form>");
				}
			}
		%>
	</ol>
</body>
</html>