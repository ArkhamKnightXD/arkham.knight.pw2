package arkham.knight.pw2;

import java.util.List;


public class EstudianteImplementInterface  implements EstudianteInterface {

    @Override
    public void insertar(Estudiante estudiante){DBEstudiante.listaEstudiantes.add(estudiante);}

    @Override
    public void actualizar(Estudiante estudiante) {
        for (int i = 0; i < encontrarEstudiantes().size(); i++) {
            if (encontrarEstudiantes().get(i).getMatricula() == estudiante.getMatricula()) {
                encontrarEstudiantes().get(i).setNombre(estudiante.getNombre());
                encontrarEstudiantes().get(i).setApellido(estudiante.getApellido());
                encontrarEstudiantes().get(i).setTelefono(estudiante.getTelefono());
            }
        }
    }

    @Override
    public void borrar(Estudiante estudiante) {
        DBEstudiante.listaEstudiantes.remove(estudiante);
    }

    @Override
    public List<Estudiante>encontrarEstudiantes(){return DBEstudiante.listaEstudiantes;}

    @Override
    public Estudiante encontrarPorMatricula(int matricula) {
        for (Estudiante estudiante : encontrarEstudiantes()) {
            if (estudiante.getMatricula() == matricula) {
                return estudiante;
            }
        }

        return null;
    }
}
