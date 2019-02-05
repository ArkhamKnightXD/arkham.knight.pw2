<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Kindle Dominicano</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">


    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
          integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
</head>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
      integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">


<body>
<div class="modal" id="exampleModal" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Resultados de la búsqueda</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="alert alert-primary">
                    <img src="http://2.bp.blogspot.com/_JXi92wDCOGk/TGF1W98DwWI/AAAAAAAABqI/jmXaiB8h0nE/s1600/Alice+book+cover2.jpg"
                         alt="Libro de Alicia" width="80px">
                    <h4>Alice in the Wonderland</h4>
                    <h6>Lewis Carol</h6>
                    <button class="button btn-primary">Obtener</button>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="/" style="">Kindle Dominicano</a>

    <input class="form-control form-control-dark w-100" id="buscar" type="text"
           placeholder="Buscar libros por Título, Autor"
           aria-label="Search">


    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
        Buscar
    </button>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="#" style="">Salir</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">


    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" id="inicio" href="#" style="">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-home">
                                <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                                <polyline points="9 22 9 12 15 12 15 22"></polyline>
                            </svg>
                            Inicio <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#" id="mislibros">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-layers">
                                <polygon points="12 2 2 7 12 12 22 7 12 2"></polygon>
                                <polyline points="2 17 12 22 22 17"></polyline>
                                <polyline points="2 12 12 17 22 12"></polyline>
                            </svg>
                            Mis libros
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

            <div id="vista" style="display: none" class="alert alert-primary alert-dismissible fade show" role="alert">
                <strong id="nombreNotificacion">Nombre del libro</strong>
                <div id="descripcionNotificacion"> ha sido guardado.</div>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="d-flex justify-content-start flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <div class="p-2 flex-grow-1 bd-highlight">
                    <h1 class="h2" id="titulo">Resultados de la b&uacute;squeda</h1>
                </div>

                <div id="botones">

                    <button class="btn btn-sm btn-primary" onclick="cambiarModo(0)">
                        <i class="far fa-window-maximize"></i> Cambiar a carta
                    </button>


                    &nbsp;

                    <button class="btn btn-sm btn-primary" onclick="cambiarModo(1)">
                        <i class="fas fa-table"></i> Cambiar a tabla
                    </button>

                </div>
            </div>


            <div id="libros"></div>

            <div id="tabla">

            </div>

    </div>

</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>

<!-- Icons -->
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
    feather.replace()
</script>

