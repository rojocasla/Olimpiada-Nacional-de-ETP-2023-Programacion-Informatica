package controller;

import model.Paciente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PacienteDAO;
import model.PacienteDAOImpl;

@WebServlet(name = "ListarPacientesServlet", urlPatterns = {"/listarpacientes.do"})
public class ListarPacientesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PacienteDAO pacienteDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        // Inicializa el PacienteDAO al inicio del servlet
        pacienteDAO = new PacienteDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Paciente> pacientes = pacienteDAO.obtenerTodosLosPacientes();

        request.setAttribute("pacientes", pacientes);
        request.getRequestDispatcher("listarPacientes.jsp").forward(request, response);
    }
}
