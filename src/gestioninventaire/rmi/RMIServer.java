package gestioninventaire.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Créer une instance du service ProduitServiceImpl
            ProduitService produitService = new ProduitServiceImpl();

            // Créer un registre RMI sur le port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Lier le service ProduitService à l'enregistrement RMI sous le nom "ProduitService"
            registry.rebind("ProduitService", produitService);

            // Afficher un message indiquant que le serveur RMI a démarré
            System.out.println("Serveur RMI démarré sur le port 1099.");
        } catch (Exception e) {
            // Gérer les exceptions et afficher un message d'erreur en cas de problème
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
