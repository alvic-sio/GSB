package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;

public class StockerService {
	
	/**
	 * Ajoute une entré dans les stocks
	 * @param qte quantité de l'échantillont
	 * @param matricule le matricule du visiteur concerné
	 * @param depotLegal le depot legal du medicament entré
	 * @return 1 si bien déroulé, 0 sinon
	 */
	public static int ajouterStock( int qte, String matricule, String depotLegal){
		int status = 0;
		
		try {
			if(matricule == null || depotLegal == null){
				throw new Exception("Arguments null");
			} if( !VisiteurDao.existe(matricule) ){
				throw new Exception("le visiteur en parametre n'existe pas");
			} if( !MedicamentDao.medicamentExiste(depotLegal)){
				throw new Exception("le medicament en parametre n'existe pas");
			}
			
			Medicament med = MedicamentDao.rechercher(depotLegal);
			Visiteur vis = VisiteurDao.rechercher(matricule);
			
			StockerDao.ajouterStock(new Stocker(qte, vis, med));
			
			status = 1;
			
		} catch (Exception e) {
			System.err.println("Erreur ajout stock : " + e.getMessage());
		}
		
		return status;
	}
}
