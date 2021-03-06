package gsb.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2591453837113855452L;

	public static final Dimension SIZE = new Dimension(480, 380);
	
	protected JInternalFrame myJInternalFrame;
	protected JDesktopPane desktopPane;
	protected JMenuBar mbar;
	protected JMenu mMedecins;
	protected JMenu mMedicaments;

	JMenu mVisites;

	public MenuPrincipal() {

		myJInternalFrame = new JInternalFrame(); // pour affichage d'une seule
													// JInternalFrame à la fois
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0xAAAAFF));
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		setTitle("GSB");
		setSize(SIZE);

		// Ajout d'une barre de menus à la fenêtre
		mbar = new JMenuBar();
		mMedecins = new JMenu("Medecins");
		JMenuItem mC1 = new JMenuItem("Consultation Medecin");
		mC1.addActionListener(this); // installation d'un écouteur d'action
		mMedecins.add(mC1);
		JMenuItem mC2 = new JMenuItem("Liste Medecins");
		mC2.addActionListener(this);
		mMedecins.add(mC2);

		mMedicaments = new JMenu("Medicaments");
		
		JMenuItem mE3 = new JMenuItem("Liste Medicaments");
		mE3.addActionListener(this);
		mMedicaments.add(mE3);

		JMenuItem mE5 = new JMenuItem("Consultation Medicaments");
		mE5.addActionListener(this);
		mMedicaments.add(mE5);

		
		JMenuItem mE2 = new JMenuItem("Stock Echantillons");
		mE2.addActionListener(this);
		mMedicaments.add(mE2);

		JMenuItem mE4 = new JMenuItem("Ajout Echantillon");
		mE4.addActionListener(this);
		mMedicaments.add(mE4);
//		
//		mVisites = new JMenu("Visites");
//		JMenuItem mA1 = new JMenuItem("Consultation Visite");
//		mVisites.add(mA1);
//		JMenuItem mA2 = new JMenuItem("Ajout Visite");
//		mA2.addActionListener(this);
//		mVisites.add(mA2);

		mbar.add(mMedecins);
		mbar.add(mMedicaments);
//		mbar.add(mVisites);
		setJMenuBar(mbar);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Raccord de méthode auto-généré
		if (evt.getSource() instanceof JMenuItem) {
			String ChoixOption = evt.getActionCommand();
			
			if (ChoixOption.equals("Consultation Medecin")) {
				// Creation d'une sous-fenêtre
				ouvrirFenetre(new JIFMedecinCons());

			} else if (ChoixOption.equals("Liste Medecins")) {
				ouvrirFenetre(new JIFMedecinListeCol(this));
			} else if(ChoixOption.equals("Liste Medicaments")){
				ouvrirFenetre(new JIFMedicamentListe(this));
			} else if(ChoixOption.equals("Stock Echantillons")){
				ouvrirFenetre(new JIFStockListe());
			} else if(ChoixOption.equals("Ajout Echantillon")){
				ouvrirFenetre(new JIFAjoutStock(this));
			} else if(ChoixOption.equals("Consultation Medicaments")){
				ouvrirFenetre(new JIFMedicamentCons());
			}

		}

	}

	public void ouvrirFenetre(JInternalFrame uneFenetre) {
		myJInternalFrame.dispose(); // si une fenêtre était dejà affichée, elle
									// est libérée
		myJInternalFrame = uneFenetre;
		myJInternalFrame.setVisible(true);
		myJInternalFrame.setResizable(true);
		myJInternalFrame.setMaximizable(true);
		myJInternalFrame.setClosable(true);
		myJInternalFrame.setSize(SIZE);
		desktopPane.add(myJInternalFrame);
	}


}
