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
	
	private PreparedStatement findAllStatement;
	private PreparedStatement findByIdStatement;
		
	private Connection base;
	
	public ClientDAO(Connection base) {
		this.base = base;
		
		try {
			findAllStatement = base.prepareStatement(FINDALL_SQL);
			findByIdStatement = base.prepareStatement(FINDBYID_SQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Client findById(int id) {
		Client c = null;
		ResultSet rs = null;
		
		try {
			findByIdStatement.clearParameters();
			//remplacement du pooint d'interrogation
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