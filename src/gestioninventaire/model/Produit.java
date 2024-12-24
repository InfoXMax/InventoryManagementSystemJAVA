package gestioninventaire.model;

import java.io.Serializable;

public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nom;
    private String categorie;
    private int quantite;
    private double prix;

    // Default constructor
    public Produit() {}

    // Constructor for creating a new product
    public Produit(String nom, String categorie, int quantite, double prix) {
        this.nom = nom;
        this.categorie = categorie;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Constructor for updating a product (with ID)
    public Produit(int id, String nom, String categorie, int quantite, double prix) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    // toString() override
    @Override
    public String toString() {
        return "Produit {" +
               "ID: " + id +
               ", Nom: '" + nom + '\'' +
               ", Catégorie: '" + categorie + '\'' +
               ", Quantité: " + quantite +
               ", Prix: " + prix +
               '}';
    }
}
