<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ajouter livre</title>
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
    <h2>Nouveau livre</h2>
    <form method="post" class="mt-2">
        <div class="mb-3">
            <label for="titre" class="form-label">Titre</label>
            <input type="text" id="titre" name="TITRE" class="form-control">
        </div>

        <div class="mb-3">
            <label for="isbn" class="form-label">ISBN</label>
            <input type="text" id="isbn" name="ISBN" class="form-control">
        </div>

        <div class="mb-3">
            <label for="dateParution" class="form-label">Date de parution</label>
            <input type="date" id="dateParution" name="DATE_PARUTION" class="form-control">
        </div>

        <div class="mb-3">
            <label for="auteur" class="form-label">Auteur</label>
            <select id="auteur" name="AUTEUR_ID" class="form-select">
                <option>Selectionnez un auteur</option>
                <c:forEach items="${auteurs}" var="auteur">
                    <option value="${auteur.id}">${auteur.nom} ${auteur.prenom}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="editeur" class="form-label">Editeur</label>
            <select id="editeur" name="EDITEUR_ID" class="form-select">
                <option>Selectionnez un editeur</option>
                <c:forEach items="${editeurs}" var="editeur">
                    <option value="${editeur.id}">${editeur.nom}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="categorie" class="form-label">Categorie</label>
            <select id="categorie" name="CATEGORIE_ID" class="form-select">
                <option>Selectionnez une categorie</option>
                <c:forEach items="${categories}" var="categorie">
                    <option value="${categorie.id}">${categorie.nom}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label for="type" class="form-label">Type</label>
            <select id="type" name="TYPE_ID" class="form-select">
                <option>Selectionnez un type</option>
                <c:forEach items="${types}" var="type">
                    <option value="${type.id}">${type.nom}</option>
                </c:forEach>
            </select>
        </div>

        <input type="submit" value="Ajouter" class="btn btn-success me-2">
        <a href="/livres" class="btn btn-secondary">Retour ? la liste</a>
    </form>
</main>

<footer class="text-center py-3">
    <a href="https://github.com/franckcode6">2022 @Franck</a>
</footer>
</body>
</html>