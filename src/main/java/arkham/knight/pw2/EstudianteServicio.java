package arkham.knight.pw2;

import java.util.List;

public class EstudianteServicio implements EstudianteInterface {

    private EstudianteImplementInterface estudianteInterface;

    public EstudianteServicio(){
        estudianteInterface = new EstudianteImplementInterface();
    }

    @Override
    public void insertar(Estudiante estudiante) {
        estudianteInterface.insertar(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante){
        estudianteInterface.actualizar(estudiante);
    }

    @Override
    public void borrar(Estudiante estudiante){
        estudianteInterface.borrar(estudiante);
    }

    @Override
    public List<Estudiante> encontrarEstudiantes(){
        return estudianteInterface.encontrarEstudiantes();
    }

    @Override
    public Estudiante encontrarPorMatricula(int matricula){
        return estudianteInterface.encontrarPorMatricula(matricula);
    }
}
