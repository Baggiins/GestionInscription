<template>
  <div>
    <h1> Menu de l'espace d'inscription </h1>
    <ul>
      <li><router-link to="InscriptionPage"> Détails des inscriptions </router-link></li>
      <li><router-link to="InscriptionSaisie"> Saisie d'une inscription</router-link></li>
    </ul>
    <h2> Retour en arrière :</h2>
    <router-link to="/">BACK</router-link>
  </div>
</template>

<script>
  export default {
    name: "EspaceInscription"
  }
</script>

<style scoped>

</style>
