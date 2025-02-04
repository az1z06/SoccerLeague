package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controleur {
    private static final String URL = "jdbc:mysql://localhost:3306/joueur";
    private static final String USER = "root";
    private static final String PASSWORD = "!biY-iHuIAEQnb4a";
    private ArrayList<Joueur> listeJoueurs;
    private Connection cn;

    // Constructeur : initialise la liste et la connexion à la base de données
    public Controleur() {
        listeJoueurs = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion à la base de données réussie.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
        }
    }

    // Méthode pour ajouter un joueur à la liste et à la base de données
    public void ajouterJoueur(String nom, String prenom, int age, String position) {
        Joueur joueur = new Joueur(nom, prenom, age, position);
        listeJoueurs.add(joueur);

        // Insertion dans la base de données
        String sql = "INSERT INTO joueurs (nom, prenom, age, position) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, nom);
            pst.setString(2, prenom);
            pst.setInt(3, age);
            pst.setString(4, position);
            pst.executeUpdate();
            System.out.println("Joueur ajouté dans la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du joueur : " + e.getMessage());
        }
    }

    // Méthode pour afficher tous les joueurs de la liste
    public String afficherJoueurs() {
        StringBuilder sb = new StringBuilder();
        for (Joueur joueur : listeJoueurs) {
            sb.append(joueur).append("\n");
        }
        return sb.toString();
    }
}
