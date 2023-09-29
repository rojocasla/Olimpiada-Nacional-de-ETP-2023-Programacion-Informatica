package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class PacienteDAOImpl implements PacienteDAO {

    @Override
    public void agregarPaciente(Paciente paciente) {

        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO pacientes (nombre, apellido, dni, internacion, observaciones) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, paciente.getNombre());
            statement.setString(2, paciente.getApellido());
            statement.setInt(3, paciente.getDni());
            statement.setString(4, paciente.getInternacion());
            statement.setString(5, paciente.getObservaciones());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }
    }

    @Override
    public Paciente obtenerPacientePorId(int id) {
        Paciente paciente = null;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM pacientes WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                paciente = new Paciente(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getInt("dni"),
                        resultSet.getString("internacion"),
                        resultSet.getString("observaciones")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }

        return paciente;
    }

    @Override
    public List<Paciente> obtenerTodosLosPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM pacientes";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Paciente paciente = new Paciente(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getInt("dni"),
                        resultSet.getString("internacion"),
                        resultSet.getString("observaciones")
                );
                pacientes.add(paciente);
            }
        } catch (SQLException e) {

            // Manejo de excepciones
        }

        return pacientes;

    }

    @Override
    public void actualizarPaciente(Paciente paciente) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "UPDATE pacientes SET nombre = ?, apellido = ?, dni = ?, internacion = ?, observaciones = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, paciente.getNombre());
            statement.setString(2, paciente.getApellido());
            statement.setInt(3, paciente.getDni());
            statement.setString(4, paciente.getInternacion());
            statement.setString(5, paciente.getObservaciones());
            statement.setInt(6, paciente.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }

    }

    @Override
    public void eliminarPaciente(int id) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "DELETE FROM pacientes WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

//    public static void main(String[] args) {
//
//        PacienteDAO pdao = new PacienteDAOImpl();
//        System.out.println(pdao.obtenerTodosLosPacientes());
//        pdao.agregarPaciente(new Paciente(0, "cerso", "cerso", 1111, "hab2", "mal"));
//        pdao.eliminarPaciente(5);
//        pdao.actualizarPaciente(new Paciente(6, "vicente", "cerso", 1111, "hab2", "mal"));
//        System.out.println(pdao.obtenerPacientePorId(6));
    @Override
    public Paciente buscarPaciente(int dni) {
        Paciente paciente = null;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM pacientes WHERE dni = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(dni, dni);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                paciente = new Paciente(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getInt("dni"),
                        resultSet.getString("internacion"),
                        resultSet.getString("observaciones")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }

        return paciente;

    }

}
