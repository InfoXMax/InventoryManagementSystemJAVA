/**
 * Module definition for Management.
 */
module Management {
    requires java.sql;
    requires java.rmi;
    requires java.naming;
    exports gestioninventaire.rmi; // Export the RMI package so it can be accessed by the client.
}
