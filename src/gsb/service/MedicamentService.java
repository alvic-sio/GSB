package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {

	/**
	 * depotLegal 	: ne doit etre ni null ni vide et contient 10 characteres maximum<br>
	 * nomCom		: ne doit etre ni null ni vide et contient 25 characteres maximum<br>
	 * effets		: ne doit etre ni null ni vide et contient 255 characteres maximum<br>
	 * prixEch 		: ne doit pas être négatif<br>
	 * codeFam 		: ne doit etre ni null ni vide et contient 3 characteres maximum<br>
	 * libFam		: ne doit etre ni null ni vide et contient 80 characteres maximum<br>
	 * @param unMedicament
	 * @return 1 si bien passé, 0 sinon
	 */
	public static int creerMedicament( String depotLegal, String nomCom, String composition, String effets, String contreIndic, float prixEch, String codeFam, String libFam ){
		int ret = 0;
		Medicament medic;
		
		try {
		
			if( depotLegal == null || depotLegal.length() > 10  || depotLegal.length() < 1){
				throw new Exception("format de depotLegal");
			}
			
			if(MedicamentDao.medicamentExiste(depotLegal)){
				throw new Exception("le medicament existe dèja dans la BDD");
			}
			
			if( nomCom == null || nomCom.length() > 25  || nomCom.length() < 1){
				throw new Exception("format de nomCom");
			}
			
			if( effets == null || effets.length() > 255  || effets.length() < 1){
				throw new Exception("format de effets");
			}

			if( composition == null || composition.length() > 255 || composition.length() < 1){
				throw new Exception("format de composition");
			}

			if( contreIndic == null || contreIndic.length() > 255  || contreIndic.length() < 1){
				throw new Exception("format de contreIndic");
			}
			
			if( prixEch < 0 ){
				throw new Exception("format de prixEch");
			}
			
			if( codeFam == null || codeFam.length() > 3 || codeFam.length() < 1){
				throw new Exception("format de codeFam");
			}
			
			if( libFam == null || libFam.length() > 80 || libFam.length() < 1){
				throw new Exception("format de libFam");
			}
			
			
			if( contreIndic == null || contreIndic.length() > 255 || contreIndic.length() < 1){
				throw new Exception("format de ContreIndic");
			}
			
			medic = new Medicament(depotLegal, nomCom, composition, effets, contreIndic, prixEch, codeFam, libFam);
			MedicamentDao.creer(medic);
			
		} catch (Exception e) {
			System.err.println("Erreur creation Medicament : " + e.getMessage());
		}
		
		
		return ret;
	}
}
