package gestioninventaire.client;

import gestioninventaire.rmi.ProduitService;
import gestioninventaire.model.Produit;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class InventaireClient {
    private static ProduitService produitService;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Connect to RMI server
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            produitService = (ProduitService) registry.lookup("ProduitService");

            while (true) {
                afficherMenu();
                int choix = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choix) {
                    case 1 -> ajouterProduit();
                    case 2 -> modifierProduit();
                    case 3 -> supprimerProduit();
                    case 4 -> rechercherProduits();
                    case 5 -> {
                        System.out.println("Au revoir!");
                        System.exit(0);
                    }
                    default -> System.out.println("Choix invalide.");
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
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

    private static void ajouterProduit() {
        try {
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Catégorie : ");
            String categorie = scanner.nextLine();
            System.out.print("Quantité : ");
            int quantite = scanner.nextInt();
            System.out.print("Prix : ");
            double prix = scanner.nextDouble();

            Produit produit = new Produit(nom, categorie, quantite, prix);
            produitService.ajouterProduit(produit);
            System.out.println("Produit ajouté avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void modifierProduit() {
        try {
            System.out.print("ID : ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Catégorie : ");
            String categorie = scanner.nextLine();
            System.out.print("Quantité : ");
            int quantite = scanner.nextInt();
            System.out.print("Prix : ");
            double prix = scanner.nextDouble();

            Produit produit = new Produit(id, nom, categorie, quantite, prix);
            produitService.modifierProduit(produit);
            System.out.println("Produit modifié avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void supprimerProduit() {
        try {
            System.out.print("ID : ");
            int id = scanner.nextInt();
            produitService.supprimerProduit(id);
            System.out.println("Produit supprimé avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void rechercherProduits() {
        try {
            System.out.print("Nom (partiel) : ");
            String nom = scanner.nextLine();
            var produits = produitService.rechercherProduits(nom);
            produits.forEach(p -> System.out.println(p));
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
