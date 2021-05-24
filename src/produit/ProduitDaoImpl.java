package produit;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractDAO;

public class ProduitDaoImpl extends AbstractDAO implements IProduitDAO {

	@Override
	public void add(Produit obj) {
		PreparedStatement pst=null;
		String query="insert into produit (designation,qte,prix,date) values(?,?,?,?)";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setString(1, obj.getDesignation());
			pst.setInt(2, obj.getQte());
			pst.setDouble(3, obj.getPrix());
			Date date=Date.valueOf(obj.getDate());
			pst.setDate(4,date);
			pst.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Produit obj) {
		PreparedStatement pst=null;
		String query="UPDATE lignecommande SET designation=?,prix=?,qte=?,sous_total=?,id_produit=?,id_vente=? WHERE id_cmd=?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setString(1, obj.getDesignation());
			pst.setInt(2, obj.getQte());
			pst.setDouble(3, obj.getPrix());
			Date date=Date.valueOf(obj.getDate());
			pst.setDate(4,date);
			pst.setLong(5, obj.getId_produit());
			pst.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(long id) {
		
		PreparedStatement pst=null;
		ResultSet rs;
		String query="delete from produit where id_produit =?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setLong(1, id);
			pst.executeUpdate();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Produit getOne(long id) {
		List<Produit> list =new ArrayList<Produit>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from produit where id_produit =?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setLong(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				Date date =rs.getDate("date");
				return new Produit(rs.getInt("id_produit"),rs.getString("designation"),rs.getInt("qte"),rs.getDouble("prix"),date.toLocalDate());
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Produit> getAll() {
		
		List<Produit> list =new ArrayList<Produit>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from produit";
		
		try {
			
			pst=connection.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				Date date =rs.getDate("date");
				list.add(new Produit(rs.getLong("id_produit"),rs.getString("designation"),rs.getInt("qte"),rs.getDouble("prix"),date.toLocalDate()));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	@Override
	public List<Produit> getAll(String text) {
		List<Produit> list =new ArrayList<Produit>();
		PreparedStatement pst=null;
		ResultSet rs;
		String query="select * from produit where designation like ?";
		
		try {
			
			pst=connection.prepareStatement(query);
			pst.setString(1, text+"%");
			rs=pst.executeQuery();
			while(rs.next()) {
				Date date =rs.getDate("date");
				list.add(new Produit(rs.getLong("id_produit"),rs.getString("designation"),rs.getInt("qte"),rs.getDouble("prix"),date.toLocalDate()));
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}


	
	

}
