package gsb.vue;

import gsb.modele.Medicament;

public class JIFMedicamentFiche extends JIFMedicament{
	
	private static final long serialVersionUID = 1L;

	public JIFMedicamentFiche(Medicament unMedicament){
		super();
//		this.viderText();
		this.remplirText(unMedicament);
	}
}
