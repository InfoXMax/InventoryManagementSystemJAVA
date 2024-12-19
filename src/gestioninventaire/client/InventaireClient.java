package gestioninventaire.client;

import gestioninventaire.dao.ProduitDAO;
import gestioninventaire.model.Produit;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class InventaireClient {
    private static ProduitDAO produitDAO = new ProduitDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                afficherMenu();
                int choix = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choix) {
                    case 1:
                        ajouterProduit();
                        break;
                    case 2:
                        modifierProduit();
                        break;
                    case 3:
                        supprimerProduit();
                        break;
                    case 4:
                        rechercherProduit();
                        break;
                    case 5:
                        System.out.println("Au revoir!");
                        System.exit(0);
                    default:
                        System.out.println("Choix invalide.");
                }
            } catch (SQLException e) {
                System.out.println("Erreur SQL : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
            scanner.nextLine(); // Clear scanner buffer
        }
    }



    private static void afficherMenu() {
        System.out.println("\n--- Système de Gestion d'Inventaire ---");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Rechercher des produits");
        System.out.println("5. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void ajouterProduit() throws SQLException {
        System.out.print("Nom du produit : ");
        String nom = scanner.nextLine();
        System.out.print("Catégorie : ");
        String categorie = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Prix : ");
        double prix = scanner.nextDouble();

        Produit produit = new Produit(nom, categorie, quantite, prix);
        produitDAO.ajouterProduit(produit);
        System.out.println("Produit ajouté avec succès !");
    }

    private static void modifierProduit() throws SQLException {
        try {
            System.out.print("ID du produit à modifier : ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Produit produit = produitDAO.rechercherParNom("")
                    .stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(null);

            if (produit == null) {
                System.out.println("Produit non trouvé.");
                return;
            }

            System.out.print("Nouveau nom (laisser vide pour conserver) : ");
            String nom = scanner.nextLine();
            System.out.print("Nouvelle catégorie (laisser vide pour conserver) : ");
            String categorie = scanner.nextLine();
            System.out.print("Nouvelle quantité (-1 pour conserver) : ");
            int quantite = scanner.nextInt();
            System.out.print("Nouveau prix (-1 pour conserver) : ");
            double prix = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            if (!nom.isEmpty()) produit.setNom(nom);
            if (!categorie.isEmpty()) produit.setCategorie(categorie);
            if (quantite != -1) produit.setQuantite(quantite);
            if (prix != -1) produit.setPrix(prix);

            produitDAO.modifierProduit(produit);
            System.out.println("Produit modifié avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }


    private static void supprimerProduit() throws SQLException {
        System.out.print("ID du produit à supprimer : ");
        int id = scanner.nextInt();
        produitDAO.supprimerProduit(id);
        System.out.println("Produit supprimé avec succès !");
    }

    private static void rechercherProduit() throws SQLException {
        System.out.print("Rechercher par nom (ou partie du nom) : ");
        String nom = scanner.nextLine();
        List<Produit> produits = produitDAO.rechercherParNom(nom);
        
        if (produits.isEmpty()) {
            System.out.println("Aucun produit trouvé.");
        } else {
            produits.forEach(p -> {
                System.out.println("ID: " + p.getId() + 
                                   ", Nom: " + p.getNom() + 
                                   ", Catégorie: " + p.getCategorie() + 
                                   ", Quantité: " + p.getQuantite() + 
                                   ", Prix: " + p.getPrix());
            });
        }
    }
}