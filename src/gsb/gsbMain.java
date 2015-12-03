package gsb;

import gsb.vue.JIFStockListe;
import gsb.vue.MenuPrincipal;

public class gsbMain {

	// Point d'entrée de l'application
	public static void main(String[] args) {
		MenuPrincipal menuP = new MenuPrincipal();
		menuP.ouvrirFenetre(new JIFStockListe());
	}

}
