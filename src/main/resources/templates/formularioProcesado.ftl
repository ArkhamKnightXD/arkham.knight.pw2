<!DOCTYPE html>
<html>
<head>

    <link href="/css/miEstilo.css" rel="stylesheet" >
    <link href="/css/formularioEstudiante.css" rel="stylesheet" >

    <title>${titulo}</title>
</head>
<body>
    <h1>Procesando Formulario</h1>
    <table>
        <tbody>
        <tr><td>Id</td><td>${estudiante.id}</td></tr>
        <tr><td>Matricula</td><td>${estudiante.matricula}</td></tr>
        <tr><td>Nombre</td><td>${estudiante.nombre}</td></tr>
        <tr><td>Apellido</td><td>${estudiante.apellido}</td></tr>
        <tr><td>Telefono</td><td>${estudiante.telefono}</td></tr>
        </tbody>
    </table>
</body>
</html>