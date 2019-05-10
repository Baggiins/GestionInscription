<template>
  <div>
    <h1> Menu principal </h1>
    <ul>
      <li><router-link to="EspaceGestionnaire"> Espace Gestionnaire </router-link></li>
      <li><router-link to="EspaceInscription"> Espace Inscription </router-link></li>
    </ul>
  </div>
</template>

<script>
    export default {
        name: "Navigation"
    }
</script>

<style scoped>

</style>
