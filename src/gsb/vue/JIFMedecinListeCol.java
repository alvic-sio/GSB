/*
 * Cr�� le 3 mars 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author Isabelle
 * 3 mars 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class JIFMedecinListeCol extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ArrayList<Medecin> lesMedecins;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeMedecin;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;

	public JIFMedecinListeCol(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// r�cup�ration des donn�es Medecin dans la collection
		lesMedecins = MedecinDao.retournerCollectionDesMedecins();

		int nbLignes = lesMedecins.size();

		JTable table;
		
		

		p = new JPanel(); // panneau principal de la fen�tre

		int i=0;
		String[][] data = new String[nbLignes][4] ;
		for(Medecin unMedecin : lesMedecins){
			data[i][0] = unMedecin.getCodeMed();
			data[i][1] = unMedecin.getNom();
			data[i][2] = unMedecin.getPrenom();
			data[i][3] = unMedecin.getVille() ;
			i++;
			}
		String[] columnNames = {"Code", "Nom","Prenom","Ville"};
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeMedecin = new JTextField(20);
		JTcodeMedecin.setMaximumSize(JTcodeMedecin.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche m�decin");
		JBafficherFiche.addActionListener(this);
		pSaisie.add(JTcodeMedecin);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		// mise en forme de la fen�tre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			Medecin unMedecin = MedecinDao.rechercher(JTcodeMedecin.getText());
   			if (unMedecin!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFMedecinFiche(unMedecin));
   			}
   		}	
	}
}