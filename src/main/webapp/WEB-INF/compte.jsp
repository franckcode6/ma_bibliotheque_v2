<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Mon compte</title>
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
            <c:if test="${sessionScope.lecteurConnecte ne null}">
                <a href="/compte"
                   class="lien"><strong>${sessionScope.lecteurConnecte.prenom} ${sessionScope.lecteurConnecte.nom}</strong></a>
            </c:if>
            <c:if test="${sessionScope.lecteurConnecte ne null || sessionScope.admin ne null}">
                <a href="/deconnexion" class="lien ms-3">Déconnexion</a>
            </c:if>
        </nav>
    </div>
</header>

<main class="container">
    <section class="row">
        <div class="col-md-4 d-flex flex-column align-items-center justify-content-center">
            <h2>${sessionScope.lecteurConnecte.id}
                - ${sessionScope.lecteurConnecte.nom} ${sessionScope.lecteurConnecte.prenom}</h2>
            <ul>
                <li>Email : ${sessionScope.lecteurConnecte.email}</li>
                <li>Né le : ${sessionScope.lecteurConnecte.dateDeNaissance}</li>
            </ul>
        </div>

        <div class="col-md-8">
            <h2>Prets en cours</h2>
            <table class="mt-2 table">
                <thead class="table table-info">
                <tr>
                    <th>ID</th>
                    <th>Livre</th>
                    <th>Date de pret</th>
                    <th>Date de retour</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${prets}" var="pret">
                    <tr>
                        <th>${pret.livre.id}</th>
                        <td>${pret.livre.titre}</td>
                        <td>${pret.dateDebut}</td>
                        <td>${pret.dateFin}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</main>

<footer class="text-center py-3">
    <a href="https://github.com/franckcode6">2022 @Franck</a>
</footer>
</body>
</html>