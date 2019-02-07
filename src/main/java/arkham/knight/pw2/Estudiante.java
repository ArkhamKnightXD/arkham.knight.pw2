package arkham.knight.pw2;

import java.io.Serializable;

public class Estudiante implements Serializable {

    private static String nombre;
    private static String apellido;
    private static int matricula;
    private static String telefono;



    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Estudiante.nombre = nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
        Estudiante.apellido = apellido;
    }

    public static int getMatricula() {
        return matricula;
    }

    public static void setMatricula(int matricula) {
        Estudiante.matricula = matricula;
    }

    public static String getTelefono() {
        return telefono;
    }

    public static void setTelefono(String telefono) {
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
