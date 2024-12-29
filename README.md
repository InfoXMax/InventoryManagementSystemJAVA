# Système de Gestion d'Inventaire

## Explication Rapide du Projet
Le **Système de Gestion d'Inventaire** est une application Java client-serveur conçue pour gérer les produits d'une base de données.  
Elle permet d'ajouter, modifier, supprimer et rechercher des produits en utilisant une architecture RMI et une base de données MySQL.

---

## Instructions pour Exécuter le Code

### Pré-requis
- **Java Development Kit (JDK)** version 17 ou supérieure.  
- **MySQL** version 8.0 ou supérieure (XAMPP pour simplifier).  

### Étapes d'Installation
1. **Configuration**
   - Utilisez Eclipse pour ouvrir le projet.  
   - Ajoutez le fichier JDBC `mysql-connector-j-9.1.0.jar` dans les bibliothèques du projet.  
   - Installez et lancez XAMPP pour MySQL.  
   - Importez les fichiers `tables.sql` et `insert.sql` pour créer automatiquement la base de données et ajouter des produits.

2. **Exécution**
   - **Serveur**  
     Exécutez le fichier `RMIServer.java` pour démarrer le serveur.  
   - **Client**  
     Exécutez le fichier `InventaireClient.java` pour lancer le client.

---

### Utilisation
- Sélectionnez une option dans le menu pour effectuer une opération (ajout, modification, suppression ou recherche).  
