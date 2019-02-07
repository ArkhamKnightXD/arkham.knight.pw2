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

        //indicando los recursos publicos.
        //staticFiles.location("/META-INF/resources"); //para utilizar los WebJars.
        staticFiles.location("/publico");

        Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Main.class, "/templates");

        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);


        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Formulario tarea 2");
            return new ModelAndView(attributes, "formulario.ftl");
        }, freeMarkerEngine);

        /**
         * http://localhost:4567/datosEstudiante/20011136
         */
        get("/datosEstudiante/:matricula", (request, response) -> {
            //obteniendo la matricula.
            Estudiante estudiante= new Estudiante( "nombre","apellido",Integer.parseInt(request.params("id")),"telefono");

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);

            //enviando los parametros a la vista.
            return new ModelAndView(attributes, "datosEstudiante.ftl");
        }, freeMarkerEngine); //

        post("/procesarFormulario/", (request, response) -> {
            //obteniendo la matricula.

            String variableOculta = request.queryParams("variable_oculta");
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre =request.queryParams("nombre");
            String apellido =request.queryParams("apellido");
            String telefono =request.queryParams("telefono");
            System.out.println("La variable Oculta: "+variableOculta);

            Estudiante estudiante= new Estudiante(nombre, apellido, matricula, telefono);

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Procesando Estudiante");
            attributes.put("estudiante", estudiante);

            //enviando los parametros a la vista.
            return new ModelAndView(attributes, "formularioProcesado.ftl");
        }, freeMarkerEngine); //





    }
}
