<template>
  <div class="page">
    <div class="content">
      <DiplomeList v-on:selected='setSelected($event)' />
      <DiplomeDetails :diplome='selectedDiplome' />
    </div>
    <h2> Retour à l'espace de gestion :</h2>
    <router-link to="/EspaceGestionnaire">Espace de gestion</router-link>
  </div>
</template>

<script>
  import DiplomeList from '../components/DiplomeList'
  import DiplomeDetails from '../components/DiplomeDetail'

  export default {
    data() {
      return {
        selectedDiplome: {}
      }
    },
    components: {DiplomeList, DiplomeDetails},
    methods: {
      setSelected(_selectedDiplome) {
        this.selectedDiplome = _selectedDiplome
      }
    }
  }
</script>
<style scoped>
</style>
