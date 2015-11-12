package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.Visiteur;
import gsb.modele.dao.StockerDao;

public class StockerService {
	/**
	 * les param�tres ne doivent pas �tre nuls
	 * @return 1 si l'insertion s'est bien d�roul�e, 0 sinon
	 * la v�rification des param�tres d'entr�e doit �tre effectu�e avant l'insertion dans la base de donn�es
	 */
	public static int ajouterStock(int qteStock,Visiteur unVisiteur,Medicament unMedicament){
		Stocker unStock;
		int resultat = 0;
		
		try{ // controle des param�tres d'entr�e
			 // Si des donn�es sont manquantes on l�ve une exception
	        if ( unVisiteur == null || unMedicament == null ) {
	            throw new Exception("Donn�es obligatoire : visiteur, medicament");
	        }
	        if ( qteStock == 0 || qteStock < 0){
	        	throw new Exception("la quantit� en stock doit �tre sup�rieur a 0");
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
