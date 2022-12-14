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
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
              crossorigin="anonymous">
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
                        <a href="/compte"
                           class="lien"><strong>${sessionScope.lecteurConnecte.prenom} ${sessionScope.lecteurConnecte.nom}</strong></a>
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
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h2>Liste des livres</h2>
                <div>
                    <c:if test="${sessionScope.admin ne null}">
                        <a href="/admin/livres/ajouter" class="btn btn-success">Nouveau livre</a>
                    </c:if>
                    <button id="bouton-filtre" class="ms-2 btn btn-secondary">Filtrer</button>
                </div>
            </div>

            <section id="filtres" class="my-3 pb-4 row cacher">
                <form action="/livres/filtrer" method="get" class="mb-2">
                    <label for="titre" class="me-2 form-label">
                        <strong>Titre</strong>
                    </label>
                    <div class="d-flex">
                        <input type="text" id="titre" name="titre" class="form-control">
                        <input type="submit" value="Filtrer" class="btn btn-sm btn-success ms-1">
                    </div>
                </form>

                <form action="/livres/filtrer" method="get" class="mb-2 col-md-6">
                    <label for="auteur" class="me-2 form-label">
                        <strong>Auteur</strong>
                    </label>
                    <div class="d-flex">
                        <input type="text" id="auteur" name="auteur" class="form-control">
                        <input type="submit" value="Filtrer" class="btn btn-sm btn-success ms-1">
                    </div>
                </form>

                <form action="/livres/filtrer" method="get" class="mb-2 col-md-6">
                    <label for="editeur" class="me-2 form-label">
                        <strong>Editeur</strong>
                    </label>
                    <div class="d-flex">
                        <input type="text" id="editeur" name="auteur" class="form-control">
                        <input type="submit" value="Filtrer" class="btn btn-sm btn-success ms-1">
                    </div>
                </form>

                <form action="/livres/filtrer" method="get" class="mb-2 col-md-6">
                    <label for="categorie" class="me-2 form-label">
                        <strong>Categorie</strong>
                    </label>
                    <div class="d-flex">
                        <select name="categorie" id="categorie" class="form-select">
                            <option value="">S?lectionner une cat?gorie</option>
                            <c:forEach items="${categories}" var="categorie">
                                <option value="${categorie.nom}">${categorie.nom}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="Filtrer" class="btn btn-sm btn-success ms-1">
                    </div>
                </form>

                <form action="/livres/filtrer" method="get" class="mb-2 col-md-6">
                    <label for="type" class="me-2 form-label">
                        <strong>Type</strong>
                    </label>
                    <div class="d-flex">
                        <select name="type" id="type" class="form-select">
                            <option value="">S?lectionner un type</option>
                            <c:forEach items="${types}" var="type">
                                <option value="${type.nom}">${type.nom}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="Filtrer" class="btn btn-sm btn-success ms-1">
                    </div>
                </form>
            </section>

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
                        <th>Ann?e</th>
                        <th>
                            <a href="livres?sort=categorie.nom">Cat?gorie</a>
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
                                <c:if test="${livre.estDisponible eq false}">Emprunt?</c:if>
                            </th>
                            <td>
                                <a href="livres/details?id=${livre.id}">
                                    <button class="btn btn-primary">D?tails</button>
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

        <footer class="text-center py-3">
            <a href="https://github.com/franckcode6">2022 @Franck</a>
        </footer>

        <script>
            <%@include file="script/script.js"%>
        </script>
    </body>
</html>