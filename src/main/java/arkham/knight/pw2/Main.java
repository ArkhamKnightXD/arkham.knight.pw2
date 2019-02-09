package arkham.knight.pw2;


import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;


import static spark.Spark.*;

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

        // redireccion  para el inicio de pagina
        get("/", (request, response) -> {
            response.redirect("/inicio");
            return null;
        });

        //Inicio que muestra todos los estudiantes registrados. Si hay
        get("/inicio", (request, response) -> {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("titulo", "CRUD sencillo de estudiantes registrados.");
            parametros.put("header", "Listado de estudiantes registrados.");
            parametros.put("agregarEstudiante", "Agregar nuevo estudiante");
            parametros.put("listaEstudiantes", estudianteService.encontrarEstudiantes());
            parametros.put("size", estudianteService.encontrarEstudiantes().size());

            return renderThymeleaf(parametros, "/inicio");
        });

        get("/insertar", (request, response) -> {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("metodo", "insertar");
            parametros.put("titulo", "Agregar estudiante.");
            parametros.put("header", "Agregar nuevo estudiante.");
            parametros.put("submit", "Insertar");

            return renderThymeleaf(parametros, "/form");
        });

        get("/editar", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            Estudiante estudiante = estudianteService.encontrarPorMatricula(matricula);

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("metodo", "editar");
            parametros.put("titulo", "Editar estudiante.");
            parametros.put("header", "Editar estudiante registrado.");
            parametros.put("submit", "Actualizar");
            parametros.put("mat", estudiante.getMatricula());
            parametros.put("nom", estudiante.getNombre());
            parametros.put("ape", estudiante.getApellido());
            parametros.put("tel", estudiante.getTelefono());

            return renderThymeleaf(parametros, "/form");
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

        get("/ver", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            Estudiante estudiante = estudianteService.encontrarPorMatricula(matricula);

            if (estudiante != null) {
                return estudiante.toJSON();
            } else {
                return "Estudiante no existe.";
            }
        });

        get("/borrar", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            Estudiante estudiante = estudianteService.encontrarPorMatricula(matricula);
            estudianteService.borrar(estudiante);

            response.redirect("/inicio");
            return null;
        });
    }

    public static String renderThymeleaf(Map<String, Object> parametros, String path) {
        return new ThymeleafTemplateEngine().render(new ModelAndView(parametros, path));
    }
}
