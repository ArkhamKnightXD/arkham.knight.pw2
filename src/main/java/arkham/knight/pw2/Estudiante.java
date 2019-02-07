package arkham.knight.pw2;

import java.io.Serializable;

public class Estudiante implements Serializable {

    private static String nombre;
    private static String apellido;
    private static int matricula;
    private static String telefono;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Estudiante.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        Estudiante.apellido = apellido;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        Estudiante.matricula = matricula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        Estudiante.telefono = telefono;
    }


    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, int matricula, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.telefono = telefono;
    }
}
