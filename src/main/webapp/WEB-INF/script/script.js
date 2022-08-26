"use strict";

/*
DONNEES
 */
const filtres = document.querySelector("#filtres");
const boutonFiltre = document.querySelector("#bouton-filtre");

/*
FONCTIONS
 */
function afficherFiltres() {
    filtres.classList.toggle("cacher");
}

/*
CODE PRINCIPAL
 */
document.addEventListener("DOMContentLoaded", () => {
    boutonFiltre.addEventListener("click", afficherFiltres);
})
