package gestioninventaire.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            ProduitService produitService = new ProduitServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ProduitService", produitService);
            System.out.println("Serveur RMI démarré sur le port 1099.");
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
