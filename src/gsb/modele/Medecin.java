package gsb.modele;

public class Medecin {
	protected String codeMed ;
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String telephone;
	protected String potentiel;
	protected String specialite;
	protected String codePostal;
	protected String ville;
	/**
	 * @param codeMed
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param laLocalite
	 * @param telephone
	 * @param potentiel
	 * @param specialite
	 */
	public Medecin(String codeMed, String nom, String prenom,
			String adresse, String telephone,
			String potentiel, String specialite,String codePostal,String ville) {
		this.codeMed = codeMed;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.potentiel = potentiel;
		this.specialite = specialite;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	/**
	 * @return Renvoie codeMed.
	 */
	public String getCodeMed() {
		return codeMed;
	}
	/**
	 * @param codeMed codeMed à définir.
	 */
	public void setCodeMed(String codeMed) {
		this.codeMed = codeMed;
	}
	/**
	 * @return Renvoie nom.
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom nom à définir.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return Renvoie prenom.
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom prenom à définir.
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return Renvoie adresse.
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse adresse à définir.
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return Renvoie telephone.
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone telephone à définir.
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return Renvoie potentiel.
	 */
	public String getPotentiel() {
		return potentiel;
	}
	/**
	 * @param potentiel potentiel à définir.
	 */
	public void setPotentiel(String potentiel) {
		this.potentiel = potentiel;
	}
	/**
	 * @return Renvoie specialite.
	 */
	public String getSpecialite() {
		return specialite;
	}
	/**
	 * @param specialite specialite à définir.
	 */
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	/**
	 * @return Renvoie le code postal.
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param String codePostal à définir.
	 */
	public void setCodePostal(String codePostal){
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	

}
