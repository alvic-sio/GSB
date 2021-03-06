package gsb.vue;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

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

public class JIFMedicamentListe extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Medicament> lesMedicaments;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTcodeMedicament;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;

	public JIFMedicamentListe(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// récupération des données Medicament dans la collection
		lesMedicaments = MedicamentDao.getLesMedicaments();

		int nbLignes = lesMedicaments.size();

		JTable table;
		
		

		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][4] ;
		for(Medicament unMedic : lesMedicaments){
			data[i][0] = unMedic.getDepotLegal();
			data[i][1] = unMedic.getNomCommercial();
			data[i][2] = unMedic.getLibellefamille();
			i++;
			}
		String[] columnNames = {"Code", "Nom","Famille"};
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTcodeMedicament = new JTextField(20);
		JTcodeMedicament.setMaximumSize(JTcodeMedicament.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche médicament");
		JBafficherFiche.addActionListener(this);
		JTcodeMedicament.addActionListener(this);
		pSaisie.add(JTcodeMedicament);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		// mise en forme de la fenêtre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
   		if (event.getSource() == JBafficherFiche  || event.getSource() == this.JTcodeMedicament){
   			Medicament unMedic = MedicamentDao.rechercher(JTcodeMedicament.getText());
   			if (unMedic!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedic));
   			}
   		}	
	}
		
}
