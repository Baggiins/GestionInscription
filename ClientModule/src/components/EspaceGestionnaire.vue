<template>
  <div>
    <h1> Menu de l'espace de gestion </h1>
    <ul>
      <li><router-link to="DiplomePage"> Tableau de bord </router-link></li>
      <li><router-link to="DiplomeSaisie"> Saisie d'un diplome</router-link></li>
      <li><router-link to="TypeDiplomeSaisie"> Saisir un nouveau type de diplome </router-link></li>
    </ul>
    <h2> Retour en arrière :</h2>
    <router-link to="/">BACK</router-link>
  </div>
</template>

<script>
    export default {
        name: "EspaceGestionnaire"
    }
</script>

<style scoped>

</style>
