package com.loncoto.exercice.beans;

/*->
developper un site web javaEE avec les opérations CRUD sur une liste d'articles

1 article à comme caractéristiques:
	id (cle primaire)
	libelle (String)
	prix (double)
	poids (double)

ecrire le ArticleDAO et le DatabaseManager, et creer la table
les opérations crud:
	findAll
	findByID
	save
	delete
	
pouvoir trier les articles renvoyés par findAll par prix ou poids

1ere étape
servlet ArticleServlet
liste.jsp avec la liste des articles.

*/

public class Article {

	//DECLARATIONS
	private int id;
	private String libelle;
	private double prix;
	private double poids;
	
	//CONSTRUCTEUR
	public Article() {this(0,"",0,0);}
	
	public Article(int id, String libelle, double prix, double poids) {
		super();
		setId(id);
		setLibelle(libelle);
		setPrix(prix);
		setPoids(poids);
	}
	
	//GETTERS & SETTERS
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}
	
	public double getPrix() {return prix;}
	public void setPrix(double prix) {this.prix = prix;}
	
	public double getPoids() {return poids;}
	public void setPoids(double poids) {this.poids = poids;}	
}
