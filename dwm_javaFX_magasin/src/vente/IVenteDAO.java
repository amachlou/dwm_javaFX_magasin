package vente;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import database.IDAO;

public interface IVenteDAO extends IDAO<Vente> {

	List<Vente> getAllVente();

	List<Vente> searchVente(long id_vente, String nom, java.sql.Date date1, java.sql.Date date2);

	
	
}