<script>

    var modo = 0;
    var librosRentados = [];

    $(document).ready(function () {

        document.getElementById("titulo").style.visibility = "hidden";

        $("#buscar").on('change', function () {
            busqueda();
        });

        $("#mislibros").on('click', function () {
            document.getElementById("inicio").classList.remove("active");
            document.getElementById("mislibros").classList.add("active");

            limpiarTodo();
            mostrarLibrosRentados();
            document.getElementById("titulo").innerHTML = "Mis libros";
            document.getElementById("botones").style.display = "none";


        });

        $("#inicio").on('click', function () {
            document.getElementById("inicio").classList.add("active");
            document.getElementById("mislibros").classList.remove("active");

            limpiarTodo();
            document.getElementById("titulo").innerHTML = "Resultados de la búsqueda";
            document.getElementById("botones").style.display = "block";

        });
    });

    function rentarLibro(busqueda) {

        console.log(busqueda + " id libro");
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "https://www.googleapis.com/books/v1/volumes?q=" + busqueda,
            success: function (valor) {
                valor.items.forEach(function (item) {
                    librosRentados.push({
                        id: item.id,
                        titulo: item.volumeInfo.title,
                        descripcion: item.volumeInfo.description,
                        foto: item.volumeInfo.imageLinks.thumbnail,
                        fecha: item.volumeInfo.publishedDate,
                        autores: item.volumeInfo.authors
                    });
                    console.log(librosRentados);
                });
            }
        });
    }

    function busqueda() {
        document.getElementById("titulo").style.visibility = "visible";
        var palabraClave = document.getElementById("buscar").value;
        if (palabraClave === "") {
            document.getElementById("titulo").style.visibility = "hidden";
        }


        buscar(palabraClave);
    }

    function buscar(palabraClave) {
        document.getElementById("buscar").value = palabraClave;

        console.log(palabraClave);
        limpiarTodo();

        if (modo === 0) {


            console.log(modo + " carta");
            sacarLibro(palabraClave);

        } else if (modo === 1) {

            console.log(modo + " tabla");
            sacarLibroTabla(palabraClave);
        }
    }

    function sacarLibro(busqueda) {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "https://www.googleapis.com/books/v1/volumes?q=" + busqueda,
            success: function (valor) {
                valor.items.forEach(function (item) {
                    var descripcion = item.volumeInfo.description === undefined ? "No tiene descripción." : item.volumeInfo.description;
                    var titulo = item.volumeInfo.title.toString();
                    console.log(valor);
                    document.getElementById("libros").innerHTML +=
                        "<div class='card mb-2'>" +
                        "<div class='row'>\n" +
                        "<div class='col-2'>\n" +
                        "<img src=" + item.volumeInfo.imageLinks.thumbnail + "  width='120' height='184' class='card-img-top' alt='libroX'> " +
                        "</div>\n" +
                        "<div class='col-10'>\n" +
                        "<div class='card-body'>\n" +
                        "<h5 class='card-title'>" + item.volumeInfo.title + "</h5>" +
                        "<p class='card-text descripcion'>" + descripcion + "</p>\n" +
                        "<p class='card-text'>" + "<b>Fecha de publicación: </b>" + item.volumeInfo.publishedDate + "</p>\n" +
                        "<a href=\"#\" class=\"btn btn-primary\" id='" + item.id + "' onclick='rentarLibro(this.id);NotificarRentaLibro(\""+ item.volumeInfo.title+"\");'><i class=\"fab fa-get-pocket\"></i>  Rentar</a>\n\n" +

                        "</div>" +

                        "<div class=\"d-flex align-items-end\">\n\n" +
                        "<div class=\"card-body\">\n" +
                        "<footer class='blockquote-footer'>Autor: <cite title='Source Title' >" + item.volumeInfo.authors.map(function (value) {
                            console.log(value);
                            return "<a class='btn-link' href='#' style='font-size: medium' onclick='probar(this);return false '>" + value + "</a>"
                        }).join(', ') + "</cite>" +
                        "</footer>" +
                        "</div>\n" +
                        "</div>" +
                        "</div>" +
                        "</div>";


                });

            }
        });


    }

    function probar(a) {

        console.log(a.text + " a link");
        buscar(a.text);
    }

    function mostrarLibrosRentados() {

        librosRentados.forEach(function (item) {
            var descripcion = item.descripcion === undefined ? "No tiene descripción." : item.descripcion;
            // console.log(valor);
            document.getElementById("libros").innerHTML +=
                "<div class='card mb-2'>" +
                "<div class='row'>\n" +

                "<div class='col-2'>\n" +
                "<img src=" + item.foto + "  width='120' height='184' class='card-img-top' alt='libroX'> " +
                "</div>\n" +
                "<div class='col-10'>\n" +
                "<div class='card-body'>\n" +
                "<h5 class='card-title'>" + item.titulo + "</h5>" +
                "<p class='card-text descripcion'>" + descripcion + "</p>\n" +
                "<p class='card-text'>" + "<b>Fecha de publicación: </b>" + item.fecha + "</p>\n" +
                "<a href=\"#\" class=\"btn btn-primary\" id='" + item.id + "' onclick='rentarLibro(this.id)'><i class=\"fab fa-get-pocket\"></i>  Rentar</a>\n\n" +
                "</div>" +

                "<div class=\"d-flex align-items-end\">\n\n" +
                "<div class=\"card-body\">\n" +
                "<footer class='blockquote-footer'>Autor: <cite title='Source Title' >" + item.autores.map(function (value) {
                    console.log(value);
                    return "<a class='btn-link' href='#' style='font-size: medium' onclick='probar(this);return false '>" + value + "</a>"
                }).join(', ') + "</cite>" +
                "</footer>" +
                "</div>\n" +
                "</div>" +
                "</div>" +
                "</div>";


        });
    }

    function sacarLibroTabla(busqueda) {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "https://www.googleapis.com/books/v1/volumes?q=" + busqueda,
            success: function (valor) {

                document.getElementById("tabla").innerHTML +=
                    "<div class='table-responsive'>" +
                    "<table class='table table-striped'>" +
                    "<thead>" +
                    "<tr>" +
                    "<th>Título</th>" +
                    "<th>Imagen</th>" +
                    "<th>Descripción</th>" +
                    "<th>Fecha de publicación</th>" +
                    "<th>Autores</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody id='tablalibro'>" +

                    "</tbody>" +
                    "</table>" +

                    "</div>";

                valor.items.forEach(function (item) {
                    var descripcion = item.volumeInfo.description === undefined ? "No tiene descripción." : item.volumeInfo.description;
                    if (item.volumeInfo.description === undefined) {
                        descripcion = "No tiene descripción";
                    } else {
                        descripcion = descripcion.substr(0, 150) + "...";
                    }
                    document.getElementById("tablalibro").innerHTML +=
                        "<tr>" +
                        "<td>" + item.volumeInfo.title + "</td>" +
                        "<td>" + "<img src=" + item.volumeInfo.imageLinks.thumbnail + "  width='48'  class='card-img-top' alt='libroX'> </td>" +
                        "<td>" + descripcion + "</td>" +
                        "<td>" + item.volumeInfo.publishedDate + "</td>" +
                        "<td>" + item.volumeInfo.authors.map(function (value) {
                            return "<a class='btn-link' href='#' style='font-size: medium' onclick='probar(this);return false '>" + value + "</a>"
                        }).join(', ') + "</tr>";

                })

            }
        })
    }

    function cambiarModo(valor) {

        modo = valor;

        var texto = document.getElementById("buscar").value;
        if (texto !== "") {

            busqueda();
        }
    }

    function limpiarTodo() {
        $("#tabla").empty();
        $("#libros").empty();
    }

    function NotificarRentaLibro(nombre) {

        console.log("nombre libro notificacion: " + nombre);

        if (document.getElementById("vista").style.display === "none") {

            document.getElementById("vista").style.display = "block";
            document.getElementById("nombreNotificacion").innerHTML = nombre;

        }

        setTimeout(function () {


            document.getElementById("vista").style.display = "none";
        }, 2000);

    }
</script>

</body>
</html>
