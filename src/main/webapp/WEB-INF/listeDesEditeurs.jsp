<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Editeurs</title>
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
            <a href="/pret" class="lien">Pret</a>
            <a href="#" class="lien ms-3">Se connecter</a>
        </nav>
    </div>
</header>
<main class="container">
    <h2>Liste des editeurs</h2>

    <table class="mx-auto table table-hover">
        <thead class="table-info">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${pageDEditeurs.content}" var="editeur">
            <tr>
                <th>${editeur.id}</th>
                <td>${editeur.nom}</td>
                <td>
                    <a href="/admin/editeur/supprimer?id=${editeur.id}" class="btn btn-danger">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h3 class="text-center mt-5">
        <c:if test="${!pageDEditeurs.first}">
            <a href="editeurs?page=0&sort=${sort}">&#x23EE;</a>
            <a href="editeurs?page=${pageDEditeurs.number-1}&sort=${sort}">&#x23EA;</a>
        </c:if>
        Page ${pageDEditeurs.getNumber()+1}
        <c:if test="${!pageDEditeurs.last}">
            <a href="editeurs?page=${pageDEditeurs.number+1}&sort=${sort}">&#x23E9;</a>
            <a href="editeurs?page=${pageDEditeurs.totalPages - 1}&sort=${sort}">&#x23ED;</a>
        </c:if>
    </h3>
</main>
</body>
</html>