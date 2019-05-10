<template>
  <div>
    <ul v-for='diplome in diplomes' :key=diplome.id>
      <li>{{ diplome.libelle }}</li>
      <button @click='selectDiplome(diplome)'> Voir les détails </button>
    </ul>
    <p> Nombre de diplome : {{ counter }}</p>
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
        diplomes: []
      }
    },
    methods: {
      selectDiplome (diplome){
        this.$emit('selected', diplome)
      }
    },
    computed: {
      counter (){
        return this.diplomes.length
      }
    },
    mounted(){
      axios
        .get('http://172.17.0.1:8080/allDiplome')
        .then(
          response => {
            this.diplomes = response.data
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
