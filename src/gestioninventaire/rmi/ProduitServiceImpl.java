package gestioninventaire.rmi;

import gestioninventaire.dao.ProduitDAO;
import gestioninventaire.model.Produit;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ProduitServiceImpl extends UnicastRemoteObject implements ProduitService {
    private final ProduitDAO produitDAO;  // Instance de la classe ProduitDAO pour accéder à la base de données

    // Constructeur pour initialiser le DAO
    public ProduitServiceImpl() throws RemoteException {
        produitDAO = new ProduitDAO();  // Initialiser le DAO pour manipuler les produits
    }

    // Implémentation de la méthode ajouterProduit de l'interface ProduitService
    @Override
    public void ajouterProduit(Produit produit) throws RemoteException {
        try {
            produitDAO.ajouterProduit(produit);  // Appeler la méthode pour ajouter le produit dans la base de données
        } catch (Exception e) {
            throw new RemoteException("Erreur lors de l'ajout du produit", e);  // Gérer les exceptions en renvoyant une RemoteException
        }
    }

    // Implémentation de la méthode modifierProduit de l'interface ProduitService
    @Override
    public void modifierProduit(Produit produit) throws RemoteException {
        try {
            produitDAO.modifierProduit(produit);  // Appeler la méthode pour modifier le produit dans la base de données
        } catch (Exception e) {
            throw new RemoteException("Erreur lors de la modification du produit", e);  // Gérer les exceptions en renvoyant une RemoteException
        }
    }

    // Implémentation de la méthode supprimerProduit de l'interface ProduitService
    @Override
    public void supprimerProduit(int id) throws RemoteException {
        try {
            produitDAO.supprimerProduit(id);  // Appeler la méthode pour supprimer le produit de la base de données en fonction de l'ID
        } catch (Exception e) {
            throw new RemoteException("Erreur lors de la suppression du produit", e);  // Gérer les exceptions en renvoyant une RemoteException
        }
    }

    // Implémentation de la méthode rechercherProduits de l'interface ProduitService
    @Override
    public List<Produit> rechercherProduits(String nom) throws RemoteException {
        try {
            return produitDAO.rechercherParNom(nom);  // Appeler la méthode pour rechercher les produits par nom
        } catch (Exception e) {
            throw new RemoteException("Erreur lors de la recherche des produits", e);  // Gérer les exceptions en renvoyant une RemoteException
        }
    }
}
