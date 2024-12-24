package gestioninventaire.rmi;

import gestioninventaire.dao.ProduitDAO;
import gestioninventaire.model.Produit;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ProduitServiceImpl extends UnicastRemoteObject implements ProduitService {
    private final ProduitDAO produitDAO;

    public ProduitServiceImpl() throws RemoteException {
        produitDAO = new ProduitDAO();
    }

    @Override
    public void ajouterProduit(Produit produit) throws RemoteException {
        try {
            produitDAO.ajouterProduit(produit);
        } catch (Exception e) {
            throw new RemoteException("Erreur lors de l'ajout du produit", e);
        }
    }

    @Override
    public void modifierProduit(Produit produit) throws RemoteException {
        try {
            produitDAO.modifierProduit(produit);
        } catch (Exception e) {
            throw new RemoteException("Erreur lors de la modification du produit", e);
        }
    }

    @Override
    public void supprimerProduit(int id) throws RemoteException {
        try {
            produitDAO.supprimerProduit(id);
        } catch (Exception e) {
            throw new RemoteException("Erreur lors de la suppression du produit", e);
        }
    }

    @Override
    public List<Produit> rechercherProduits(String nom) throws RemoteException {
        try {
            return produitDAO.rechercherParNom(nom);
        } catch (Exception e) {
            throw new RemoteException("Erreur lors de la recherche des produits", e);
        }
    }
}
