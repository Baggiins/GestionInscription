<template>
  <form
    id="app"
    @submit="checkForm"
  >
    <p v-if="errors.length"><b>Veuillez remplir les champs suivant :</b><ul><li v-for="error in errors">{{ error }}</li></ul>
  <div class="TypeDiplomeSaisie">
    <h1>Saisie d'un nouveau type de diplome :</h1>
    <label>ID (un entier): <input type="text" v-model="typeDiplome.id"/></label><br>
    <label>Libelle (20 caractere maximum): <input type="text" v-model="typeDiplome.libelle"/></label><br>
    <button @click='validTypeDiplome(typeDiplome)'> Validation </button><br>
    <h2>Rappel de la saisie : </h2>
    <ul>
      <li>ID : {{typeDiplome.id}}</li>
      <li>libelle : {{typeDiplome.libelle}}</li>
    </ul>
    <h2> Navigation :</h2>
    <router-link to="/">MENU</router-link>
    <router-link to="/EspaceGestionnaire">Espace de gestion</router-link>
  </div>
  </form>
</template>

<script>
  import axios from 'axios'
  import Vue from 'vue'
  import VueResource from 'vue-resource'
  Vue.use(VueResource)
  export default {
    data(){

      return{
        typediplomes: [],
        errors: [],
        typeDiplome: []
      }
    },
    methods: {
      checkForm: function (e) {
        if (this.typeDiplome.id && this.typeDiplome.libelle
        /*&& this.typeDiplome.libelle.length < 21*/) {
          return true;
        }
        this.errors = [];
        /*if (this.typeDiplome.libelle.length > 20){
          this.errors.push('libelle trop long');
        }*/
        if (!this.typeDiplome.id) {
          this.errors.push('Id requis.');
        }
        if (!this.typeDiplome.libelle) {
          this.errors.push('libellé requis.');
        }

        e.preventDefault();
      },
      validTypeDiplome (typeDiplome) {
        if(this.checkForm()){
          axios.post('http://172.17.0.1:8080/addTypeDiplome', {
            "id": typeDiplome.id,
            "libelle": typeDiplome.libelle
          }).then(function (response) {
            console.log(response);
            alert('nouveau type de diplome introduit !');
          }).catch(function (error) {
            console.log(error)
          });
        }
      }
    }
  }
</script>

<style scoped>

</style>
