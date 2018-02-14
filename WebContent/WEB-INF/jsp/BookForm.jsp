<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add/Edit</title>
</head>
<body>
<div align="center">
        <h1>New/Edit Book</h1>
        <form:form action="saveBook.html" method="post" modelAttribute="book">
        <table>
            <form:hidden path="Id"/>
            <tr>
                <td>Book Name:</td>
                <td><form:input path="BookName" /></td>
            </tr>
            <tr>
                <td>Book Author</td>
                <td><form:input path="BookAuthor" /></td>
            </tr>
            <tr>
                <td>Book Category</td>
                <td><form:input path="BookCategory" /></td>
            </tr>
            <tr>
                <td>Book ISBN:</td>
                <td><form:input path="BookISBN" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>