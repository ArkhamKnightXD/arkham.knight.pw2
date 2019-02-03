package arkham.knight.pw2;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;



public class Templates {

    public void ejemplosTemplatesFreeMarker(){

        //Indicando la carpeta por defecto que estaremos usando.
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Templates.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

}
}
