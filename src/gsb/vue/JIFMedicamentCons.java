package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class JIFMedicamentCons extends JIFMedicament implements ActionListener {


	private static final long serialVersionUID = 1L;

	private JButton premier;
    private JButton suivant;
    private JButton precedent; 
    private JButton dernier; 
    private ArrayList<Medicament> lesMedicaments;
	private int indiceEnCours;
	
	public JIFMedicamentCons() {
	      super();
	        premier = new JButton("Premier");
	        pBoutons.add(premier);
	        suivant = new JButton("Suivant");
	        pBoutons.add(suivant);
	        precedent = new JButton("Precedent");
	        pBoutons.add(precedent);
	        dernier = new JButton("Dernier");
	        pBoutons.add(dernier);

	        premier.addActionListener(this);
	        suivant.addActionListener(this);
	        precedent.addActionListener(this);
	        dernier.addActionListener(this);
	        setDefaultCloseOperation(HIDE_ON_CLOSE);
	        setTitle("Consultation Medicaments");
	 
	        lesMedicaments = MedicamentDao.getLesMedicaments();
	        
	        if (lesMedicaments.size()!=0){ // si collection non vide, affichage des données du premier Medecin
	        	Medicament leMedicament= lesMedicaments.get(0);
	        	remplirText(leMedicament);
		    	
	    	}
	        
	}
	
	 public void actionPerformed(ActionEvent evt) { 
			Object source = evt.getSource();
	   		if (source == premier){
				indiceEnCours = 0;
				Medicament leMedecin = lesMedicaments.get(indiceEnCours);
		    	remplirText(leMedecin);				
			 } else if (source == dernier){
				indiceEnCours = lesMedicaments.size() - 1;
				Medicament leMedecin = lesMedicaments.get(indiceEnCours);
		    	remplirText(leMedecin);
			} else if (source == precedent){
				if (indiceEnCours > 0) indiceEnCours = indiceEnCours - 1;
				Medicament leMedecin = lesMedicaments.get(indiceEnCours);
		    	remplirText(leMedecin);
	    	} else if (source == suivant){
				if (indiceEnCours < (lesMedicaments.size() - 1)) indiceEnCours = indiceEnCours + 1;
				Medicament leMedecin = lesMedicaments.get(indiceEnCours);
		    	remplirText(leMedecin);		    	
	    	}
	 } 
}
