package com.loncoto.exercice.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.loncoto.exercice.beans.Article;

public class DAOarticle {
	
	public static final String FIND_ALL_SQL = "select * from `article`";
	public static final String FIND_BY_ID_SQL = "select * from `article` where `id` = ?";
	public static final String UPDATE_ONE_SQL = "update `produit` set `libelle` = ?, `prix` = ?, `poids` = ? where `id` = ?";
	public static final String INSERT_ONE_SQL = "insert into `produit` (`libelle`, `prix`, `poids`) values (?, ?, ?)"; 
	public static final String DELETE_ONE_SQL = "delete from `produit` where `id` = ?";
	
	private PreparedStatement findAllStatement;
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
			findByIdStatement = base.prepareStatement(FIND_BY_ID_SQL);
			updateStatement = base.prepareStatement(UPDATE_ONE_SQL);
			insertStatement = base.prepareStatement(INSERT_ONE_SQL);
			deleteStatement = base.prepareStatement(DELETE_ONE_SQL);
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	//METHODES
	public Article findById(int idArticle){
		Article article = null;
		ResultSet rs = null;
		
		try {
			findByIdStatement.clearParameters();
			findByIdStatement.setInt(1, idArticle);
			findByIdStatement.executeQuery();
			
			if(rs.next()) {
				article = new Article(rs.getInt("id"),
										rs.getString("libelle"),
										rs.getDouble("prix"),
										rs.getDouble("poids")
						);
			}
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
	
	public List<Article> findAll() {
		ArrayList<Article> articles = new ArrayList<Article>();
		
		ResultSet rs = null;
		
		try {
			findAllStatement.clearParameters();
			
			rs = findAllStatement.executeQuery();
			
			while(rs.next()){
				articles.add(new Article(rs.getInt("id"),
							rs.getString("libelle"),
							rs.getDouble("prix"),
							rs.getDouble("poids"))
						);				
			}
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
}
