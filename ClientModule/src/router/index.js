import Vue from 'vue'
import Router from 'vue-router'
import DiplomePage from "../pages/DiplomePage";
import DiplomeSaisie from "../components/DiplomeSaisie";
import EspaceGestionnaire from "../components/EspaceGestionnaire";
import EspaceInscription from "../components/EspaceInscription";
import InscriptionPage from "../pages/InscriptionPage";
import InscriptionSaisie from "../components/InscriptionSaisie";
import TypeDiplomeSaisie from "../components/TypeDiplomeSaisie"

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'navigation',
      component: require('../components/Navigation').default
    },
    {
      path: '/Diplomepage',
      name: 'Diplome',
      component: DiplomePage
    },
    {
      path: '/Diplomesaisie',
      name: 'DiplomeSaisie',
      component: DiplomeSaisie
    },
    {
      path: '/EspaceGestionnaire',
      name: 'EspaceGestionnaire,',
      component: EspaceGestionnaire
    },
    {
      path: '/EspaceInscription',
      name: 'EspaceInscription',
      component: EspaceInscription
    },
    {
      path: '/InscriptionSaisie',
      name: 'InscriptionSaisie',
      component: InscriptionSaisie
    },
    {
      path: '/TypeDiplomeSaisie',
      name: 'TypeDiplomeSaisie',
      component: TypeDiplomeSaisie
    },
    {
      path: '/InscriptionPage',
      name: 'Inscription',
      component: InscriptionPage
    }
  ]
})
