package gsb.vue;

import gsb.service.StockerService;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFAjoutStock extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	protected JLabel JLcodeVisiteur;
	protected JLabel JLdepotLegal;
	protected JLabel JLqte;
	
	protected JTextField JTcodeVisiteur;
	protected JTextField JTdepotLegal;  
	protected JTextField JTqte;         
	
	protected JButton JBajouter;
	
	protected JPanel p;
	protected GridBagConstraints gridConst ;
	protected MenuPrincipal menuPrincipal;
	
	public JIFAjoutStock(MenuPrincipal menuPrincipal){
		this.menuPrincipal = menuPrincipal;
		p = new JPanel();
		p.setLayout(new GridBagLayout());
		gridConst = new GridBagConstraints();
		
		JBajouter = new JButton("Ajouter");
		
		JLcodeVisiteur 	= new JLabel("Code Visiteur :", JLabel.LEFT);
		JLdepotLegal  	= new JLabel("Depot Legal :", JLabel.LEFT);  
		JLqte  			= new JLabel("Quantité :", JLabel.LEFT);         

		JTcodeVisiteur 	= new JTextField(20);
		JTdepotLegal 	= new JTextField(20);  
		JTqte 			= new JTextField(20);         
		
		gridConst.gridx = 0;
		gridConst.gridy = 0;
		p.add(JLcodeVisiteur, gridConst );
		gridConst.gridx = 1;
		gridConst.gridy = 0;
		p.add(JTcodeVisiteur, gridConst );
		
		gridConst.gridx = 0;
		gridConst.gridy = 1;
		p.add(JLdepotLegal, gridConst );
		gridConst.gridx = 1;
		gridConst.gridy = 1;
		p.add(JTdepotLegal, gridConst );

		gridConst.gridx = 0;
		gridConst.gridy = 2;
		p.add(JLqte, gridConst );
		
		gridConst.gridx = 1;
		gridConst.gridy = 2;
		p.add(JTqte, gridConst );
		
		gridConst.gridx = 1;
		gridConst.gridy = 3;
		p.add(JBajouter, gridConst );
		
		JBajouter.addActionListener(this);
		this.setContentPane(p);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == JBajouter){
			String qte = JTqte.getText();
			String matricule = JTcodeVisiteur.getText();
			String depotLegal = JTdepotLegal.getText();
			
			int status = StockerService.ajouterStock(Integer.parseInt(qte), matricule, depotLegal);
		
			if(status == 1){
				menuPrincipal.ouvrirFenetre(new JIFStockListe(matricule));
			}
		}
		
	}
	
}
