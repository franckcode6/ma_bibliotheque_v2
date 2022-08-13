<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <style>
        <%@include file="style/style.css"%>
    </style>
</head>

<body>
<header class="mb-5">
    <div class="container d-flex align-items-center justify-content-between">
        <h1><a href="/livres">Ma biblioth�que</a></h1>
        <nav class="d-flex justify-content-between">
            <a href="/pret" class="lien">Pret</a>
            <a href="#" class="lien ms-3">Se connecter</a>
        </nav>
    </div>
</header>

<main class="container">
    <section class="row">
        <div class="col-md-4 d-flex flex-column align-items-center justify-content-center">
            <h2>${lecteur.id} - ${lecteur.nom} ${lecteur.prenom}</h2>
            <ul>
                <li>Email : ${lecteur.email}</li>
                <li>N� le : ${lecteur.dateDeNaissance}</li>
            </ul>
            <a href="/pret/ajout/lecteur?id=${lecteur.id}">
                <button class="btn btn-secondary mt-2">Enregistrer un retour</button>
            </a>
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

    <section class="my-5 row">
        <div class="col-md-4"></div>
        
        <div class="col-md-8">
            <h2>Nouveau pret</h2>
            <form method="post" class="mt-2">
                <div class="mb-3">
                    <label for="livre1Id" class="form-label">ID du livre 1</label>
                    <input type="number" id="livre1Id" name="LIVRE1_ID" class="form-control">
                </div>

                <div class="mb-3">
                    <label for="livre2Id" class="form-label">ID du livre 2 (optionnel)</label>
                    <input type="number" id="livre2Id" name="LIVRE2_ID" class="form-control">
                </div>

                <div class="mb-3">
                    <label for="livre3Id" class="form-label">ID du livre 3 (optionnel)</label>
                    <input type="number" id="livre3Id" name="LIVRE3_ID" class="form-control">
                </div>

                <div class="mb-3">
                    <label for="livre4Id" class="form-label">ID du livre 4 (optionnel)</label>
                    <input type="number" id="livre4Id" name="LIVRE4_ID" class="form-control">
                </div>

                <input type="submit" value="Ajouter" class="btn btn-success">
            </form>
        </div>
    </section>
</main>
</body>
</html>