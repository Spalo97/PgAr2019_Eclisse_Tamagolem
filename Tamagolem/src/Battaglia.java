import java.util.*;
import java.io.*;

public class Battaglia {


	public void scontro() {

		System.out.println("Giocatore 1: Tocca a te! \n");
		Giocatore g1 = new Giocatore();
		g1.evocaTamagolem();

		System.out.println("Giocatore 2 Tocca a te! \n");
		Giocatore g2 = new Giocatore();
		g2.evocaTamagolem();

		controllopietre(g1, g2);

		lotta(g1, g2);

	}

	public boolean controllopietre(Giocatore g1, Giocatore g2) {
		boolean ok = false;
		Tamagolem tama1 = new Tamagolem();
		tama1 = g1.tamaInCampo();
		Tamagolem tama2 = new Tamagolem();
		tama2 = g2.tamaInCampo();
		int counter = 0;

		do {
			for (int i = 0; i < tama1.getMaxPietreInTama(); i++) {
				if (tama1.getPietreIngerite(i) == tama2.getPietreIngerite(i)) {
					counter++;
				}
			}

			if (counter != tama1.getMaxPietreInTama()) {
				return ok = true;
			} else {
				System.out.println("Giocatore 1 e 2 avete inseirto le stesse pietre degli elementi!");
				System.out.println("Provate ad inserirne altre!/n/n");
				System.out.println("Giocatore 1: Inserisci le Pietre del Potere:");
				g1.cambiapietre();
				System.out.println("Giocatore 2: Inserisci le Pietre del Potere:");
				g2.cambiapietre();
			}
		} while (ok == false);

		return ok;
	}

	private void lotta(Giocatore g1, Giocatore g2) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		Tamagolem tama1 = new Tamagolem();
		tama1 = g1.tamaInCampo();
		Tamagolem tama2 = new Tamagolem();
		tama2 = g2.tamaInCampo();
		Equilibrio matrice = new Equilibrio();
		int i = 0;
		do {
			do {
				if(i==tama1.getMaxPietreInTama()) {
					i=0;
				}
				int danno = matrice.getDanno(tama1.getPietreIngerite(i), tama2.getPietreIngerite(i));
				if (danno > 0) {
					tama1.setVita(tama1.getVita() - danno);
					System.out.println(tama1.getNome() + "ha la peggio e perde " + danno + " punti vita");
					System.out.printf("%s è più forte di %s", TipoElemento.values()[tama2.getPietreIngerite(i)], TipoElemento.values()[tama1.getPietreIngerite(i)]);

				} else if (danno < 0) {
					tama1.setVita(tama2.getVita() - danno);
					System.out.println(tama2.getNome() + "ha la peggio e perde " + danno + " punti vita");
					System.out.printf("%s è più forte di %s", TipoElemento.values()[tama1.getPietreIngerite(i)], TipoElemento.values()[tama2.getPietreIngerite(i)]);

				} else {
					System.out.println("I tamagolem si scagliano contro la stessa Pietra ed è Parità!");
				}
				System.out.println("/n Se siete pronti a vedere come la battaglia andrà avanti premi Invio!");

				try {
					buffer.readLine();
				} catch (IOException e) {
					// e.printStackTrace();
					// è da provare, perchè in teoria la cosa importante è che vada avanti
					// quindi anche se l'utente non premesse solo invio ma premesse anche altro
					// mi va "bene" che quest'eccezione non venga trattata e si vada avanti
				}
				
				if(i<tama1.getMaxPietreInTama()) {
					i=i+1;
				}
			
			} while (tama1.getVita() <= 0 || tama2.getVita() <= 0);
			
			if (tama1.getVita() <= 0 && g1.getTamagolemRimasti() > 0) {
				System.out.println("Giocatore 1 la cattiva notizia è che hai perso un Tamagolem!");
				System.out.println("Quella buona è che puoi evocare ancora " + g1.getMieiTamgolem() + "!");
				System.out.println("Quindi evoca un'altro Tamagolem:");
				g1.evocaTamagolem();
			} else if (tama1.getVita() <= 0 && g2.getTamagolemRimasti() > 0) {
				System.out.println("Giocatore 2 la cattiva notizia è che hai perso un Tamagolem!");
				System.out.println("Quella buona è che puoi evocare ancora " + g2.getMieiTamgolem() + "!");
				System.out.println("Evoca un'altro Tamagolem:");
				g2.evocaTamagolem();
			} else if (g1.getTamagolemRimasti() <= 0) {
				System.out.println("Giocatore 1 mi dispiace molto ma non ha più Tamagolem!");
				System.out.println("Quindi il Giocatore 2 si aggiudica la vittoria!! ");
				break;
			} else if (g2.getTamagolemRimasti() <= 0) {
				System.out.println("Giocatore 2 mi dispiace molto ma non ha più Tamagolem!");
				System.out.println("Quindi il Giocatore 1 si aggiudica la vittoria!! ");
				break;
			}
			controllopietre(g1, g2);
		} while (g2.getTamagolemRimasti() > 0 && g1.getTamagolemRimasti() > 0);
	}
}
