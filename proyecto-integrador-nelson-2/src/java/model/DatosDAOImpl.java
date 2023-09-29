    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package model;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.List;

    public class DatosDAOImpl implements DatosDAO {
        private final Connection conexion;

        public DatosDAOImpl(Connection conexion) {
            this.conexion = conexion;
        }

        @Override
        public Datos obtenerUsuarioPorNombreUsuario(String nombre) {
            String consulta = "SELECT * FROM usuarios WHERE nombre = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {
                stmt.setString(1, nombre);
                ResultSet resultado = stmt.executeQuery();
                if (resultado.next()) {
                    Datos usuario = new Datos();
                    usuario.setId(resultado.getInt("id"));
                    usuario.setNombre(resultado.getString("nombre"));
                    usuario.setContrasena(resultado.getString("contrasena"));
                    return usuario;
                }
            } catch (SQLException e) {
            }
            return null;
        }

        @Override
        public List<Datos> obtenerTodosLosUsuarios() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
