package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Medicament;

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
						res.getString(8)  // libelleFamille
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
		int retourVal = 1;
	
		if(medicamentExiste(medicament.getDepotLegal())){
			System.err.println("Erreur insert medicament : Le medicament existe déja en base de données");
			retourVal = 1;
		} else {

			String depotLegal 	= medicament.getDepotLegal();
			String nomCom		= medicament.getNomCommercial();
			String compo		= medicament.getComposition();
			String effets		= medicament.getEffets();
			String ContreIndic	= medicament.getContreIndication();
			float prixEchant	= medicament.getPrixEchantillon();
			String codeFamille	= medicament.getCodeFamille();
			String libelleFam	= medicament.getLibellefamille();
			
			String requete = "insert into medicament values("
					+"'"+depotLegal	+"' ,"
					+"'"+nomCom		+"' ,"
					+"'"+codeFamille+"' ,"
					+"'"+compo		+"' ,"
					+"'"+effets		+"' ,"
					+"'"+ContreIndic+"' ,"
					+"'"+prixEchant	+"' );";
			
			try {
				retourVal = ConnexionMySql.execReqMaj(requete);
			} catch (Exception e) {
				e.printStackTrace();
			}		
			
		}
		
		
		return retourVal;
	}
	
	
	/**
	 * Retourne si un medicament existe dans la base de données ou non
	 * @param depoLegal
	 * @return true si existe, false sinon
	 */
	public static boolean medicamentExiste(String depoLegal){
		boolean existe = false;
		
		String req = "select MED_DEPOTLEGAL from medicament where MED_DEPOTLEGAL='"+depoLegal+"'";
		
		try {
			ResultSet res = ConnexionMySql.execReqSelection(req);
			if(res.next()){
				existe = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return existe;
	}
	

}
