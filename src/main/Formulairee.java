package main;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Formulairee extends JFrame {

    /**
	 * 
	 */
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
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création du panel avec GridLayout
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        // Initialisation des composants
        champNom = new JTextField();
        champPrenom = new JTextField();
        champAge = new JTextField();
        champPosition = new JComboBox<>(new String[] { "Gardien", "Defenseur", "Milieu", "Attaquant" });
        boutonAjouter = new JButton("Ajouter");
        zoneAffichage = new JTextArea(10, 20);
        zoneAffichage.setEditable(false);

        // Ajout des composants au panel
        panel.add(new JLabel("Nom:"));
        panel.add(champNom);
        panel.add(new JLabel("Prénom:"));
        panel.add(champPrenom);
        panel.add(new JLabel("Âge:"));
        panel.add(champAge);
        panel.add(new JLabel("Position:"));
        panel.add(champPosition);
        panel.add(boutonAjouter);
        panel.add(new JScrollPane(zoneAffichage));

        // Ajout du panel à la fenêtre principale
        getContentPane().add(panel);

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
