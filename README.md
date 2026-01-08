# 📝 Gestionnaire de Tâches API

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

Ce projet est une API REST développée pour l'apprentissage du framework **Spring Boot**. L'objectif principal était de mettre en pratique les concepts fondamentaux du développement backend avec Java, notamment l'architecture en couches, la persistance des données et la gestion des relations entre entités.

> ⚠️ **Note importante :** Ce dépôt se concentre exclusivement sur la partie **Backend Java**. Le frontend (présent dans le dossier `1-3-tasks-fe`) est fourni à titre d'exemple pour tester l'API mais n'est pas le cœur de ce projet d'étude.

---

## 📸 Aperçu du Projet

### Interface Utilisateur (Frontend de test)
Voici à quoi ressemble l'interface permettant de tester l'API :
![Création d'une tache](images/creationTaches.png)

![Contenue d'une liste de tache](images/listeTaches.png)

![Liste des listes de taches](images/listListTaches.png)



### Modélisation des Données
Structure de la base de données PostgreSQL :
![Schéma BDD](images/diagramme-comp4.png)

---

## 🚀 Fonctionnalités implémentées

- 🔌 **Architecture RESTful** : Gestion complète des listes de tâches et des tâches (CRUD).
- 💾 **Spring Data JPA** : Persistance des données avec PostgreSQL.
- 🔄 **Mapping DTO** : Utilisation de Mappers pour séparer les entités de base de données des objets d'échange API.
- 🛡️ **Validation & Exception Handling** : Gestion centralisée des erreurs (*Global Exception Handler*).
- 🤖 **Automatisation** : Scripts de démarrage et d'arrêt simplifiés.

---

## 🛠️ Prérequis

Avant de lancer le projet, assure-toi d'avoir installé :
* **Java 21** ou supérieur
* **Docker Desktop** (indispensable pour la base de données PostgreSQL)
* **Node.js** (pour lancer le frontend si besoin)

---

## 🚦 Comment lancer le projet

Des scripts sont fournis à la racine pour faciliter le déploiement via Docker.

### 💻 Sur Windows

```batch
# Démarrer l'application et la BDD
./start.bat

# Arrêter l'application
./stop.bat