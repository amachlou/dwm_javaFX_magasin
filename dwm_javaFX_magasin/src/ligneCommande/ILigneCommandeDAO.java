package ligneCommande;
import java.util.List;

import database.IDAO;

public interface ILigneCommandeDAO extends IDAO<LigneCommande> {

	List<LigneCommande> getAllLigne(long id_vente);

	
	
}
