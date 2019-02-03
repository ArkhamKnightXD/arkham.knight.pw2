package arkham.knight.pw2;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        //indicando los recursos publicos.
        //staticFiles.location("/META-INF/resources"); //para utilizar los WebJars.
        staticFiles.location("/publico");


    }
}
