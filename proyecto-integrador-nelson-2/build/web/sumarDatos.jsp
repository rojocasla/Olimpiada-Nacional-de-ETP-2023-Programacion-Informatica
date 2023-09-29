<%-- 
    Document   : sumarDatos
    Created on : 28/09/2023, 09:29:24
    Author     : estudiante
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sumar Datos</title>
</head>
<body>
    <h1>Sumar Datos</h1>
    <form action="insertarDatos.do" method="post">
        <label>Nombre: </label>
        <input type="text" name="nombre" required><br>
        <label>Apellido: </label>
        <input type="text" name="apellido" required><br>
        <label>DNI: </label>
        <input type="text" name="dni" required><br>
        <label>Internación: </label>
        <input type="text" name="internacion" required><br>
        <label>Observaciones: </label>
        <textarea name="observaciones"></textarea><br>
        <input type="submit" value="Agregar Paciente">
    </form>
    
    
</body>
</html>
