/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paciente;
import model.PacienteDAO;
import model.PacienteDAOImpl;

@WebServlet("/insertarDatos.do")
public class InsertarDatosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PacienteDAO pdao = new PacienteDAOImpl();

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int dni = Integer.parseInt(request.getParameter("dni"));
        String internacion = request.getParameter("internacion");
        String observaciones = request.getParameter("observaciones");

        Paciente paciente = new Paciente(dni, nombre, apellido, dni, internacion, observaciones);

        pdao.agregarPaciente(paciente);

        List<Paciente> pacientes;
        pacientes = pdao.obtenerTodosLosPacientes();
        request.setAttribute("pacientes", pacientes);
        request.getRequestDispatcher("loginExitoso.jsp").forward(request, response);

    }
}
