package gsb.vue;

import gsb.modele.Medicament;
import gsb.modele.Stocker;
import gsb.modele.dao.StockerDao;
import gsb.modele.dao.VisiteurDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JIFStockListe extends JInternalFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JLabel JLcodeVisiteur;
	protected JTable JTBLlisteStock;
	protected JTextField JTcodeVisiteur;
	protected JButton JBrechercher;
	
	protected GridBagConstraints gridConst;
	
	public JIFStockListe( String matricule ){
		
		p = new JPanel(new GridBagLayout());
		gridConst = new GridBagConstraints();
		
		JLcodeVisiteur = new JLabel("Code visiteur");
		JTcodeVisiteur = new JTextField(10);
		JBrechercher = new JButton("Rechercher");
		JTBLlisteStock = new JTable();
		
		
		//	Label code Visiteur
		gridConst.fill = GridBagConstraints.HORIZONTAL;
		gridConst.weightx = 1;
		gridConst.gridx = 0;
		gridConst.gridy = 0;
		p.add(JLcodeVisiteur, gridConst);
		
		// Champs de text Code Visteur
		gridConst.weightx = 1;
		gridConst.gridx = 1;
		gridConst.gridy = 0;
		gridConst.ipadx = 6;
		p.add(JTcodeVisiteur, gridConst);
		
		// Bouton rechercher
		gridConst.weightx = 1;
		gridConst.gridx = 2;
		gridConst.gridy = 0;
		p.add(JBrechercher, gridConst);
		
		// Liste des stocks
		scrollPane = new JScrollPane(JTBLlisteStock);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		gridConst.anchor = GridBagConstraints.CENTER;
		gridConst.gridx = 0;
		gridConst.gridy = 1;
		gridConst.gridwidth = 3;
		gridConst.gridheight = 4;
		gridConst.ipady = 60;
		p.add(scrollPane, gridConst);

		
		JTcodeVisiteur.addActionListener(this);
		JBrechercher.addActionListener(this);
		
		if(matricule == null){
			fillTable(StockerDao.getLesStock(10));			
		} else {
			fillTable(StockerDao.rechercherStocks(matricule));
		}
		
		Container contentPane = getContentPane();
		contentPane.add(p);
	}
	
	public JIFStockListe(){
		this(null);
	}
	
	/**
	 * Met a jour la table des stocks à partir d'un code visiteur
	 * @param codeVisiteur
	 */
	private void fillTable( String codeVisiteur ){
		ArrayList<Stocker> lesStock;
		if(VisiteurDao.existe(codeVisiteur)){
			lesStock = StockerDao.rechercherStocks(codeVisiteur);
		} else {
			lesStock = StockerDao.getLesStock(10);
		}
		fillTable(lesStock);
	}
	
	/**
	 * Met a jour la table des stocks
	 * @param codeVisiteur
	 */
	private void fillTable( ArrayList<Stocker> lesStock ){
		
//		DefaultTableModel tableModel = (DefaultTableModel)this.JTBLlisteStock.getModel();
		DefaultTableModel tableModel = new DefaultTableModel();
		
		if(lesStock == null){
			System.err.println("fillTable() : Liste des stock null");
			return;
		}
		
		String[] columnNames = {"Visiteur", "Code", "Nom","Stock"};
		tableModel.setColumnIdentifiers(columnNames);
		for(Stocker stck: lesStock ){
			String[]data = new String[4];
			Medicament unMedic = stck.getUnMedicament();
			data[0] = stck.getUnVisiteur().getMatricule();
			data[1] = unMedic.getDepotLegal();
			data[2] = unMedic.getNomCommercial();
			data[3] = String.valueOf(stck.getQteStock());
			
			tableModel.addRow(data);
		}
		
		this.JTBLlisteStock.setModel(tableModel);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if( event.getSource() == this.JTcodeVisiteur || event.getSource() == this.JBrechercher ){
			fillTable(this.JTcodeVisiteur.getText());
		}
		
	}
	
}
