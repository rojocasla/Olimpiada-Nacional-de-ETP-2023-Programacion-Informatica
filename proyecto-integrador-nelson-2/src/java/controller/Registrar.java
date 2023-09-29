
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paciente;
import util.DBConnection;
import model.PacienteDAO;
import model.PacienteDAOImpl;

/**
 *
 * @author estudiante
 */
@WebServlet("/registrar.do")
public class Registrar extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Connection cn = DBConnection.getConnection();
    PacienteDAO pdao = new PacienteDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("iniciarSesion".equals(accion)) {
            String nombre = request.getParameter("nombre");
            String contrasena = request.getParameter("contrasena");

            // Aquí debes verificar las credenciales en tu base de datos
            // Puedes usar la clase DatosDAOImpl para hacer esto
            // Si las credenciales son válidas, redirige al usuario a otra página
            if (verificarCredenciales(nombre, contrasena)) {
                String rolUsuario = obtenerRolUsuario(nombre);
                List<Paciente> pacientes;
                pacientes = pdao.obtenerTodosLosPacientes();
                request.setAttribute("pacientes", pacientes);
          
                
                request.getRequestDispatcher("loginExitoso.jsp").forward(request, response);
                
                if (null == rolUsuario) {
                    // Otro manejo en caso de roles desconocidos
                    response.sendRedirect("paginaError.jsp");
                } else {
                    switch (rolUsuario) {
                        case "administrador":
                            // Redirigir al usuario administrador a una página de administrador
                            response.sendRedirect("loginExitoso.jsp");
                            break;
                        case "usuario_generico":
                            // Redirigir al usuario genérico a una página de usuario genérico
                            response.sendRedirect("paginaUsuarioGenerico.jsp");
                            break;
                        default:
                            // Otro manejo en caso de roles desconocidos
                            response.sendRedirect("paginaError.jsp");
                            break;
                    }
                }
            } else {
                // Si las credenciales son incorrectas, muestra un mensaje de error
                request.setAttribute("mensajeError", "Credenciales incorrectas");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    private boolean verificarCredenciales(String nombre, String contrasena) {
        return ("admin".equals(nombre) && "administrador".equals(contrasena))
                || ("user".equals(nombre) && "usuarioo".equals(contrasena));
    }

    private String obtenerRolUsuario(String nombre) {
        if (null == nombre) {
            return "desconocido"; // Maneja casos desconocidos
        } else {
            switch (nombre) {
                case "admin":
                    return "administrador";
                case "user":
                    return "usuario_generico";
                default:
                    return "error."; // Maneja casos desconocidos
            }
        }
    }

}
