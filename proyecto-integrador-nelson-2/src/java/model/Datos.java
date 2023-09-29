package model;

public class Datos {
    private int id;
    private String nombre;
    private String contrasena;

    public Datos() {
    }

    public Datos(int id, String nombre, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Datos{" + "id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + '}';
    }
   
}
