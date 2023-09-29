<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <link rel="stylesheet" href="CSS/estilos.css">
        <title>Iniciar sesi&oacute;n</title>
    </head>
    <body>
        <div class="caja">
            <h1 class="login">Iniciar sesi&oacute;n</h1>
            
            <form action="registrar.do" method="post">
                <input type="hidden" name="accion" value="iniciarSesion">
                <label for="nombre">Usuario:</label>
                <input type="text" name="nombre"> <br>
                <br>
                <label for="contrasena">Contrase&ntilde;a:</label>
                <input type="password" name="contrasena" minlength="8"> <br>
                
                <% 
                String msj = (String) request.getAttribute("mensajeError");
                if (msj == null || msj.isEmpty()) {
                    msj = ""; 
                }
                %>

                <%=msj%>

                <button type="submit" class="boton">Iniciar sesi&oacute;n</button>
                
            </form>
        </div>
    </body>
</html>
