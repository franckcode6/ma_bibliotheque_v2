<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ajouter auteur</title>
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

            <c:if test="${sessionScope.lecteurConnecte eq null && sessionScope.admin eq null}">
            <a href="/connexion" class="lien">Se connecter</a>
            </c:if>
            <c:if test="${sessionScope.lecteurConnecte ne null}">
            <a href="/compte" class="lien">Mon compte</a>
            </c:if>
            <c:if test="${sessionScope.admin ne null}">
                <a href="/admin" class="lien">Administration</a>
                <a href="/admin/prets" class="lien ms-3">Enregistrer un nouveau pret</a>
            </c:if>
        </nav>
    </div>
</header>

<main class="container">
    <h2>Nouvel auteur</h2>
    <form method="post" class="mt-2">
        <div class="mb-3">
            <label for="nom" class="form-label">Nom</label>
            <input type="text" id="nom" name="NOM" class="form-control">
        </div>

        <div class="mb-3">
            <label for="prenom" class="form-label">Prenom</label>
            <input type="text" id="prenom" name="PRENOM" class="form-control">
        </div>

        <div class="mb-3">
            <label for="dateNaissance" class="form-label">Date de naissance</label>
            <input type="date" id="dateNaissance" name="DATE_NAISSANCE" class="form-control">
        </div>

        <div class="mb-3">
            <label for="nationalite" class="form-label">Nationalité</label>
            <input type="text" id="nationalite" name="NATIONALITE" class="form-control">
        </div>

        <input type="submit" value="Ajouter" class="btn btn-success me-2">
        <a href="/admin/auteurs" class="btn btn-secondary">Retour à la liste</a>
    </form>
</main>
</body>
</html>