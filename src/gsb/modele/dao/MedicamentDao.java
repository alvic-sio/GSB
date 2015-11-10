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
	

}
