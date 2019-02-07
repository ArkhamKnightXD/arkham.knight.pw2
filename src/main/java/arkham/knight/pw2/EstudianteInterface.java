package arkham.knight.pw2;

import java.util.List;


public interface EstudianteInterface {

    void insertar(Estudiante estudiante);

    void actualizar(Estudiante estudiante);

    void borrar(Estudiante estudiante);

    List<Estudiante>encontrarEstudiantes();

    Estudiante encontrarPorMatricula(int matricula);


}
