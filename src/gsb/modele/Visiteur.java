package gsb.modele;

import java.util.Date;

public class Visiteur {

	protected String matricule;
	protected String nom;
	protected String prenom;
	protected String login;
	protected String mdp;
	protected String adresse;
	protected String telephone;
	protected Date dateEntree;
	protected int prime;
	protected String codeUnite;
	protected String nomUnite;

	public Visiteur(String matricule, String nom, String prenom, String login,
			String mdp, String adresse, String telephone, Date dateEntree,
			int prime, String codeUnite, String nomUnite) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateEntree = dateEntree;
		this.prime = prime;
		this.codeUnite = codeUnite;
		this.nomUnite = nomUnite;
	}

	
	/**
	 * @return Renvoie le matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule matricule à définir
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return Renvoie le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom nom à définir
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return Renvoie le prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom prenom à définir
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return Renvoie le login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login login à définir
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return Renvoie le mot de passe
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp mod de passe à définir
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return Renvoie l'adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse adresse à définir
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return Renvoie le numero de telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone telephone à définir
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return Renvoie la date d'entree
	 */
	public Date getDateEntree() {
		return dateEntree;
	}

	/**
	 * @param dateEntree dateEntree à définir
	 */
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	/**
	 * @return Renvoie la prime
	 */
	public int getPrime() {
		return prime;
	}

	/**
	 * @param prime prime à définir
	 */
	public void setPrime(int prime) {
		this.prime = prime;
	}
	
	/**
	 * @return Renvoie le code unité
	 */
	public String getCodeUnite() {
		return codeUnite;
	}

	/**
	 * @param codeUnite codeUnite à définir
	 */
	public void setCodeUnite(String codeUnite) {
		this.codeUnite = codeUnite;
	}

	/**
	 * @return Renvoie le nom unité
	 */
	public String getNomUnite() {
		return nomUnite;
	}

	/**
	 * @param nomUnite nomUnite à définir
	 */
	public void setNomUnite(String nomUnite) {
		this.nomUnite = nomUnite;
	}

	
	
}
