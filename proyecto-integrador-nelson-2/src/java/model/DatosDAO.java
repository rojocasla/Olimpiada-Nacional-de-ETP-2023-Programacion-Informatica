package model;

import java.util.List;

public interface DatosDAO {
    Datos obtenerUsuarioPorNombreUsuario(String nombre);
    List<Datos> obtenerTodosLosUsuarios();
    
}
