<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ma Bibliotheque v2 - Details du livre</title>
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
        <nav>
            <a href="#" class="lien">Se connecter</a>
        </nav>
    </div>
</header>
<main class="container">
    <section class="text-center">
        <h2>${livre.id} - ${livre.titre} (${livre.type.nom})</h2>
        <h3>Auteur.ice : ${livre.auteur.prenom} ${livre.auteur.nom} (${livre.auteur.nationalite})</h3>
        <ul>
            <li>Date de parution : ${livre.dateDeParution}</li>
            <li>Catégorie : ${livre.categorie.nom}</li>
            <li>Disponibilité :
                <c:if test="${livre.estDisponible eq true}">
                    Disponible pour l'emprunt
                </c:if>
                <c:if test="${livre.estDisponible eq false}">
                    Emprunté
                </c:if>
            </li>
        </ul>
    </section>
</main>
</body>
</html>