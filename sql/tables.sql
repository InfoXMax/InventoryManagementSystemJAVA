-- Base de données pour le système de gestion d'inventaire
CREATE DATABASE gestion_inventaire;
USE gestion_inventaire;

-- Table des produits
CREATE TABLE produits (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    categorie VARCHAR(50) NOT NULL,
    quantite INT NOT NULL,
    prix DECIMAL(10,2) NOT NULL
);