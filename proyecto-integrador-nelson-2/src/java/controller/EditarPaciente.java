/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditarPaciente", urlPatterns = {"/editarpaciente.do"})
public class EditarPaciente extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            
            // Realiza la conexión a la base de datos (asegúrate de configurar los valores correctos)
            String jdbcUrl = "jdbc:mysql://localhost:3306/dbpacientes";
            String usuario = "admin";
            String contraseña = "administrador";

            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
                String sql = "SELECT * FROM pacientes WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    int dni = resultSet.getInt("dni");
                    String internacion = resultSet.getString("internacion");
                    String observaciones = resultSet.getString("observaciones");

                    // Coloca los datos en el request para mostrarlos en la página de edición
                    request.setAttribute("id", id);
                    request.setAttribute("nombre", nombre);
                    request.setAttribute("apellido", apellido);
                    request.setAttribute("dni", dni);
                    request.setAttribute("internacion", internacion);
                    request.setAttribute("observaciones", observaciones);

                    // Redirige a la página de edición (ajusta la URL según la estructura de tu proyecto)
                    request.getRequestDispatcher("editarPaciente.jsp").forward(request, response);
                } else {
                    // Manejo de error si no se encuentra el paciente
                    response.sendRedirect("paginaError.jsp");
                }

                connection.close();
            } catch (SQLException e) {
                // Manejo de errores de conexión
                response.sendRedirect("paginaError.jsp");
            }
        } else {
            // Manejo de error si no se proporciona un ID válido
            response.sendRedirect("paginaError.jsp");
        }
    }
}
