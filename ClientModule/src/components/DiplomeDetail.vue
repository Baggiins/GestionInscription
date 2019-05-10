<template>
  <div class="diplomeDetail">
    <h1>Détails du diplome</h1>
    <ul>
      <li>ID du diplome : {{ diplome.id }}</li>
      <li>Code du diplome : {{diplome.code}}</li>
      <li>Descriptif du diplome : {{diplome.descriptif}}</li>
      <li>Enseignant responsable du diplome : {{diplome.enseignantResponsable}}</li>
      <li>Libelle du diplome : {{diplome.libelle}}</li>
      <li>Type du diplome :
        <ul>
          <li>ID du type de diplome : {{diplome.typeDiplome.id}}</li>
          <li>Libelle du type de diplome : {{diplome.typeDiplome.libelle}}</li>
        </ul>
      </li>
    </ul>
    <h2> Retour au menu :</h2>
    <router-link to="/">MENU</router-link>
  </div>
</template>

<script>
  export default {
    props: ['diplome', 'typeDiplome']
  }
</script>

<style>
  div.diplomeDetail{
    display: inline-block;
    width: 40%;
  }
</style>
