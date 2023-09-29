
<%-- 
    Document   : loginExitoso
    Created on : 26/09/2023, 14:01:53
    Author     : estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/estilosAdmin.css">
        <title>Administrador</title>
    </head>
    <body>


        <header>
            <h1 class="titulo">
                Panel Administrador
            </h1>
        </header>

        <nav>
            <ul class="menuNav">

                <li><a href="sumarDatos.jsp">Agregar Datos</a></li>
                <li><a href="ServletActualizar?accion=buscar&id=0">Buscar por DNI</a></li>

            </ul>
        </nav>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>DNI</th>
                    <th>Internacion</th>
                    <th>Observaciones</th>
                    <th>Actualizar</th>
                    <th>Borrar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${pacientes}">

                    <tr>
                        <td><c:out value="${p.id}"></c:out></td>
                        <td><c:out value="${p.nombre}"></c:out></td>
                        <td><c:out value="${p.apellido}"></c:out></td>
                        <td><c:out value="${p.dni}"></c:out></td>
                        <td><c:out value="${p.internacion}"></c:out></td>
                        <td><c:out value="${p.observaciones}"></c:out></td>
                        <td> <a href="ServletActualizar?accion=update&id=<c:out value="${p.id}"></c:out>">Actualizar</a> </td>
                        <td> <a href="ServletActualizar?accion=borrar&id=<c:out value="${p.id}"></c:out>">Borrar</a> </td>
                     
                    </tr>
                </c:forEach>
            </tbody>

        </table>


    </body>
</html>
