package com.loncoto.exercice.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.loncoto.exercice.beans.Article;

public class DAOarticle {

	public static final int ORDERED_BY_DEFAULT = 0;
	public static final int ORDERED_BY_PRIX = 1;
	public static final int ORDERED_BY_POIDS = 2;
	
	public static final String FIND_ALL_SQL = "select * from `article`";
	public static final String FIND_ALL_ORDERED_PRIX_SQL = "select * from `article` ORDER BY `prix`";
	public static final String FIND_ALL_ORDERED_POIDS_SQL = "select * from `article` ORDER BY `poids`";
	public static final String FIND_BY_ID_SQL = "select * from `article` where `id` = ?";
	public static final String UPDATE_ONE_SQL = "update `produit` set `libelle` = ?, `prix` = ?, `poids` = ? where `id` = ?";
	public static final String INSERT_ONE_SQL = "insert into `produit` (`libelle`, `prix`, `poids`) values (?, ?, ?)"; 
	public static final String DELETE_ONE_SQL = "delete from `produit` where `id` = ?";
	
	private PreparedStatement findAllStatement;
	private PreparedStatement findAllOrderedPrixStatement;
	private PreparedStatement findAllOrderedPoidsStatement;
	private PreparedStatement findByIdStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement insertStatement;
	private PreparedStatement deleteStatement;
	
	private Connection base;
	
	//CONSTRUCTEUR
	public DAOarticle(Connection base) {
		this.base = base;
		
		try {
			findAllStatement = base.prepareStatement(FIND_ALL_SQL);
			findAllOrderedPrixStatement = base.prepareStatement(FIND_ALL_ORDERED_PRIX_SQL);
			findAllOrderedPoidsStatement = base.prepareStatement(FIND_ALL_ORDERED_POIDS_SQL);
			findByIdStatement = base.prepareStatement(FIND_BY_ID_SQL);
			updateStatement = base.prepareStatement(UPDATE_ONE_SQL);
			insertStatement = base.prepareStatement(INSERT_ONE_SQL);
			deleteStatement = base.prepareStatement(DELETE_ONE_SQL);
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	//METHODES
	private Article fetchRow(ResultSet rs) {
		try {
			return new Article(rs.getInt("id"),
					rs.getString("libelle"),
					rs.getDouble("prix"),
					rs.getDouble("poids"));
		} catch(SQLException e) { e.printStackTrace();}
		return null;
	}
	
	//****************************************************** FIND ALL
	//  FIND_ALL_ORDERED_PRIX_SQL = "select * from `article` ORDER BY `prix`";
	//  FIND_ALL_ORDERED_POIDS_SQL = "select * from `article` ORDER BY `poids`";
	//******************************************************************
	
	public List<Article> findAll() {return findAll(ORDERED_BY_DEFAULT);}
	
	public List<Article> findAll(int OrderType) {
		ArrayList<Article> articles = new ArrayList<Article>();
		ResultSet rs = null;
		
		try {
			PreparedStatement stat = findAllStatement;
			
			switch(OrderType) {
			case ORDERED_BY_DEFAULT:
				findAllStatement.clearParameters();
				stat = findAllStatement;
				break;
			case ORDERED_BY_PRIX:
				findAllOrderedPrixStatement.clearParameters();
				stat = findAllOrderedPrixStatement;
				break;
			case ORDERED_BY_POIDS:
				findAllOrderedPoidsStatement.clearParameters();
				stat = findAllOrderedPoidsStatement;
				break;
			}

			rs = stat.executeQuery();
			
			while(rs.next()){articles.add(fetchRow(rs));}
		} catch (SQLException e) {e.printStackTrace();}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {e.printStackTrace();}
			}
		}
		return articles;
	}
	
	//****************************************************** FIND BY ID
	//  FIND_BY_ID_SQL = "select * from `article` where `id` = ?";
	//******************************************************************
	public Article findById(int idArticle){
		System.out.println("DAOarticle : findById : id = " + idArticle);
		Article article = null;
		ResultSet rs = null;
		
		try {
			findByIdStatement.clearParameters();
			findByIdStatement.setInt(1, idArticle);
			System.out.println("before executeQuery");
			rs = findByIdStatement.executeQuery();
			
			if(rs.next()){article = fetchRow(rs);}
			
		} catch (SQLException e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {e.printStackTrace();}
		}
		return article;
	}
	

}
