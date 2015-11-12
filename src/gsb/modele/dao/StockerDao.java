package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Stocker;

public class StockerDao {

	/**
	 * Ajoute une entré dans le stock, ou modifi la quantité si déjà présente
	 * @param unStock le stock a ajouter
	 * @return 1 si bien passé, 0 sinon
	 */
	public static int ajouterStock( Stocker unStock ){
		int ret = 1;
		
		String requete = null;
		String matriculeVisiteur = unStock.getUnVisiteur().getMatricule();
		String depotLegalmedicament = unStock.getUnMedicament().getDepotLegal();
		int qte = unStock.getQteStock();
		
		
		// Update la quantité si stock déjà existant
		if(existe(unStock)){
			requete = "update stocker set "
					+ "qteStock = '"+ qte 					+"' "
					+ "where refVisiteur = '" + matriculeVisiteur + "'"
					+ "and refMedicament = '" + depotLegalmedicament+"'";
		}
		// Sinon ajoute la nouvelle entrée
		else {
			requete = "insert into stocker values("
					+ "'"+ qte 					+"',"
					+ "'"+ matriculeVisiteur 	+"',"
					+ "'"+ depotLegalmedicament +"');";
		}
		
	
		try {
			ret = ConnexionMySql.execReqMaj(requete);
			ConnexionMySql.fermerConnexionBd();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	/**
	 * @param unStock
	 * @return true si le stock existe, false sinon
	 */
	public static boolean existe( Stocker unStock ){
		boolean exist = false;
		
		String req = "select * from stocker "
					+"where refVisiteur = '" + unStock.getUnVisiteur().getMatricule() +"'" 
					+"and refMedicament = '" +unStock.getUnMedicament().getDepotLegal()+"'";
		
		try {
			ResultSet res = ConnexionMySql.execReqSelection(req);
			if(res.next()){
				exist = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exist;
	}
	
}
