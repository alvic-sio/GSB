package gsb.vue;

import gsb.modele.Medicament;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFMedicament  extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;

	protected JLabel JLdepotLegal;
	protected JLabel JLnomCommercial;
	protected JLabel JLcomposition;
	protected JLabel JLeffets;
	protected JLabel JLconteIndication;
	protected JLabel JLcodeFamille;
	protected JLabel JLlibelleFamille;

	protected JTextField JTdepotLegal;
	protected JTextField JTnomCommercial;
	protected JTextField JTcomposition;
	protected JTextField JTeffets;
	protected JTextField JTcontreIndication;
	protected JTextField JTcodeFamille;
	protected JTextField JTlibelleFamille;

	public JIFMedicament() {
		p = new JPanel();
		p.setMaximumSize(this.getPreferredSize());
		pBoutons = new JPanel();
		pTexte = new JPanel();
		pTexte.setMaximumSize(p.getPreferredSize());
		pTexte.setLayout(new GridLayout(7,2, 10, 0));
		
		JLdepotLegal 		= new JLabel("Depot legal");
		JLnomCommercial 	= new JLabel("Nom commercial");
		JLcomposition 		= new JLabel("Composition");
		JLeffets 			= new JLabel("Effets");
		JLconteIndication 	= new JLabel("Contre indications");
		JLcodeFamille 		= new JLabel("Code famille");
		JLlibelleFamille 	= new JLabel("Libelle famille");

		JTdepotLegal 		= new JTextField(20);
		JTnomCommercial 	= new JTextField(20);
		JTcomposition 		= new JTextField(20);
		JTeffets 			= new JTextField(20);
		JTcontreIndication 	= new JTextField(20);
		JTcodeFamille 		= new JTextField(20);
		JTlibelleFamille 	= new JTextField(20);
		
		
		pTexte.add(JLdepotLegal);
		pTexte.add(JTdepotLegal);
		pTexte.add(JLnomCommercial);
		pTexte.add(JTnomCommercial);
		pTexte.add(JLcomposition);
		pTexte.add(JTcomposition);
		pTexte.add(JLeffets);
		pTexte.add(JTeffets);
		pTexte.add(JLconteIndication);
		pTexte.add(JTcontreIndication);
		pTexte.add(JLcodeFamille);
		pTexte.add(JTcodeFamille);
		pTexte.add(JLlibelleFamille);
		pTexte.add(JTlibelleFamille);


		p.add(pTexte);
		p.add(pBoutons);
		Container contentPane = getContentPane();	
		contentPane.add(p);

	}

	public void remplirText(Medicament unMedicament) {  
		JTdepotLegal.setText(unMedicament.getDepotLegal());        
		
		JTnomCommercial.setText(unMedicament.getNomCommercial());
		JTnomCommercial.setCaretPosition(0);	// Ajuste le texte à gauche
		
		JTcomposition.setText(unMedicament.getComposition());
		JTcomposition.setCaretPosition(0);
		
		JTeffets.setText(unMedicament.getEffets());
		JTeffets.setCaretPosition(0);
		
		JTcontreIndication.setText(unMedicament.getContreIndication());
		JTcontreIndication.setCaretPosition(0);
		
		JTcodeFamille.setText(unMedicament.getCodeFamille());
		JTlibelleFamille.setText(unMedicament.getLibellefamille());
	}

	public void viderText() {   
		JTdepotLegal.setText("");
		JTnomCommercial.setText("");
		JTcomposition.setText("");
		JTeffets.setText("");
		JTcontreIndication.setText("");
		JTcodeFamille.setText("");
		JTlibelleFamille.setText("");
	}




}
