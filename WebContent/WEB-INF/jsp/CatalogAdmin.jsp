<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Catalog</title>
</head>
<body>




<div align="center">
            <h1>Books List</h1>
            
            Hello ${activeUser}
            <h3><a href="addBook.html">Add Book</a></h3>
            <table border="1">
                <th> No</th>
                <th> Book Name</th>
                <th> Book Author</th>
                <th> Book Category</th>
                <th> Book ISBN</th>
                <th> Action</th>
                 
                <c:forEach var="book" items="${booklist}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${book.bookName}</td>
                    <td>${book.bookAuthor}</td>
                    <td>${book.bookCategory}</td>
                    <td>${book.bookISBN}</td>
                    <td>
                        <a href="editBook.html?Id=${book.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deleteBook.html?Id=${book.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>

</body>
</html>