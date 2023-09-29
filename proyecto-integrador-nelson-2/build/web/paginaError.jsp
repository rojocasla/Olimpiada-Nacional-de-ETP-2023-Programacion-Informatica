<%-- 
    Document   : paginaError
    Created on : 27/09/2023, 14:44:36
    Author     : estudiante
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    
    <p>Ha ocurrido un error:</p>
    <p><%= request.getAttribute("error") %></p>
    
</body>
</html>
