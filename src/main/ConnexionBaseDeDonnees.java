package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBaseDeDonnees {
    private static final String URL = "jdbc:mysql://localhost:3306/joueur";
    private static final String USER = "root";
    private static final String PASSWORD = "!biY-iHuIAEQnb4a";

    // Méthode pour obtenir une connexion à la base de données
    public static Connection getConnection() throws SQLException {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Chargement du driver
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie à la base de données.");
        } catch (ClassNotFoundException e) {
            System.err.println("Pilote JDBC non trouvé : " + e.getMessage());
        } 
        return cn;
    }

    // Méthode pour fermer les ressources
    public static void closeResources(Connection cn) {
        try {
            if (cn != null && !cn.isClosed()) {
                cn.close();
                System.out.println("Connexion fermée.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Formulairee(); // Lance l'interface graphique de formulaire
    }


}
