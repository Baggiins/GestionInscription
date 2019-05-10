<template>
  <form
    id="app"
    @submit="checkForm"
  >
    <p v-if="errors.length"><b>Veuillez remplir les champs suivant :</b>
    <ul>
    <li v-for="error in errors">{{ error }}</li>
  </ul>
  <div class="InscriptionSaisie">
    <h1>Saisie d'une nouvelle inscription :</h1>
    <label>ID (entier): <input type="text" v-model="inscription.id"/></label><br>
    <label>Code postal (6 caractere max): <input type="text" v-model="inscription.codePostal"/></label><br>
    <label>Commune : <input type="text" v-model="inscription.commune"/></label><br>
    <label>Numero et voie : <input type="text" v-model="inscription.numeroEtVoie"/></label><br>
    <label>Pays : <input type="text" v-model="inscription.pays"/></label><br>
    <label>Civilité (3 caractere max): <input type="text" v-model="inscription.civilite"/></label><br>
    <label>Date de naissance (XXXX-XX-XX): <input type="text" v-model="inscription.dateDeNaissance"/></label><br>
    <label>Nom : <input type="text" v-model="inscription.nom"/></label><br>
    <label>Prenom : <input type="text" v-model="inscription.prenom"/></label><br>
    <label>Reference dossier (6 caractere max): <input type="text" v-model="inscription.referenceDossier"/></label><br>
    <br>
    <select v-model="selected" >
      <option value="">Choisissez</option>
      <option v-for='diplome in diplomes' :value="diplome">{{diplome.libelle}}</option>
    </select>
    <span>Sélectionné : {{ selected.libelle }}</span>
    <button @click='validInscription(inscription, selected)'> Validation </button><br>
    <h2> Navigation :</h2>
    <router-link to="/">MENU</router-link>
    <router-link to="/EspaceInscription">Espace d'inscription</router-link>
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
        selected : [],
        inscriptions:[],
        diplomes:[],
        errors: [],
        inscription:[]
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
          })
    },
    methods: {
      checkForm: function (e) {
        if (this.inscription.id && this.inscription.codePostal &&
        this.inscription.commune && this.inscription.numeroEtVoie
        && this.inscription.pays && this.inscription.civilite
        && this.inscription.dateDeNaissance && this.inscription.nom
         && this.inscription.prenom && this.inscription.referenceDossier
        && this.selected /*&& this.inscription.referenceDossier.length < 7 &&
        this.inscription.dateDeNaissance.length < 9 && this.inscription.civilite < 4*/) {
          return true;
        }
        this.errors = [];
        /*if (this.inscription.referenceDossier.length > 6) {
          this.errors.push('reference dossier trop long.');
        }
        if (this.inscription.dateDeNaissance.length > 8) {
          this.errors.push('mauvait format de date de naissance');
        }
        if (this.inscription.civilite > 3) {
          this.errors.push('civilite trop long');
        }
        */
        if (!this.inscription.id) {
          this.errors.push('Id requis.');
        }
        if (!this.inscription.codePostal) {
          this.errors.push('code postal requis.');
        }
        if (!this.inscription.commune) {
          this.errors.push('commune requis.');
        }
        if (!this.inscription.pays) {
          this.errors.push('pays requis.');
        }
        if (!this.inscription.civilite) {
          this.errors.push('civilite requis.');
        }
        if (!this.inscription.dateDeNaissance) {
          this.errors.push('date de naissance requis.');
        }
        if (!this.inscription.nom) {
          this.errors.push('nom requis.');
        }
        if (!this.inscription.prenom) {
          this.errors.push('prenom requis.');
        }
        if (!this.inscription.referenceDossier) {
          this.errors.push('reference du dossier requis.');
        }
        if (!this.inscription.numeroEtVoie) {
          this.errors.push('Numero et voie requis.');
        }
        if (!this.selected) {
          this.errors.push('selection du diplome requis.');
        }

        e.preventDefault();
      },
      validInscription (inscription, selected) {
        if(this.checkForm()){
          axios.post('http://172.17.0.1:8080/addInscription', {
            "id": inscription.id,
            "codePostal": inscription.codePostal,
            "commune": inscription.commune,
            "numeroEtVoie": inscription.numeroEtVoie,
            "pays": inscription.pays,
            "civilite": inscription.civilite,
            "dateDeNaissance": inscription.dateDeNaissance,
            "nom": inscription.nom,
            "prenom": inscription.prenom,
            "referenceDossier": inscription.referenceDossier,
            "diplomeByDiplomeId": {
              "id": selected.id
            }
          }).then(function (response) {
            console.log(response);
            alert('Inscription valide !');
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
