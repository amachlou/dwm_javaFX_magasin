package vente;
import java.util.List;

import connection.IDAO;

public interface IVenteDAO extends IDAO<Vente> {

	List<Vente> getAllVente();

	
	
}
