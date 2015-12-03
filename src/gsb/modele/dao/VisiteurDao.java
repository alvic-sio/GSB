package gsb.modele.dao;

import gsb.modele.Visiteur;

import java.sql.ResultSet;

public class VisiteurDao {
	
	/**
	 * Retourne le Visiteur du matricule demandé
	 * @param matricule du visiteur concerné
	 * @return le Visiteur, null sinon
	 */
	public static Visiteur rechercher( String matricule ){
		Visiteur visiteur = null;
		
		String requete = "select * from VISITEUR where MATRICULE='" + matricule + "'";
		
		try {
			ResultSet res = ConnexionMySql.execReqSelection(requete);
			if(res.next()){
				
				visiteur = new Visiteur(
						res.getString(1), 	// matricule
						res.getString(2), 	// nom
						res.getString(3), 	// prenom
						res.getString(4), 	// login
						res.getString(5), 	// mdp
						res.getString(6), 	// adresse
						res.getString(7), 	// telephone
						res.getDate(9), 	// dateEntree
						res.getInt(10),		// prime
						res.getString(11), 	// coedUnite
						getNomUnite(res.getString(11)) // nom unite
					);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return visiteur;
	}
	
	/**
	 * @param codeUnite l'unité concernée
	 * @return le nom de l'unité, null sinon
	 */
	public static String getNomUnite( String codeUnite){
		String nom = null;
		
		String req = "select * from UNITE where CODEUNIT = '"+ codeUnite +"'";
		
		try {
			ResultSet res = ConnexionMySql.execReqSelection(req);
			if(res.next()){
				nom = res.getString(2);
			}
			
			ConnexionMySql.fermerConnexionBd();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nom;
	}
	
	/**
	 * Retourne si un visiteur existe ou pas
	 * @param matricule du visiteur
	 * @return true si existe, false sinon
	 */
	public static boolean existe( String matricule ){
		boolean existe = false;
		
		String req = "select * from VISITEUR where MATRICULE='" + matricule + "';";
		
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

}
