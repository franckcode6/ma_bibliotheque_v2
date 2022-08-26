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
    <div class="container d-flex align-items-baseline justify-content-between">
        <h1><a href="/livres">Ma bibliothèque</a></h1>
        <nav class="d-flex justify-content-between">

            <c:if test="${sessionScope.lecteurConnecte eq null && sessionScope.admin eq null}">
                <a href="/connexion" class="lien">Se connecter</a>
            </c:if>
            <c:if test="${sessionScope.lecteurConnecte ne null}">
                <a href="/compte" class="lien">
                    <strong>${sessionScope.lecteurConnecte.prenom} ${sessionScope.lecteurConnecte.nom}</strong>
                </a>
            </c:if>
            <c:if test="${sessionScope.admin ne null}">
                <a href="/admin" class="lien">Administration</a>
                <a href="/admin/prets" class="lien ms-3">Prêts</a>
            </c:if>
            <c:if test="${sessionScope.lecteurConnecte ne null || sessionScope.admin ne null}">
                <a href="/deconnexion" class="lien ms-3">Déconnexion</a>
            </c:if>
        </nav>
    </div>
</header>

<main class="container">
    <div class="d-flex justify-content-between align-items-center mb-3 pe-5">
        <h2>Liste des livres</h2>
        <a href="/livres" class="btn btn-secondary">Retour à la liste</a>
    </div>

    <table class="mx-auto table table-hover">
        <thead class="table-info">
        <tr>
            <th>ID</th>
            <th>
                <a href="livres?sort=titre">Titre</a>
                <a href="livres?sort=titre,DESC">&#8595;</a>
            </th>
            <th>
                <a href="livres?sort=auteur.nom">Auteur</a>
                <a href="livres?sort=auteur.nom,DESC">&#8595;</a>
            </th>
            <th>
                <a href="livres?sort=editeur.nom">Editeur</a>
                <a href="livres?sort=editeur.nom,DESC">&#8595;</a>
            </th>
            <th>Année</th>
            <th>
                <a href="livres?sort=categorie.nom">Catégorie</a>
                <a href="livres?sort=categorie.nom,DESC">&#8595;</a>
            </th>
            <th>
                <a href="livres?sort=type.nom">Type</a>
                <a href="livres?sort=type.nom,DESC">&#8595;</a>
            </th>
            <th>Stock</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${livres}" var="livre">
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
</main>

<footer class="text-center py-3">
    <a href="https://github.com/franckcode6">2022 @Franck</a>
</footer>
</body>
</html>