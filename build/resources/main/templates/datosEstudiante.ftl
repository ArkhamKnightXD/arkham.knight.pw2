<!DOCTYPE html>
<html>
<head>
    <title>Información Estudiante ${estudiante.nombre}</title>
    <link href="/css/miEstilo.css" rel="stylesheet" >
    <link href="/css/formularioEstudiante.css" rel="stylesheet" >
</head>
<body>
<h1>Matrícula ${estudiante.matricula?string["0"]} -  ${estudiante.nombre}</h1>
<h2>su apellido es ${estudiante.apellido}</h2>
<h2>su apellido es ${estudiante.telefono}</h2>
<h2>su apellido es ${estudiante.id?string["0"]}</h2>
</body>
</html>