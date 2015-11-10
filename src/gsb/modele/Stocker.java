package gsb.modele;

public class Stocker {
	
	protected int qteStock;
	protected Visiteur  unVisiteur;
	protected Medicament unMedicament;
	
	public Stocker(int qteStock, Visiteur unVisiteur, Medicament unMedicament) {
		super();
		this.qteStock = qteStock;
		this.unVisiteur = unVisiteur;
		this.unMedicament = unMedicament;
	}

	/**
	 * @return la quantité en stock
	 */
	public int getQteStock() {
		return qteStock;
	}

	/**
	 * @param qteStock la quantité en stock à définir
	 */
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	/**
	 * @return le visiteur
	 */
	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}

	/**
	 * @param unVisiteur le visiteur à définir
	 */
	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}

	/**
	 * @return le medicament
	 */
	public Medicament getUnMedicament() {
		return unMedicament;
	}

	/**
	 * @param unMedicament medicament à définir
	 */
	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}
	
	
	
	
}
