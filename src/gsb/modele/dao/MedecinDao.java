package gsb.modele.dao;


import gsb.modele.Medecin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * @author Isabelle
 * 22 f�vr. 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class MedecinDao {
	
	public static Medecin rechercher(String codeMedecin){
		Medecin unMedecin=null;
		String req = "select * from MEDECIN,LOCALITE where MEDECIN.CODEPOSTAL = LOCALITE.CODEPOSTAL and CODEMED ='"+codeMedecin+"'";

		ResultSet reqSelection = ConnexionMySql.execReqSelection(req);
		try {
			if (reqSelection.next()) {
				unMedecin = new Medecin(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8), reqSelection.getString(9), reqSelection.getString(10) );
			}
		} catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from MEDECIN where CODEMED ='"+codeMedecin+"'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unMedecin;
	}
	
	public static ArrayList<Medecin> retournerCollectionDesMedecins(){
		ArrayList<Medecin> collectionDesMedecins = new ArrayList<Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select CODEMED from MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMedecin = reqSelection.getString(1);
		    collectionDesMedecins.add(MedecinDao.rechercher(codeMedecin));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedecins()");
		}
		return collectionDesMedecins;
	}
	
	public static HashMap<String,Medecin> retournerDictionnaireDesMedecins(){
		HashMap<String, Medecin> diccoDesMedecins = new HashMap<String, Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select CODEMED from MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMedecin = reqSelection.getString(1);
		    diccoDesMedecins.put(codeMedecin, MedecinDao.rechercher(codeMedecin));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedecins()");
		}
		return diccoDesMedecins;
	}
	

	/**
	 * @param unMedecin permet d�ins�rer un nouveau enregistrement medecin dans la table Medecin
	 * @return 1 si l'insertion s'est bien d�roul�e, 0 sinon
	 */
	public static int creer(Medecin unMedecin){
		
		int result = 0;
		String requeteInsertion;
		String CODEMED= unMedecin.getCodeMed();
		String NOM = unMedecin.getNom();
		String PRENOM = unMedecin.getPrenom();
		String ADRESSE =  unMedecin.getAdresse();
		String CODEPOSTAL = unMedecin.getCodePostal();
		String TELEPHONE =  unMedecin.getTelephone();
		String POTENTIEL = unMedecin.getPotentiel();
		String SPECIALITE = unMedecin.getSpecialite();
		String VILLE = unMedecin.getVille();
		requeteInsertion = "insert into MEDECIN values('"+CODEMED+"','"+NOM+"','"+PRENOM+"','"+ADRESSE+"','"+CODEPOSTAL+"','"+TELEPHONE+"','"+POTENTIEL+"','"+SPECIALITE+"')";
		System.out.println(requeteInsertion);
		try{
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch(Exception e){
			System.out.println("echec insertion Medecin");
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}

	/**
	 * @param CODEMED cl� de l'enregistrement � supprimer dans la table Medecin
	 * @return 1 si la suppression s'est bien d�roul�e, 0 sinon
	 * methode qui permet de supprime un enregistrement dans la table Medecin correspondant au CODEMED (codemedecin) pass� en param�tre
	 */
	public static int supprimer(String CODEMED){
		String requeteSuppression = "delete from MEDECIN where CODEMED='"+CODEMED+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;	
	}
	/**
	 * @param Medecin
	 * @return 1 si la modification s'est bien d�roul�e, 0 sinon
	 * methode qui permet de modificer les valeurs d'un enregistrement dans la table Medecin correspondant au CODEMED pass� en param�tre
	 */

	

}
