<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Failure JSP</title>
</head>
<body>
<h1><marque>Registration failed</marque></h1>
<% String name = (String) session.getAttribute("name"); %>
<h2>Hey <%= name%>, you failed to register our application</h2>
</body>
</html>
