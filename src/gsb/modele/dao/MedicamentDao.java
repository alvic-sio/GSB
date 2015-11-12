package gsb.modele.dao;

import gsb.modele.Medicament;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MedicamentDao {
	
	
	/**
	 * @param depoLegal le depotLegal
	 * @return med le Medicament demander sinon null
	 */
	public static Medicament rechercher(String depoLegal){
		Medicament med = null;
		
		String requeteMedic = "SELECT * "
				+ "FROM medicament, famille "
				+ "WHERE MED_DEPOTLEGAL='"+depoLegal+"'"
				+ "AND medicament.FAM_CODE = famille.FAM_CODE;";
		
		try {
			ResultSet res = ConnexionMySql.execReqSelection(requeteMedic);

			if(res.next()){
				
				med = new Medicament(
						res.getString(1), // depotLegal
						res.getString(2), // nomCommercial
						res.getString(4), // composition
						res.getString(5), // effets
						res.getString(6), // contreIndication
						res.getFloat(7),  // prixEchantillon
						res.getString(3), // codeFamille
						res.getString(9)  // libelleFamille
					);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ConnexionMySql.fermerConnexionBd();
		
		return med;	
	}
	
	/**
	 * Ajoute un medicament en base de données
	 * @param medicament le medicament à ajouter
	 * @return 1 si la création s'est bien passé, 0 sinon
	 */
	public static int creer(Medicament medicament){
		int retourVal = 0;

		String depotLegal 	= medicament.getDepotLegal();
		String nomCom		= medicament.getNomCommercial();
		String compo		= medicament.getComposition();
		String effets		= medicament.getEffets();
		String ContreIndic	= medicament.getContreIndication();
		float prixEchant	= medicament.getPrixEchantillon();
		String codeFamille	= medicament.getCodeFamille();
		
		String requete = "insert into medicament values("
				+"'"+depotLegal	+"' ,"
				+"'"+nomCom		+"' ,"
				+"'"+codeFamille+"' ,"
				+"'"+compo		+"' ,"
				+"'"+effets		+"' ,"
				+"'"+ContreIndic+"' ,"
				+"'"+prixEchant	+"' );";
		
		if(!familleExsiste(codeFamille)){
			creerFamille(codeFamille, medicament.getLibellefamille());
		}
		
		try {
			retourVal = ConnexionMySql.execReqMaj(requete);
			ConnexionMySql.fermerConnexionBd();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return retourVal;
	}
	
	
	/**
	 * Supprime un medicament de la base de données
	 * @param depotLegal
	 * @return 1 si suppression bien déroulée, 0 sinon
	 */
	public static int supprimer(String depotLegal){
		
		int retourVal = 0;
		
		if(medicamentExiste(depotLegal)){
			String requete = "DELETE FROM medicament where MED_DEPOTLEGAL='"+depotLegal+"';";
			try {
				retourVal = ConnexionMySql.execReqMaj(requete);
				ConnexionMySql.fermerConnexionBd();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			retourVal = 0;
		}
		
		
		return retourVal;
	}
	
	/**
	 * Retourne si un medicament existe dans la base de données ou non
	 * @param depotLegal
	 * @return true si existe, false sinon
	 */
	public static boolean medicamentExiste(String depotLegal){
		boolean existe = false;
		
		String req = "select MED_DEPOTLEGAL from medicament where MED_DEPOTLEGAL='"+depotLegal+"'";
		
		try {
			ResultSet res = ConnexionMySql.execReqSelection(req);
			if(res.next()){
				existe = true;
			}
			ConnexionMySql.fermerConnexionBd();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return existe;
	}
	
	/**
	 * @return medicaments la liste des medicaments
	 */
	public static ArrayList<Medicament> getLesMedicaments(){
		
		ArrayList<Medicament> medicaments = null;
		
		try {
			medicaments = new ArrayList<Medicament>();
			String requete = "select * from medicament, famille where medicament.FAM_CODE = famille.FAM_CODE";
			ResultSet res = ConnexionMySql.execReqSelection(requete);

			while(res.next()){
				medicaments.add(new Medicament(
						res.getString(1), // depotLegal
						res.getString(2), // nomCommercial
						res.getString(4), // composition
						res.getString(5), // effets
						res.getString(6), // contreIndication
						res.getFloat(7),  // prixEchantillon
						res.getString(3), // codeFamille
						res.getString(9)  // libelleFamille
					));
			}
			
			ConnexionMySql.fermerConnexionBd();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return medicaments;
	}
	
	
	/**
	 * Retourne si une famille existe
	 * @param codeFamille
	 * @return true si existe, false sinon
	 */
	public static boolean familleExsiste( String codeFamille ){
		boolean exist = false;
		
		String req = "select * from famille where FAM_CODE = '"+ codeFamille +"';";
		
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
	 * Creer une nouvelel famille dans la BDD
	 * @param codeFamille 
	 * @param libFamille
	 * @return 1 si bien passé, 0 sinon
	 */
	public static int creerFamille(String codeFamille, String libFamille){
		int ret = 0;
		
		if(!familleExsiste(codeFamille)){
			String requete = "insert into famille values ("
					+ "'"+ codeFamille +"',"
					+ "'"+ libFamille  +"');";
			try {
				ret = ConnexionMySql.execReqMaj(requete);
				ConnexionMySql.fermerConnexionBd();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}

}
