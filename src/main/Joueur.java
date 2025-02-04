package main;

public class Joueur {
	private int idJoueur;
	private String nom;
	private String prenom;
	private int age;
	private String position;
	private static int compteurId = 1;
	
	public Joueur(String nom, String prenom, int age, String position) {
		idJoueur = compteurId++;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.position = position;
	}

	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "Joueur :{" + "ID = " + this.idJoueur + ", Nom= " + this.nom 
				+ "/ Prenom= " + this.prenom 
				+ "/ Age= " + this.age 
				+ "/ Position=" + this.position +" }";
	}

}
