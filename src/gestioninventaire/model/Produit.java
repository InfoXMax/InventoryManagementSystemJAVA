package gestioninventaire.model;

import java.io.Serializable;

public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;  // Identifiant de version pour la sérialisation

    private int id;  // Identifiant unique du produit
    private String nom;  // Nom du produit
    private String categorie;  // Catégorie du produit
    private int quantite;  // Quantité disponible en stock
    private double prix;  // Prix du produit

    // Constructeur par défaut (sans paramètres)
    public Produit() {}

    // Constructeur pour créer un produit avec les détails fournis
    public Produit(String nom, String categorie, int quantite, double prix) {
        this.nom = nom;
        this.categorie = categorie;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Constructeur pour mettre à jour un produit existant, incluant l'ID
    public Produit(int id, String nom, String categorie, int quantite, double prix) {
        this.id = id;  // Initialisation de l'ID du produit
        this.nom = nom;  // Initialisation du nom du produit
        this.categorie = categorie;  // Initialisation de la catégorie du produit
        this.quantite = quantite;  // Initialisation de la quantité du produit
        this.prix = prix;  // Initialisation du prix du produit
    }

    // Méthodes d'accès pour l'ID
    public int getId() { return id; }  // Récupérer l'ID du produit
    public void setId(int id) { this.id = id; }  // Définir l'ID du produit

    // Méthodes d'accès pour le nom
    public String getNom() { return nom; }  // Récupérer le nom du produit
    public void setNom(String nom) { this.nom = nom; }  // Définir le nom du produit

    // Méthodes d'accès pour la catégorie
    public String getCategorie() { return categorie; }  // Récupérer la catégorie du produit
    public void setCategorie(String categorie) { this.categorie = categorie; }  // Définir la catégorie du produit

    // Méthodes d'accès pour la quantité
    public int getQuantite() { return quantite; }  // Récupérer la quantité du produit
    public void setQuantite(int quantite) { this.quantite = quantite; }  // Définir la quantité du produit

    // Méthodes d'accès pour le prix
    public double getPrix() { return prix; }  // Récupérer le prix du produit
    public void setPrix(double prix) { this.prix = prix; }  // Définir le prix du produit

    // Redéfinition de la méthode toString() pour afficher les détails du produit
    @Override
    public String toString() {
        // Retourner une représentation lisible du produit avec ses attributs
        return "Produit {" +
               "ID: " + id +
               ", Nom: '" + nom + '\'' +
               ", Catégorie: '" + categorie + '\'' +
               ", Quantité: " + quantite +
               ", Prix: " + prix +
               '}';
    }
}
