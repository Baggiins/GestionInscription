<template>
  <div class="inscriptionDetail">
    <h1>Détails de l'inscription</h1>
    <ul>
      <li>ID de l'inscription : {{inscription.id}}</li>
      <li>Code postal : {{inscription.codePostal}}</li>
      <li>Commune : {{inscription.commune}}</li>
      <li>Numéro et voie : {{inscription.numeroEtVoie}}</li>
      <li>Pays : {{inscription.pays}}</li>
      <li>Civilité : {{inscription.civilite}}</li>
      <li>Date de naissance : {{inscription.dateDeNaissance}}</li>
      <li>Nom : {{inscription.nom}}</li>
      <li>Prenom : {{inscription.prenom}}</li>
      <li>Reference dossier : {{inscription.referenceDossier}}</li>
      <li>Diplome :
        <ul>
          <li>ID du diplome : {{inscription.diplomeByDiplomeId.id}}</li>
          <li>Libelle du diplome : {{inscription.diplomeByDiplomeId.libelle}}</li>
        </ul>
      </li>
    </ul>
    <h2> Retour au menu :</h2>
    <router-link to="/">MENU</router-link>
  </div>
</template>

<script>
  export default {
    props: ['inscription', 'diplomeByDiplomeId']
  }
</script>

<style>
  div.inscriptionDetail{
    display: inline-block;
    width: 40%;
  }
</style>
