<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <spring:url value="/resources/style.css" var="styleCSS" />
<link href="${styleCSS}" rel="stylesheet" /> --%>
<!-- <link href="/resources/style.css" rel="stylesheet" type="text/css" /> -->
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}
#login{
  float:right;
}

li a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
</style>
<title>Digital Library</title>

</head>
<body>
<h1> Digital Library</h1>
<div>
<ul>
<li><a href=Home.jsp>Home</a></li>
<li><a href=#about>About us</a></li>
<li><a href=#catalog>Catalog</a></li>
<li id=login><a href= Login.jsp>Register/login</a></li>
</ul>
</div>
</body>
</html>