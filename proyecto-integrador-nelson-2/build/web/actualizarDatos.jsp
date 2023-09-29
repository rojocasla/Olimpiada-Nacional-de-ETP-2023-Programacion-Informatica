<%-- 
    Document   : actualizarDatos
    Created on : 28/09/2023, 18:17:39
    Author     : estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar datos</h1>
    <form action="ServletActualizar" method="post">
        <input type="hidden" name="id" value="${paciente.id}">
        <label>Nombre: </label>
        <input type="text" name="nombre" required value="${paciente.nombre}"><br>
        <label>Apellido: </label>
        <input type="text" name="apellido" required value="${paciente.apellido}"><br>
        <label>DNI: </label>
        <input type="text" name="dni" required value="${paciente.dni}"><br>
        <label>Internación: </label>
        <input type="text" name="internacion" required value="${paciente.internacion}"><br>
        <label>Observaciones: </label>
        <input type="text" name="observaciones" required value="${paciente.observaciones}"><br>
        <input type="submit" value="Editar Paciente">
    </form>
    
    </body>
</html>
