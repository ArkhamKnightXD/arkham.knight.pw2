<!DOCTYPE html>
<html>
<head>



<title>${titulo}</title>

    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <link href="/css/formularioEstudiante.css" rel="stylesheet">



    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

    <h1>Registro de estudiante</h1>
    <form action="/procesarFormulario/" method="post">

        <div class="form-group">
            <label for="matricula">Matricula</label>
            <input type="number" class="form-control" id="matricula" aria-describedby="matricula" placeholder="Inserte la matricula..">
        </div>

        <div class="form-group">
            <label for="name">Nombre</label>
            <input type="text" class="form-control" id="name" aria-describedby="name" placeholder="Inserte el nombre...">
        </div>
        <div class="form-group">
            <label for="apellido">Apellido</label>
            <input type="text" class="form-control" id="apellido" aria-describedby="apellido" placeholder="Inserte el apellido...">
        </div>

        <div class="form-group">
            <label for="telefono">Telefono</label>
            <input type="text" class="form-control" id="telefono" aria-describedby="telefono" placeholder="Inserte el telefono...">
        </div>


        <button name="Enviar" type="submit" class="btn btn-primary">Enviar</button>
    </form>



</body>
</html>