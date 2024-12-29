package gestioninventaire.rmi;

import gestioninventaire.model.Produit;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProduitService extends Remote {

    // Méthode pour ajouter un produit
    // Cette méthode sera invoquée à distance pour insérer un produit dans le système
    void ajouterProduit(Produit produit) throws RemoteException;

    // Méthode pour modifier un produit existant
    // Cette méthode sera invoquée à distance pour mettre à jour un produit dans le système
    void modifierProduit(Produit produit) throws RemoteException;

    // Méthode pour supprimer un produit en fonction de son ID
    // Cette méthode sera invoquée à distance pour supprimer un produit du système
    void supprimerProduit(int id) throws RemoteException;

    // Méthode pour rechercher des produits par leur nom
    // Cette méthode sera invoquée à distance pour récupérer une liste de produits correspondant au nom donné
    List<Produit> rechercherProduits(String nom) throws RemoteException;
}
