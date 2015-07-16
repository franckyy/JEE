package com.loncoto.webfirstjdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.loncoto.webfirstjdbc.beans.Client;

public class ClientDAO {
	
	public static final String FINDALL_SQL = "select * from `client`";
	public static final String FINDBYID_SQL = "select * from `client` where id = ?";
	public static final String UPDATE_ONE_SQL = "update `client` set `nom` = ?, `email` = ?, `solde` =  ? where `id` = ?";
	public static final String INSERT_ONE_SQL = "insert into `client` (`nom`, `email`, `solde`) values(?, ?, ?)";
	public static final String DELETE_ONE_SQL = "delete from `client` where id = ?";
	
	private PreparedStatement findAllStatement;
	private PreparedStatement findByIdStatement;
	private PreparedStatement updateOneStatement;
	private PreparedStatement insertOneStatement;
	private PreparedStatement deleteOneStatement;
	
	private Connection base;
	
	public ClientDAO(Connection base) {
		this.base = base;
		
		try {
			//Préparation des requêtes
			findAllStatement = base.prepareStatement(FINDALL_SQL);
			findByIdStatement = base.prepareStatement(FINDBYID_SQL);
			updateOneStatement = base.prepareStatement(UPDATE_ONE_SQL);
			insertOneStatement = base.prepareStatement(INSERT_ONE_SQL);
			deleteOneStatement = base.prepareStatement(DELETE_ONE_SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int delete(int id) {
		try {
			deleteOneStatement.clearParameters();
			
			deleteOneStatement.setInt(1, id);
			
			return deleteOneStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int save(Client c) {
		//vérification si on est dans le cas d'un insert ou d'un update
		if(c.getId() > 0){
			//c'est un update UPDATE_ONE_SQL = "update `client` set `nom` = ?, `email` = ?, `solde` =  ? where `id` = ?";
			try {
				updateOneStatement.clearParameters();
				
				updateOneStatement.setString(1, c.getNom());
				updateOneStatement.setString(2, c.getEmail());
				updateOneStatement.setDouble(3, c.getSolde());
				updateOneStatement.setInt(4, c.getId());
				
				return updateOneStatement.executeUpdate();	//cette fonction retourne un entier
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		else {
			//c'est un insert INSERT_ONE_SQL = "insert into `client` (`nom`, `email`, `solde`) values(?, ?, ?)";
			try {
				insertOneStatement.clearParameters();
				
				insertOneStatement.setString(1, c.getNom());
				insertOneStatement.setString(2, c.getEmail());
				insertOneStatement.setDouble(3, c.getSolde());
				
				return insertOneStatement.executeUpdate();
			} catch (SQLException e) {
			}
		}
		return 0;
	}
	
	public Client findById(int id) {
		Client c = null;
		ResultSet rs = null;
		
		try {
			findByIdStatement.clearParameters();
			//remplacement du point d'interrogation
			findByIdStatement.setInt(1, id);
			
			rs = findByIdStatement.executeQuery();
			
			if(rs.next()) {
				c = new Client(rs.getInt("id"),
								rs.getString("nom"),
								rs.getString("email"),
								rs.getDouble("solde"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//En production, il vaut mieux faire le close dans le finally car il peut se produire des erreurs
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return c;
	}
	
	public List<Client> findAll() {
		ArrayList<Client> data = new ArrayList<Client>();
		ResultSet rs = null;
		
		try {
			//je nettoie les paramètres précédents
			findAllStatement.clearParameters();
			//j'exécute la requête
			rs = findAllStatement.executeQuery();
			
			while(rs.next()) {
				data.add(new Client(rs.getInt("id"),
									rs.getString("nom"),
									rs.getString("email"),
									rs.getDouble("solde")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//En production, il vaut mieux faire le close dans le finally car il peut se produire des erreurs
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}		
		}
		return data;
	}
	
}