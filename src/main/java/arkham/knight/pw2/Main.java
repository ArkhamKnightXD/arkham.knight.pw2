package arkham.knight.pw2;


import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;


import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        EstudianteServicio estudianteServicio = new EstudianteServicio();
        estudianteServicio.insertar(new Estudiante("Karvin","Jimenez",20141336,"8095445787"));
        estudianteServicio.insertar(new Estudiante("Pedrito","Espinal", 2014615,"2454154544"));
        estudianteServicio.insertar(new Estudiante("Carol","Grimes", 2014445,"244427474"));


        //indicando los recursos publicos.
        //staticFiles.location("/META-INF/resources"); //para utilizar los WebJars.
        staticFiles.location("/publico");



        Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Main.class, "/templates");

        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);


        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            return new ModelAndView(attributes, "index.ftl");
        }, freeMarkerEngine);

        get("/crud", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "CRUD sencillo de estudiantes registrados.");
            attributes.put("header", "Estudiantes registrados");
            attributes.put("agregarEstudiante", "Agregar nuevo estudiante");
            attributes.put("listaEstudiante", estudianteServicio.encontrarEstudiantes());
            attributes.put("size", estudianteServicio.encontrarEstudiantes().size());
            return new ModelAndView(attributes, "crud.ftl");
        }, freeMarkerEngine);




    }
}
