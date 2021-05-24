package vente;
import java.util.List;

import connection.IDAO;

public interface ILigneCommandeDAO extends IDAO<LigneCommande> {

	List<LigneCommande> getAllLigne(long id_vente);

	
	
}
