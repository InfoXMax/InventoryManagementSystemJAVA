package gestioninventaire.dao;

import gestioninventaire.database.DatabaseConnection;
import gestioninventaire.model.Produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {

    // Ajouter un produit dans la base de données
    public void ajouterProduit(Produit produit) throws SQLException {
        String sql = "INSERT INTO produits (nom, categorie, quantite, prix) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produit.getNom());  // Définir le nom du produit
            pstmt.setString(2, produit.getCategorie());  // Définir la catégorie du produit
            pstmt.setInt(3, produit.getQuantite());  // Définir la quantité du produit
            pstmt.setDouble(4, produit.getPrix());  // Définir le prix du produit
            pstmt.executeUpdate();  // Exécuter la requête pour insérer le produit
        }
    }

    // Mettre à jour les informations d'un produit existant
    public void modifierProduit(Produit produit) throws SQLException {
        String sql = "UPDATE produits SET nom = ?, categorie = ?, quantite = ?, prix = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produit.getNom());  // Mettre à jour le nom du produit
            pstmt.setString(2, produit.getCategorie());  // Mettre à jour la catégorie du produit
            pstmt.setInt(3, produit.getQuantite());  // Mettre à jour la quantité du produit
            pstmt.setDouble(4, produit.getPrix());  // Mettre à jour le prix du produit
            pstmt.setInt(5, produit.getId());  // Spécifier l'ID du produit à mettre à jour
            pstmt.executeUpdate();  // Exécuter la requête pour mettre à jour le produit
        }
    }

    // Supprimer un produit de la base de données
    public void supprimerProduit(int id) throws SQLException {
        String sql = "DELETE FROM produits WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);  // Spécifier l'ID du produit à supprimer
            pstmt.executeUpdate();  // Exécuter la requête pour supprimer le produit
        }
    }

    // Rechercher des produits par leur nom
    public List<Produit> rechercherParNom(String nom) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT * FROM produits WHERE nom LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nom + "%");  // Rechercher les produits dont le nom contient la chaîne donnée
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Produit produit = new Produit();
                    produit.setId(rs.getInt("id"));  // Récupérer l'ID du produit
                    produit.setNom(rs.getString("nom"));  // Récupérer le nom du produit
                    produit.setCategorie(rs.getString("categorie"));  // Récupérer la catégorie du produit
                    produit.setQuantite(rs.getInt("quantite"));  // Récupérer la quantité du produit
                    produit.setPrix(rs.getDouble("prix"));  // Récupérer le prix du produit
                    produits.add(produit);  // Ajouter le produit à la liste
                }
            }
        }
        return produits;  // Retourner la liste des produits trouvés
    }
}
