package gestioninventaire.dao;

import gestioninventaire.database.DatabaseConnection;
import gestioninventaire.model.Produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {
    // Ajouter un produit
    public void ajouterProduit(Produit produit) throws SQLException {
        String sql = "INSERT INTO produits (nom, categorie, quantite, prix) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produit.getNom());
            pstmt.setString(2, produit.getCategorie());
            pstmt.setInt(3, produit.getQuantite());
            pstmt.setDouble(4, produit.getPrix());
            pstmt.executeUpdate();
        }
    }

    // Mettre à jour un produit
    public void modifierProduit(Produit produit) throws SQLException {
        String sql = "UPDATE produits SET nom = ?, categorie = ?, quantite = ?, prix = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produit.getNom());
            pstmt.setString(2, produit.getCategorie());
            pstmt.setInt(3, produit.getQuantite());
            pstmt.setDouble(4, produit.getPrix());
            pstmt.setInt(5, produit.getId());
            pstmt.executeUpdate();
        }
    }

    // Supprimer un produit
    public void supprimerProduit(int id) throws SQLException {
        String sql = "DELETE FROM produits WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    // Rechercher des produits par nom
    public List<Produit> rechercherParNom(String nom) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT * FROM produits WHERE nom LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + nom + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Produit produit = new Produit();
                    produit.setId(rs.getInt("id"));
                    produit.setNom(rs.getString("nom"));
                    produit.setCategorie(rs.getString("categorie"));
                    produit.setQuantite(rs.getInt("quantite"));
                    produit.setPrix(rs.getDouble("prix"));
                    produits.add(produit);
                }
            }
        }
        return produits;
    }
}