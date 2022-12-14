<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Auteurs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <style>
        <%@include file="style/style.css"%>
    </style>
</head>

<body>
<header class="mb-5">
    <div class="container d-flex align-items-baseline justify-content-between">
        <h1><a href="/livres">Ma biblioth?que</a></h1>
        <nav class="d-flex justify-content-between">

            <c:if test="${sessionScope.lecteurConnecte eq null && sessionScope.admin eq null}">
                <a href="/connexion" class="lien">Se connecter</a>
            </c:if>
            <c:if test="${sessionScope.lecteurConnecte ne null}">
                <a href="/compte" class="lien">Mon compte</a>
            </c:if>
            <c:if test="${sessionScope.admin ne null}">
                <a href="/admin" class="lien">Administration</a>
                <a href="/admin/prets" class="lien ms-3">Pr?ts</a>
            </c:if>
            <c:if test="${sessionScope.lecteurConnecte ne null || sessionScope.admin ne null}">
                <a href="/deconnexion" class="lien ms-3">D?connexion</a>
            </c:if>
        </nav>
    </div>
</header>

<main class="container">
    <div class="d-flex justify-content-between align-items-center mb-3 pe-5">
        <h2>Liste des auteurs</h2>
        <a href="/admin/auteurs/ajouter" class="btn btn-success">Nouvel auteur</a>
    </div>

    <table class="mx-auto table table-hover">
        <thead class="table-info">
        <tr>
            <th>ID</th>
            <th>
                <a href="auteurs?sort=nom">Nom</a>
                <a href="auteurs?sort=nom,DESC">&#8595;</a>
            </th>
            <th>
                <a href="auteurs?sort=prenom">Prenom</a>
                <a href="auteurs?sort=prenom,DESC">&#8595;</a>
            </th>
            <th>
                <a href="auteurs?sort=dateDeNaissance">Date de naissance</a>
                <a href="auteurs?sort=dateDeNaissance,DESC">&#8595;</a>
            </th>
            <th>
                <a href="auteurs?sort=nationalite">Nationalit?</a>
                <a href="auteurs?sort=nationalite,DESC">&#8595;</a>
            </th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${pageDAuteurs.content}" var="auteur">
            <tr>
                <th>${auteur.id}</th>
                <td>${auteur.nom}</td>
                <td>${auteur.prenom}</td>
                <td>${auteur.dateDeNaissance}</td>
                <td>${auteur.nationalite}</td>
                <td>
                    <a href="/admin/auteur/supprimer?id=${auteur.id}" class="btn btn-danger">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h3 class="text-center mt-5">
        <c:if test="${!pageDAuteurs.first}">
            <a href="auteurs?page=0&sort=${sort}">&#x23EE;</a>
            <a href="auteurs?page=${pageDAuteurs.number-1}&sort=${sort}">&#x23EA;</a>
        </c:if>
        Page ${pageDAuteurs.getNumber()+1}
        <c:if test="${!pageDAuteurs.last}">
            <a href="auteurs?page=${pageDAuteurs.number+1}&sort=${sort}">&#x23E9;</a>
            <a href="auteurs?page=${pageDAuteurs.totalPages - 1}&sort=${sort}">&#x23ED;</a>
        </c:if>
    </h3>
</main>

<footer class="text-center py-3">
    <a href="https://github.com/franckcode6">2022 @Franck</a>
</footer>
</body>
</html>