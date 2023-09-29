package model;

import java.util.List;

public interface PacienteDAO {
    // Métodos para operaciones CRUD (Create, Read, Update, Delete)

    // Crea un nuevo paciente
    void agregarPaciente(Paciente paciente);

    // Obtiene un paciente por su ID
    Paciente obtenerPacientePorId(int id);

    // Obtiene todos los pacientes
    List<Paciente> obtenerTodosLosPacientes();

    // Actualiza la información de un paciente
    void actualizarPaciente(Paciente paciente);

    // Elimina un paciente por su ID
    void eliminarPaciente(int id);
    
    
    Paciente buscarPaciente(int dni);
}
