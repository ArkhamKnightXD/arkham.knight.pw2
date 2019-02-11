package arkham.knight.pw2;


import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        EstudianteServicio estudianteService = new EstudianteServicio();
        estudianteService.insertar(new Estudiante(20130001, "Karvin", "Jimenez", "809544564"));
        estudianteService.insertar(new Estudiante(20130002, "Jack", "Raiden", "809956545"));
        estudianteService.insertar(new Estudiante(20130003, "Pedrito", "Espinal", "802574548"));
        estudianteService.insertar(new Estudiante(20130003, "Alex", "Santos", "8025754648"));

        String projectDir = System.getProperty("user.dir");
        String staticDir = "/src/main/resources";
        staticFiles.externalLocation(projectDir + staticDir);

        // de esta forma puedo redirigir la pagina a inicio
        get("/", (request, response) -> {
            response.redirect("/inicio");
            return null;
        });


        //Inicio que muestra todos los estudiantes registrados. Si hay
        get("/inicio", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Practica 2 programacion web.");
            attributes.put("listaEstudiantes", estudianteService.encontrarEstudiantes());

            return renderThymeleaf(attributes, "/inicio");
        });

        get("/insertar", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("metodo", "insertar");
            attributes.put("titulo", "Agregando estudiante.");
            attributes.put("header", "Agregar nuevo estudiante.");
            attributes.put("submit", "Insertar");

            return renderThymeleaf(attributes, "/form");
        });

        get("/editar", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            Estudiante estudiante = estudianteService.encontrarPorMatricula(matricula);

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("metodo", "editar");
            attributes.put("titulo", "Editar estudiante.");
            attributes.put("header", "Editar estudiante registrado.");
            attributes.put("submit", "Actualizar");
            attributes.put("matricula", estudiante.getMatricula());
            attributes.put("nombre", estudiante.getNombre());
            attributes.put("apellido", estudiante.getApellido());
            attributes.put("telefono", estudiante.getTelefono());

            return renderThymeleaf(attributes, "/form");
        });

        post("/editar", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            Estudiante estudiante = estudianteService.encontrarPorMatricula(matricula);

            estudiante.setMatricula(Integer.parseInt(request.queryMap().get("matricula").value()));
            estudiante.setNombre(request.queryMap().get("nombre").value());
            estudiante.setApellido(request.queryMap().get("apellido").value());
            estudiante.setTelefono(request.queryMap().get("telefono").value());

            estudianteService.actualizar(estudiante);

            response.redirect("/inicio");
            return null;
        });

        post("/insertar", ((request, response) -> {
            Estudiante estudiante = new Estudiante();
            estudiante.setMatricula(Integer.parseInt(request.queryMap().get("matricula").value()));
            estudiante.setNombre(request.queryMap().get("nombre").value());
            estudiante.setApellido(request.queryMap().get("apellido").value());
            estudiante.setTelefono(request.queryMap().get("telefono").value());

            estudianteService.insertar(estudiante);

            response.redirect("/inicio");
            return null;
        }));

//Esta parte se encarga del borrado del crud
        get("/borrar", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            Estudiante estudiante = estudianteService.encontrarPorMatricula(matricula);
            estudianteService.borrar(estudiante);

            response.redirect("/inicio");
            return null;
        });
    }

    public static String renderThymeleaf(Map<String, Object> attributes, String path) {
        return new ThymeleafTemplateEngine().render(new ModelAndView(attributes, path));
    }
}
