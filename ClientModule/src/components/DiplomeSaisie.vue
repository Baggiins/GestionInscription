<template>
  <form
    id="app"
    @submit="checkForm"
  >
    <p v-if="errors.length"><b>Veuillez remplir les champs suivant :</b><ul><li v-for="error in errors">{{ error }}</li></ul>
    <div class="DiplomeSaisie">
      <h1>Saisie d'un nouveau diplome :</h1>
      <label>ID (un entier): <input type="text" v-model="diplome.id"/></label><br>
      <label>Code (6 caractere max): <input type="text" v-model="diplome.code"/></label><br>
      <label>Descriptif : <input type="text" v-model="diplome.descriptif"/></label><br>
      <label>Enseignant responsable : <input type="text" v-model="diplome.enseignantResponsable"/></label><br>
      <label>Libelle : <input type="text" v-model="diplome.libelle"/></label>
      <br>
      <select v-model="selected" >
        <option value="">Choisir un type de diplome</option>
        <option v-for='typediplome in typediplomes' :value="typediplome">{{typediplome.libelle}}</option>
      </select>
      <span>Sélectionné : {{ selected.libelle }}</span>
      <button @click='validDiplome(diplome, selected)'> Validation </button><br>
      <h2>Rappel de la saisie : </h2>
      <ul>
        <li>ID : {{diplome.id}}</li>
        <li>Code : {{diplome.code}}</li>
        <li>Descriptif : {{diplome.descriptif}}</li>
        <li>Enseignant responsable : {{diplome.enseignantResponsable}}</li>
        <li>Libelle : {{diplome.libelle}}</li>
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
            diplome: [],
            typediplomes: [],
            selected : [],
            errors: [],
            typediplome:[]
          }
        },
      mounted(){
          axios
            .get('http://172.17.0.1:8080/allTypeDiplome')
            .then(
              response => {
                this.typediplomes = response.data
              },
              response => {
                console.log('erreur de connection', response)
              })
      },
      methods: {
        checkForm: function (e) {
          if (this.diplome.id && this.diplome.libelle
          && this.diplome.code && this.diplome.descriptif
          && this.diplome.enseignantResponsable && this.selected) {
            return true;
          }
          this.errors = [];
          if (!this.diplome.id) {
            this.errors.push('Id requis.');
          }
          if (!this.diplome.libelle) {
            this.errors.push('libellé requis.');
          }
          if (!this.diplome.code) {
            this.errors.push('code requis.');
          }
          if (!this.diplome.descriptif) {
            this.errors.push('descriptif requis.');
          }
          if (!this.diplome.enseignantResponsable) {
            this.errors.push('Enseignant responsable requis.');
          }
          if (!this.diplome.selected) {
            this.errors.push('type de diplome requis.');
          }

          e.preventDefault();
        },
          validDiplome (diplome, selected) {
          if(this.checkForm()) {
            axios.post('http://172.17.0.1:8080/addDiplome', {
              "id": diplome.id,
              "code": diplome.code,
              "descriptif": diplome.descriptif,
              "enseignantResponsable": diplome.enseignantResponsable,
              "libelle": diplome.libelle,
              "typeDiplome": {
                "id": selected.id
              }
            }).then(function (response) {
              console.log(response);
              alert('nouveau diplome créé !');
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
