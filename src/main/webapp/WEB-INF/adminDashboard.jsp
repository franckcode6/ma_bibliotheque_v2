<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Administration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <style>
        <%@include file="style/style.css"%>
    </style>
</head>

<body>
<header class="mb-3">
    <div class="container d-flex align-items-baseline justify-content-between">
        <h1><a href="/livres">Ma bibliothèque</a></h1>
        <nav class="d-flex justify-content-between">
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

<main class="container text-center">
    <section class="mb-3">
        <h2>Prêts</h2>
        <a href="/admin/prets" class="btn btn-lg btn-outline-info col-md-6">Enregistrer un prêt</a>
    </section>

    <section class="mb-3">
        <h2>Lecteurs</h2>
        <a href="/admin/lecteurs" class="btn btn-lg btn-outline-dark col-md-6 mb-2">Liste des lecteurs</a>
        <br>
        <a href="/admin/lecteurs/ajouter" class="btn btn-lg btn-outline-success col-md-6">Ajouter un lecteur</a>
    </section>

    <section class="mb-3">
        <h2>Auteurs</h2>
        <a href="/admin/auteurs" class="btn btn-lg btn-outline-dark col-md-6 mb-2">Liste des auteurs</a>
        <br>
        <a href="/admin/auteurs/ajouter" class="btn btn-lg btn-outline-success col-md-6">Ajouter un auteur</a>
    </section>

    <section class="mb-3">
        <h2>Editeurs</h2>
        <a href="/admin/editeurs" class="btn btn-lg btn-outline-dark col-md-6 mb-2">Liste des editeurs</a>
        <br>
        <a href="/admin/editeurs/ajouter" class="btn btn-lg btn-outline-success col-md-6">Ajouter un editeur</a>
    </section>

    <section class="mb-5">
        <h2>Livres</h2>
        <a href="/livres" class="btn btn-lg btn-outline-dark col-md-6 mb-2">Liste des livres</a>
        <br>
        <a href="/admin/livres/ajouter" class="btn btn-lg btn-outline-success col-md-6">Ajouter un livre</a>
    </section>
</main>

<footer class="text-center py-3">
    <a href="https://github.com/franckcode6">2022 @Franck</a>
</footer>
</body>
</html>