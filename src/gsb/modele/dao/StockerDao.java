package gsb.modele.dao;

import gsb.modele.Stocker;
import gsb.modele.Visiteur;

import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	/**
	 * Renvoit la listes des stock concernant un visiteur
	 * @param matriculeVisiteur le matricule du visiteur concerné
	 * @return la liste des stocks, sinon null
	 */
	public static ArrayList<Stocker> rechercherStocks( String matriculeVisiteur ){
		ArrayList<Stocker> stocks = new ArrayList<Stocker>();
		
		String requete = "select * from stocker where refVisiteur = '"+matriculeVisiteur+"';";
		
		try {
			ResultSet res = ConnexionMySql.execReqSelection(requete);
			while(res.next()) {
				stocks.add(new Stocker(res.getInt(1), VisiteurDao.rechercher(res.getString(2)),
						MedicamentDao.rechercher(res.getString(3))));
			}
		} catch (Exception e) {
			
		}
		
		return stocks;
	}

	/**
	 * Retourne la liste des stocks
	 * @param max le nombre de stock max à renvoyer
	 * @return la liste des stocks
	 */
	public static ArrayList<Stocker> getLesStock( int max ){
		if(max < 0){
			max = 0;
		}
		ArrayList<Stocker> stocks = new ArrayList<Stocker>();
		
		String requete = "select * from stocker LIMIT "+ max +";";
		
		try {
			ResultSet res = ConnexionMySql.execReqSelection(requete);
			while(res.next()) {
				stocks.add(new Stocker(res.getInt(1), VisiteurDao.rechercher(res.getString(2)),
						MedicamentDao.rechercher(res.getString(3))));
			}
		} catch (Exception e) {
			
		}
		
		return stocks;
	}
	
}
