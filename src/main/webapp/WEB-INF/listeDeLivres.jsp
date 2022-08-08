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
        <h1>Ma biblioth�que</h1>
        <nav>
            <a href="#">Se connecter</a>
        </nav>
    </div>
</header>
<main class="container">
    <h2>Liste des livres</h2>

    <table class="mx-auto table table-hover">
        <thead class="table-info">
        <tr>
            <th>ID</th>
            <th>Titre</th>
            <th>Auteur</th>
            <th>Editeur</th>
            <th>Ann�e</th>
            <th>Cat�gorie</th>
            <th>Type</th>
            <th>Disponibilit�</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <jsp:useBean id="livres" scope="request" type="java.util.List"/>
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
                    <c:if test="${livre.estDisponible eq false}">Emprunt�</c:if>
                </th>
                <td>
                    <button class="btn btn-primary">D�tails</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>