package com.loncoto.webCustomTag.beans;

/*->
developper un site web javaEE avec les op�rations CRUD sur une liste d'articles

1 article � comme caract�ristiques:
	id (cle primaire)
	libelle (String)
	prix (double)
	poids (double)

ecrire le ArticleDAO et le DatabaseManager, et creer la table
les op�rations crud:
	findAll
	findByID
	save
	delete
	
pouvoir trier les articles renvoy�s par findAll par prix ou poids

1ere �tape
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
