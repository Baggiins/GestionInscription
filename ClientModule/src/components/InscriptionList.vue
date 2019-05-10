<template>
  <div>
    <ul v-for='inscription in inscriptions' :key=inscription.id>
      <li>{{ inscription.nom }} , {{inscription.prenom}}</li>
      <button @click='selectInscription(inscription)'> Voir les détails </button>
    </ul>
    <p> Nombre d'inscriptions : {{ counter }}</p>
    <h2> Retour au menu :</h2>
    <router-link to="/">MENU</router-link>
  </div>
</template>

<script>
  import axios from 'axios'
  import Vue from 'vue'
  import VueResource from 'vue-resource'
  Vue.use(VueResource)

  export default {
    data (){
      return {
        inscriptions: []
      }
    },
    methods: {
      selectInscription (inscription){
        this.$emit('selected', inscription)
      }
    },
    computed: {
      counter (){
        return this.inscriptions.length
      }
    },
    mounted(){
      axios
        .get('http://172.17.0.1:8080/allInscription')
        .then(
          response => {
            this.inscriptions = response.data
          },
          response => {
            console.log('erreur de connection', response)
          }
        )
    }
  }
</script>

<style scoped>

</style>
