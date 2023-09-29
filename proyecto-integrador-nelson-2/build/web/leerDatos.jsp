<%-- 
    Document   : leerDatos
    Created on : 27/09/2023, 20:56:25
    Author     : estudiante
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Pacientes</title>
</head>
<body>
    <h1>Listado de Pacientes</h1>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>DNI</th>
            <th>Internación</th>
            <th>Observaciones</th>
        </tr>
        <c:forEach var="paciente" items="($pacientes)">
            <tr>
                <td>${paciente.id}</td>
                <td>${paciente.nombre}</td>
                <td>${paciente.apellido}</td>
                <td>${paciente.dni}</td>
                <td>${paciente.internacion}</td>
                <td>${paciente.observaciones}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>


