/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletActualizar", urlPatterns = {"/ServletActualizar"})
public class ServletActualizar extends HttpServlet {

    PacienteDAO pdao = new PacienteDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection cn = DBConnection.getConnection();
        String accion = request.getParameter("accion");

        int id = Integer.parseInt(request.getParameter("id"));

        if (accion.equals("borrar")) {
            pdao.eliminarPaciente(id);
            List<Paciente> pacientes;
            pacientes = pdao.obtenerTodosLosPacientes();
            request.setAttribute("pacientes", pacientes);

            request.getRequestDispatcher("loginExitoso.jsp").forward(request, response);
        } else if (accion.equals("update")) {
            Paciente paciente = pdao.obtenerPacientePorId(id);
            request.setAttribute("paciente", paciente);
            request.getRequestDispatcher("actualizarDatos.jsp").forward(request, response);
        } else if (accion.equals("buscar")) {
            
        } else if (accion.equals("mostrar")) {

//            int dni = Integer.parseInt(request.getParameter("dni"));
        
//            Paciente paciente = pdao.buscarPaciente(dni);
//            request.setAttribute("paciente", paciente);
//            request.getRequestDispatcher("mostrarPaciente.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection cn = DBConnection.getConnection();

        Paciente paciente = new Paciente();
        int id = Integer.parseInt(request.getParameter("id"));

        paciente.setId(Integer.parseInt(request.getParameter("id")));
        paciente.setNombre(request.getParameter("nombre"));
        paciente.setApellido(request.getParameter("apellido"));
        paciente.setDni(Integer.parseInt(request.getParameter("dni")));
        paciente.setInternacion(request.getParameter("internacion"));
        paciente.setObservaciones(request.getParameter("observaciones"));

        pdao.actualizarPaciente(paciente);
        List<Paciente> pacientes;
        pacientes = pdao.obtenerTodosLosPacientes();
        request.setAttribute("pacientes", pacientes);

        request.getRequestDispatcher("loginExitoso.jsp").forward(request, response);
    }

}
