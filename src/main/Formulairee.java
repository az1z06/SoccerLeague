package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Formulairee extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField champNom;
    private JTextField champPrenom;
    private JTextField champAge;
    private JComboBox<String> champPosition;
    private JButton boutonAjouter;
    private JTextArea zoneAffichage;

    private Controleur controleur;

    public Formulairee() {
        // Initialisation du contrôleur
        controleur = new Controleur();

        // Configuration de la fenêtre principale
        setTitle("Formulaire d'ajout de Joueur");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création du panel principal avec BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Création du panel pour les champs de formulaire avec GridBagLayout
        JPanel panelFormulaire = new JPanel(new GridBagLayout());
        panelFormulaire.setBorder(BorderFactory.createTitledBorder("Informations du Joueur"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Initialisation des composants
        champNom = new JTextField(20);
        champPrenom = new JTextField(20);
        champAge = new JTextField(20);
        champPosition = new JComboBox<>(new String[] { "Gardien", "Defenseur", "Milieu", "Attaquant" });
        boutonAjouter = new JButton("Ajouter");
        zoneAffichage = new JTextArea(10, 20);
        zoneAffichage.setEditable(false);
        zoneAffichage.setBorder(BorderFactory.createTitledBorder("Liste des Joueurs"));

        // Ajout des composants au panel de formulaire
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulaire.add(new JLabel("Nom:"), gbc);
        gbc.gridx = 1;
        panelFormulaire.add(champNom, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulaire.add(new JLabel("Prénom:"), gbc);
        gbc.gridx = 1;
        panelFormulaire.add(champPrenom, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulaire.add(new JLabel("Âge:"), gbc);
        gbc.gridx = 1;
        panelFormulaire.add(champAge, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelFormulaire.add(new JLabel("Position:"), gbc);
        gbc.gridx = 1;
        panelFormulaire.add(champPosition, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelFormulaire.add(boutonAjouter, gbc);

        // Ajout du panel de formulaire au panel principal
        panelPrincipal.add(panelFormulaire, BorderLayout.NORTH);

        // Ajout de la zone d'affichage au panel principal
        panelPrincipal.add(new JScrollPane(zoneAffichage), BorderLayout.CENTER);

        // Ajout du panel principal à la fenêtre principale
        getContentPane().add(panelPrincipal);

        // Gestion de l'événement du bouton Ajouter
        boutonAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nom = champNom.getText();
                    String prenom = champPrenom.getText();
                    int age = Integer.parseInt(champAge.getText());
                    String position = (String) champPosition.getSelectedItem();

                    // Ajout du joueur via le contrôleur
                    controleur.ajouterJoueur(nom, prenom, age, position);

                    // Affichage des joueurs dans la zone d'affichage
                    zoneAffichage.setText(controleur.afficherJoueurs());

                    // Réinitialisation des champs
                    champNom.setText("");
                    champPrenom.setText("");
                    champAge.setText("");
                    champPosition.setSelectedIndex(0);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Formulairee.this, "Veuillez entrer un âge valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Formulairee();
    }
}