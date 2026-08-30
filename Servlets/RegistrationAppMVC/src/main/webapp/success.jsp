<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Success JSP</title>
</head>
<body>
<h1><marque>Registration is successfully</marque></h1>
<% String name = (String) session.getAttribute("name"); %>
<h2>Hey <%= name%>, welcome to our application</h2>
</body>
</html>