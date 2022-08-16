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
    <div class="container d-flex align-items-baseline justify-content-between">
        <h1><a href="/livres">Ma bibliothèque</a></h1>
        <nav class="d-flex justify-content-between">

            <c:if test="${sessionScope.lecteurConnecte eq null && sessionScope.admin eq null}">
                <a href="/connexion" class="lien">Se connecter</a>
            </c:if>
            <c:if test="${sessionScope.lecteurConnecte ne null}">
                <a href="/compte"
                   class="lien"><strong>${sessionScope.lecteurConnecte.prenom} ${sessionScope.lecteurConnecte.nom}</strong></a>
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
    <section class="text-center cadre">
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
            <c:if test="${sessionScope.admin ne null}">
                <li class="mt-3">
                    <a href="/admin/livres/supprimer?id=${livre.id}" class="btn btn-danger">Supprimer</a>
                </li>
            </c:if>
        </ul>
    </section>
</main>

<footer class="text-center py-3">
    <a href="https://github.com/franckcode6">2022 @Franck</a>
</footer>
</body>
</html>