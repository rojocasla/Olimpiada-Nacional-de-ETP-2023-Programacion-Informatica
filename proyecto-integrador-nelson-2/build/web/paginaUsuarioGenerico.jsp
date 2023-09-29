<%-- 
    Document   : paginaUsuarioGenerico
    Created on : 27/09/2023, 14:45:07
    Author     : estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        <h1>Usuario generico</h1>

        <nav>
            <ul class="menuNav">

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
                    </tr>
                </c:forEach>
            </tbody>

        </table>

    </body>
</html>
