<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!doctype html>
<html lang="fre">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Nouveau Pret</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <style>
        <%@include file="style/style.css"%>
    </style>
</head>
<body>
<header class="mb-5">
    <div class="container d-flex align-items-center justify-content-between">
        <h1>Ma bibliothèque</h1>
        <nav class="d-flex justify-content-between">
            <a href="pret" class="lien">Pret</a>
            <a href="#" class="lien ms-3">Se connecter</a>
        </nav>
    </div>
</header>
<main class="container">
    <h2>Nouveau Pret</h2>
    <form action="/pret/lecteur" method="get">
        <label for="idUtilisateur">ID du lecteur</label>
        <br>
        <input type="number" id="idUtilisateur" name="id">
        <br>
        <input type="submit" value="Saisir" class="mt-3 btn btn-sm btn-success">
    </form>
</main>

</body>
</html>