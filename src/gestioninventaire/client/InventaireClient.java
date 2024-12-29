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
            // Connexion au serveur RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            produitService = (ProduitService) registry.lookup("ProduitService");

            while (true) {
                afficherMenu(); // Affiche le menu principal
                int choix = scanner.nextInt();
                scanner.nextLine(); // Consomme la nouvelle ligne restante

                switch (choix) {
                    case 1 -> ajouterProduit(); // Ajouter un nouveau produit
                    case 2 -> modifierProduit(); // Modifier un produit existant
                    case 3 -> supprimerProduit(); // Supprimer un produit
                    case 4 -> rechercherProduits(); // Rechercher des produits
                    case 5 -> {
                        System.out.println("Au revoir!");
                        System.exit(0); // Quitter l'application
                    }
                    default -> System.out.println("Choix invalide."); // Gérer un choix non valide
                }
            }
        } catch (Exception e) {
            // Gérer les exceptions liées à la connexion ou à l'appel de méthodes RMI
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void afficherMenu() {
        // Affiche les options du menu principal
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
            // Collecte les informations sur le produit à ajouter
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Catégorie : ");
            String categorie = scanner.nextLine();
            System.out.print("Quantité : ");
            int quantite = scanner.nextInt();
            System.out.print("Prix : ");
            double prix = scanner.nextDouble();

            // Crée un objet Produit et l'ajoute via le service RMI
            Produit produit = new Produit(nom, categorie, quantite, prix);
            produitService.ajouterProduit(produit);
            System.out.println("Produit ajouté avec succès !");
        } catch (Exception e) {
            // Gérer les erreurs lors de l'ajout du produit
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void modifierProduit() {
        try {
            // Collecte les informations pour modifier un produit existant
            System.out.print("ID : ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne restante
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Catégorie : ");
            String categorie = scanner.nextLine();
            System.out.print("Quantité : ");
            int quantite = scanner.nextInt();
            System.out.print("Prix : ");
            double prix = scanner.nextDouble();

            // Crée un objet Produit avec les nouvelles informations et appelle le service RMI
            Produit produit = new Produit(id, nom, categorie, quantite, prix);
            produitService.modifierProduit(produit);
            System.out.println("Produit modifié avec succès !");
        } catch (Exception e) {
            // Gérer les erreurs lors de la modification du produit
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void supprimerProduit() {
        try {
            // Collecte l'identifiant du produit à supprimer
            System.out.print("ID : ");
            int id = scanner.nextInt();

            // Supprime le produit via le service RMI
            produitService.supprimerProduit(id);
            System.out.println("Produit supprimé avec succès !");
        } catch (Exception e) {
            // Gérer les erreurs lors de la suppression du produit
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private static void rechercherProduits() {
        try {
            // Collecte le critère de recherche (nom partiel)
            System.out.print("Nom (partiel) : ");
            String nom = scanner.nextLine();

            // Recherche et affiche les produits correspondant au critère
            var produits = produitService.rechercherProduits(nom);
            produits.forEach(p -> System.out.println(p));
        } catch (Exception e) {
            // Gérer les erreurs lors de la recherche des produits
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
