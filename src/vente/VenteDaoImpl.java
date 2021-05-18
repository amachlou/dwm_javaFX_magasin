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

public class VenteDaoImpl extends AbstractDAO implements IVenteDAO{

	@Override
	public void add(Vente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vente getOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vente> getAll(String text) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
