<template>
  <div class="page">
    <div class="content">
      <InscriptionList v-on:selected='setSelected($event)' />
      <InscriptionDetails :inscription='selectedInscription' />
    </div>
    <h2> Retour à l'espace d'inscription :</h2>
    <router-link to="/EspaceInscription">Espace d'inscription</router-link>
  </div>
</template>

<script>
  import InscriptionList from '../components/InscriptionList'
  import InscriptionDetails from '../components/InscriptionDetail'

  export default {
    data() {
      return {
        selectedInscription: {}
      }
    },
    components: {InscriptionList, InscriptionDetails},
    methods: {
      setSelected(_selectedInscription) {
        this.selectedInscription = _selectedInscription
      }
    }
  }
</script>
<style scoped>
</style>
