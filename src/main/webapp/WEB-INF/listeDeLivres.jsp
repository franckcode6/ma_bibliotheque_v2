<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ma Bibliotheque v2</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <style>
        <%@include file="style/style.css"%>
    </style>
</head>

<body>
<header class="mb-5">
    <div class="container d-flex align-items-center justify-content-between">
        <h1><a href="/livres">Ma bibliothèque</a></h1>
        <nav class="d-flex justify-content-between">
            <a href="/admin/prets" class="lien">Pret</a>
            <a href="/connexion" class="lien ms-3">Se connecter</a>
        </nav>
    </div>
</header>

<main class="container">
    <div class="d-flex justify-content-between align-items-center mb-3 pe-5">
        <h2>Liste des livres</h2>
        <a href="/admin/livres/ajouter" class="btn btn-success">Nouveau livre</a>
    </div>

    <table class="mx-auto table table-hover">
        <thead class="table-info">
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Editeur</th>
            <th>Année</th>
            <th>Catégorie</th>
            <th>Type</th>
            <th>Disponibilité</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${pageDeLivres.content}" var="livre">
            <tr>
                <th>${livre.id}</th>
                <td>${livre.titre}</td>
                <td>${livre.auteur.nom} ${livre.auteur.prenom}</td>
                <td>${livre.editeur.nom}</td>
                <td>${livre.dateDeParution}</td>
                <td>${livre.categorie.nom}</td>
                <td>${livre.type.nom}</td>
                <th><c:if test="${livre.estDisponible eq true}">Disponible</c:if>
                    <c:if test="${livre.estDisponible eq false}">Emprunté</c:if>
                </th>
                <td>
                    <a href="livres/details?id=${livre.id}">
                        <button class="btn btn-primary">Détails</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h3 class="text-center mt-5">
        <c:if test="${!pageDeLivres.first}">
            <a href="livres?page=0&sort=${sort}">&#x23EE;</a>
            <a href="livres?page=${pageDeLivres.number-1}&sort=${sort}">&#x23EA;</a>
        </c:if>
        Page ${pageDeLivres.getNumber()+1}
        <c:if test="${!pageDeLivres.last}">
            <a href="livres?page=${pageDeLivres.number+1}&sort=${sort}">&#x23E9;</a>
            <a href="livres?page=${pageDeLivres.totalPages - 1}&sort=${sort}">&#x23ED;</a>
        </c:if>
    </h3>
</main>
</body>
</html>