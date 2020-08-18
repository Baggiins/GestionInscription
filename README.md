# Gestion des inscriptions à la fac:

## But du projet

L'objectif de ce projet était de pouvoir découvrir le framework VueJS, ainsi que la technologie Java Spring. La base de donnée est de type H2.

## Lancement des modules :

Pour lancer le serveur, se placer dans ce répertoire et exécuter la commande : gradle bootRun

Pour lancer le client, se placer dans le répertoire "ClientModule" et exécuter les commandes : 
* npm install
* npm run dev

_pour installer npm, il faut utiliser la commande suivante : apt install npm._

_Ces deux modules ont été réalisés avec Intellij IDEA Ultimate Edition (gratuit pour les étudiants)._

## Configuration d'utilisation :

Si vous lancez les deux modules sur la même machine, il faut changer la port de connexion du serveur ou du client:
	Pour le changer sur le serveur : src --> main --> application.properties : rajouter la ligne :
								server.port=8081
	pour le changer sur le client : ClientModule --> config --> index.js : changer la ligne :
```
module.exports ={
	dev: {
		...
		port: 8080
```
changer cette ligne avec : 
```
		port: 8081
```

### Serveur :
* 3 types de diplomes sont créer par défaut, pour les visualiser, faire un get (/allTypeDiplome).
* Pour gérer les opérations sur les entités, j'utilise CRUD Repository.
* La base de donnée est normalement embarquée avec le serveur.
* le serveur s'exécute sur le port par défaut.
### Client :
* Je n'ai pas eu le temps d'implémenter la gestion des unités d'enseignement.
* Si la taille des attributs des objets saisie dans le formulaire dépasse ceux préconisé par la base, une erreur SQL statement se produit sur le serveur, pas sur le client ...
* Si certains champs sont vide lors de la validation du formulaire, la requête (POST) ne s'effectue pas et on nous demande de remplir les champs vide.
* Si la requête s'effectue sans encombre, une alerte nous prévient.
