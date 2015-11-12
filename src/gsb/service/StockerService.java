package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.StockerDao;

public class StockerService {
	/**
	 * les paramètres ne doivent pas être nuls
	 * @return 1 si l'insertion s'est bien déroulée, 0 sinon
	 * la vérification des paramètres d'entrée doit être effectuée avant l'insertion dans la base de données
	 */
	public static int ajouterStock(int qteStock,Visiteur unVisiteur,Medicament unMedicament){
		Stocker unStock;
		int resultat = 0;
		
		try{ // controle des paramètres d'entrée
			 // Si des données sont manquantes on lève une exception
	        if ( unVisiteur == null || unMedicament == null ) {
	            throw new Exception("Données obligatoire : visiteur, medicament");
	        }
	        if ( qteStock == 0 || qteStock < 0){
	        	throw new Exception("la quantité en stock doit être supérieur a 0");
	        }
	        unStock = new Stocker(qteStock,unVisiteur,unMedicament);
	        resultat = StockerDao.ajouterStock(unStock);
	     
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		
		return resultat;	
	}

}
