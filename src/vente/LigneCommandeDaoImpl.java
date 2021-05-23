package vente;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.ListeClients;
import application.Main;
import client.Client;
import connection.AbstractDAO;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import produit.Produit;

public class LigneCommandeDaoImpl extends AbstractDAO implements ILigneCommandeDAO{

	@Override
	public void add(LigneCommande obj) {
		
		PreparedStatement pst=null;
		String query="insert into lignecommande (qte,sous_total,id_produit,id_vente) values(?,?,?,?)";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setInt(1,obj.getQte());
			pst.setDouble(2, obj.getSous_total());
			pst.setLong(3, obj.getId_produit());
			pst.setLong(4, obj.getId_vente());
			pst.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(LigneCommande obj) {
		PreparedStatement pst=null;
		String query="UPDATE lignecommande set qte=?,sous_total=?,id_produit=?,id_vente=?  WHERE id_cmd=?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setInt(1,obj.getQte());
			pst.setDouble(2, obj.getSous_total());
			pst.setLong(3, obj.getId_produit());
			pst.setLong(4, obj.getId_vente());
			pst.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(long id) {
		PreparedStatement pst=null;
		ResultSet rs;
		String query="delete from lignecommande where id_cmd =?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setLong(1, id);
			pst.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public LigneCommande getOne(long id) {
		List<LigneCommande> list =new ArrayList<LigneCommande>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from lignecommande where id_cmd =?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setLong(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				return new LigneCommande(rs.getLong("id_cmd"),rs.getInt("qte"),rs.getDouble("sous_total"),rs.getLong("id_produit"),rs.getLong("id_vente"));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<LigneCommande> getAll() {
		List<LigneCommande> list =new ArrayList<LigneCommande>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from lignecommande";
		
		try {
			
			pst=connection.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new LigneCommande(rs.getLong("id_cmd"),rs.getInt("qte"),rs.getDouble("sous_total"),rs.getLong("id_produit"),rs.getLong("id_vente")));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<LigneCommande> getAll(String text) {
		List<LigneCommande> list =new ArrayList<LigneCommande>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from lignecommande where nom like ?";

		try {
			
			pst=connection.prepareStatement(query);
			pst.setString(1, text+"%");
			rs=pst.executeQuery();
			while(rs.next()) {
				Date date =rs.getDate("date");
				list.add(new LigneCommande(rs.getLong("id_cmd"),rs.getInt("qte"),rs.getDouble("sous_total"),rs.getLong("id_produit"),rs.getLong("id_vente")));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}


	
}
