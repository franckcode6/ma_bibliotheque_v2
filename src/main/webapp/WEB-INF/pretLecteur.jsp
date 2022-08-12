<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
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
    <h2>${lecteur.id} - ${lecteur.nom} ${lecteur.prenom}</h2>
    <ul>
        <li>Email : ${lecteur.email}</li>
        <li>Né le : ${lecteur.dateDeNaissance}</li>
    </ul>

    <form method="post">
        <h2>Ajouter un pret</h2>
        <label for="livreID">ID du livre</label>
        <input type="number" id="livreID" name="LIVRE_ID">
        <input type="submit" value="Ajouter">
    </form>
</main>
</body>
</html>