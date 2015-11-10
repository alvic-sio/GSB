package gsb.test;



import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;

public class MedecinDaoTest {
	public static void main(String[] args) {
		
		
		Medecin unMedecin = MedecinDao.rechercher("m001");
		System.out.println(unMedecin.getCodeMed());
		System.out.println(unMedecin.getNom());
		System.out.println(unMedecin.getPrenom());
		System.out.println(unMedecin.getAdresse());
		System.out.println(unMedecin.getCodePostal());
		System.out.println(unMedecin.getTelephone());
		System.out.println(unMedecin.getPotentiel());
		System.out.println(unMedecin.getSpecialite());
		System.out.println(unMedecin.getVille());
		

		Medecin unNouveauMedecin= new Medecin("m022", "henry", "hector" , "10 rue des plantes", "02-56-56-68-78", "" , "jambonniste", "56800","");
		System.out.println(MedecinDao.creer(unNouveauMedecin));
		
	
}
}
