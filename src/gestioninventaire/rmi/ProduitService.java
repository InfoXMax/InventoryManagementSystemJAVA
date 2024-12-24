package gestioninventaire.rmi;

import gestioninventaire.model.Produit;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProduitService extends Remote {
    void ajouterProduit(Produit produit) throws RemoteException;

    void modifierProduit(Produit produit) throws RemoteException;

    void supprimerProduit(int id) throws RemoteException;

    List<Produit> rechercherProduits(String nom) throws RemoteException;
}
