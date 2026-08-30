<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP WEB APP</title>
</head>
<body>
<h1>JSP Web App to generate Dynamic response!</h1>

<%-- this is directive tag (used for import libraries)--%>
<%@ page import = "java.util.Date" %>

<%-- this is declaration tag (used for variable decalration)--%>
<%!
    int age = 18;
%>

<%-- this is Scriplets tag (used for service method)--%>
<%
    String name = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    Date date = new Date();
    out.println("Hello " + name );

%>

<%--this is Expression tag--%>
<h2> <%= date %> </h2>
<h2> This is your email: <%= email %> </h2>
<h2> Your agae is: <%= age %> </h2>
</body>
</html>

<%--
In JSP we need not write to Class name, Method name(ex: doPost(), doGet()...)
if we write any body within the scriplets tag( <%  %> ) that body is consider as the body of service method.

here we need not have to wite any objects.. Behind the scene internally implicit object
--%>

<%--In the industry we use Servlet to write the java code (means to handle the request, write the business logic..)
and JSP page we use for the view pages (whatever we want show the client, for example may be I want to show that
"registration is successfull" or etc..)
--%>