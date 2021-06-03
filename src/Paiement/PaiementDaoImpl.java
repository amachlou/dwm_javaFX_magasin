package Paiement;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDAO;

public class PaiementDaoImpl extends AbstractDAO implements IPaiementDAO {

	@Override
	public void add(Paiement obj) {
		PreparedStatement pst=null;
		String query="insert into paiement (date,type,montant,total_paye,reste,num_cheque,proprietaire,banque,id_vente) values(?,?,?,?,?,?,?,?,?)";
		
		try {
			
			pst=connection.prepareStatement(query);
			Date date=Date.valueOf(obj.getDate());
			pst.setDate(1,date);
			pst.setString(2, obj.getType());
			pst.setDouble(3, obj.getMontant());
			pst.setDouble(4, obj.getTotal_paye());
			pst.setInt(5, obj.getNum_cheque());
			pst.setString(6, obj.getProprietaire());
			pst.setString(7, obj.getBanque());
			pst.setLong(8, obj.getId_vente());	
			pst.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Paiement obj) {
		PreparedStatement pst=null;
		String query="UPDATE paiement SET date=?,type=?,montant=?,total_paye=?,reste=?,num_cheque=?,proprietaire=?,banque=?,id_vente=? WHERE id_paiment=?";
		
		try {
			
			pst=connection.prepareStatement(query);
			Date date=Date.valueOf(obj.getDate());
			pst.setDate(1,date);
			pst.setString(2, obj.getType());
			pst.setDouble(3, obj.getMontant());
			pst.setDouble(4, obj.getTotal_paye());
			pst.setInt(5, obj.getNum_cheque());
			pst.setString(6, obj.getProprietaire());
			pst.setString(7, obj.getBanque());
			pst.setLong(8, obj.getId_vente());
			pst.setLong(9, obj.getId_paiement());	
			pst.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(long id) {
		
		PreparedStatement pst=null;
		ResultSet rs;
		String query="delete from paiement where id_paiement=?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setLong(1, id);
			pst.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Paiement getOne(long id) {
		List<Paiement> list =new ArrayList<Paiement>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from paiement where id_paiement =?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setLong(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				Date date =rs.getDate("date");
				return new Paiement(rs.getLong("id_paiement"),date.toLocalDate(),rs.getString("type"),rs.getDouble("montant"),rs.getDouble("total_paye"),rs.getDouble("reste"),rs.getInt("num_cheque"),rs.getString("proprietaire"),rs.getString("banque"),rs.getLong("id_vente"));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Paiement> getAll() {
		
		List<Paiement> list =new ArrayList<Paiement>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from paiement";
		
		try {
			
			pst=connection.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				Date date =rs.getDate("date");
				list.add(new Paiement(rs.getLong("id_paiement"),date.toLocalDate(),rs.getString("type"),rs.getDouble("montant"),rs.getDouble("total_paye"),rs.getDouble("reste"),rs.getInt("num_cheque"),rs.getString("proprietaire"),rs.getString("banque"),rs.getLong("id_vente")));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	@Override
	public List<Paiement> getAll(String text) {
		List<Paiement> list =new ArrayList<Paiement>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from paiement where type like ?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setString(1, text+"%");
			rs=pst.executeQuery();
			while(rs.next()) {
				Date date =rs.getDate("date");
				list.add(new Paiement(rs.getLong("id_paiement"),date.toLocalDate(),rs.getString("type"),rs.getDouble("montant"),rs.getDouble("total_paye"),rs.getDouble("reste"),rs.getInt("num_cheque"),rs.getString("proprietaire"),rs.getString("banque"),rs.getLong("id_vente")));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}


	
	

}
