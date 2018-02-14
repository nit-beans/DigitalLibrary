<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account </title>
</head>
<body>
<div align="center">
            <h1>Account History</h1>
     
           
            <table border="1">
                <th> No</th>
                <th>User Id</th>
                <th> Email</th>
                <th> Book Name</th>
                <th> Book Status</th>
                <th> Timestamp</th>
                
                 
                <c:forEach var="order" items="${orderlist}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${order.userId }
                    <td>${order.emailId}</td>
                    <td>${order.bookName}</td>
                    <td>${order.status }</td>
                    <td>${order.timestamp}</td>
                    
                    
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
</body>
</html>