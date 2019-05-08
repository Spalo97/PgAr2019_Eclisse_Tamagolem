import java.util.*;
import java.io.*;

public class Battaglia {

	private int maxPietreInTama;
	private int pietreTotali;
	private ArrayList<Integer> saccopietre = new ArrayList<Integer>();

	private int tamaTotali;

	public void setSaccopietre(ArrayList<Integer> saccopietre) {
		this.saccopietre = saccopietre;
	}

	public ArrayList<Integer> getSaccopietre() {
		return saccopietre;
	}

	public void rimuoviPietra(ArrayList<Integer> sacco, int pos) {
		Integer x = sacco.get(pos);
		int n = x.intValue();
		n = n - 1;
		sacco.set(pos, (Integer) n);
		setSaccopietre(sacco);
	}

	public void sistemaSacco(Tamagolem tama1, Tamagolem tama2) {
		
		for (int i = 0; i < maxPietreInTama; i++) {
			Integer pietra = tama1.getPietreIngerite(i);
			int indice = pietra.intValue();
			int n = saccopietre.get(indice) + 2;
			saccopietre.set(indice, n);
		}
	}

	public void inizializzazione(int n) {
		this.maxPietreInTama = (int) (Math.ceil((n + 1) / 3) + 1);
		System.out.println("max pietre in tama: " + maxPietreInTama);

		double q1 = (n - 1) * (n - 2);
		this.tamaTotali = (int) Math.ceil(q1 / (2 * this.maxPietreInTama));
		System.out.println("max tama: " + tamaTotali);

		this.pietreTotali = (int) (Math.ceil(((2 * this.tamaTotali * this.maxPietreInTama) / n)) * n);
		Integer pietre = (Integer) this.pietreTotali / n;
		System.out.println("max pietre: " + pietreTotali);

		for (int i = 0; i < n; i++) {
			saccopietre.add(pietre);
		}
	}

	public void scontro(int n) {

		inizializzazione(n);

		System.out.println("Giocatore 1: Tocca a te! \n");
		Giocatore g1 = new Giocatore(this.tamaTotali);
		g1.evocaTamagolem(saccopietre, maxPietreInTama, n);

		System.out.println("Giocatore 2 Tocca a te! \n");
		Giocatore g2 = new Giocatore(this.tamaTotali);
		g2.evocaTamagolem(saccopietre, maxPietreInTama, n);

		controllopietre(g1, g2, n);

		lotta(g1, g2, n);

	}

	public boolean controllopietre(Giocatore g1, Giocatore g2, int n) {
		boolean ok = false;

		Tamagolem tama1 = new Tamagolem();
		tama1 = g1.tamaInCampo();
		Tamagolem tama2 = new Tamagolem();
		tama2 = g2.tamaInCampo();
		int counter = 0;

		do {
			for (int i = 0; i < maxPietreInTama; i++) {
				if (tama1.getPietreIngerite(i) == tama2.getPietreIngerite(i)) {
					counter++;
				}
			}

			if (counter != maxPietreInTama) {
				return ok = true;
			} else {
				sistemaSacco(tama1, tama2);
				System.out.println("\nGiocatore 1 e 2 avete inseirto le stesse pietre degli elementi!");
				System.out.println("Provate ad inserirne altre!\n");
				System.out.println("Giocatore 1: Inserisci le Pietre del Potere:");
				g1.cambiapietre(saccopietre, maxPietreInTama, n);
				System.out.println("Giocatore 2: Inserisci le Pietre del Potere:");
				g2.cambiapietre(saccopietre, maxPietreInTama, n);
			}
		} while (ok == false);

		return ok;
	}

	private void lotta(Giocatore g1, Giocatore g2, int n) {
		int tamarimasti;
		boolean b=true;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		Tamagolem tama1 = new Tamagolem();
		tama1 = g1.tamaInCampo();
		Tamagolem tama2 = new Tamagolem();
		tama2 = g2.tamaInCampo();
		Equilibrio matrice = new Equilibrio(n);
		int i = 0;
		int vita;
		int vita1;
		int vita2;
		do {
			do{
				if (i == maxPietreInTama) {
					i = 0;
				}
				int danno = matrice.getDanno(tama1.getPietreIngerite(i), tama2.getPietreIngerite(i));
				if (danno > 0) {
					
					vita = tama1.getVita()-danno;
					tama1.setVita(vita);
					
					System.out.println(tama1.getNome() + " ha la peggio e perde " + danno + " punti vita");
					System.out.println(tama1.getNome() + " ti rimangono "  + tama1.getVita()+" punti vita");
					System.out.printf("%s è più forte di %s", TipoElemento.values()[tama2.getPietreIngerite(i)],
							TipoElemento.values()[tama1.getPietreIngerite(i)]);

				} else if (danno < 0) {
					vita = tama2.getVita()-Math.abs(danno);
					tama2.setVita(vita);
				//	tama2.setVita((tama2.getVita() - Math.abs(danno)));
					System.out.println(tama2.getNome() + " ha la peggio e perde " + Math.abs(danno) + " punti vita");
					System.out.println(tama2.getNome() + " ti rimangono "  + tama2.getVita()+" punti vita");
					System.out.printf("%s è più forte di %s", TipoElemento.values()[tama1.getPietreIngerite(i)],
							TipoElemento.values()[tama2.getPietreIngerite(i)]);

				} else {
					System.out.println("I tamagolem si scagliano contro la stessa Pietra ed è Parità!");
				}
				System.out.println("\n Se siete pronti a vedere come la battaglia andrà avanti premi Invio!");

				try {

					buffer.readLine();
				} catch (IOException e) {
					
				}

				if (i < maxPietreInTama) {
					i = i + 1;
				}
				
				vita1=tama1.getVita();
				vita2=tama2.getVita();
				
			}while (vita1 > 0 && vita2 >  0);

			if (tama1.getVita() <= 0 && tamaTotali-g1.getTamagolemEvocati()>0) {
				System.out.println("Giocatore 1 la cattiva notizia è che hai perso un Tamagolem!");
				tamarimasti=tamaTotali-g1.getTamagolemEvocati();
				System.out.println("Quella buona è che puoi evocare ancora " + tamarimasti + "!");
				System.out.println("Quindi evoca un'altro Tamagolem:");
				g1.evocaTamagolem(saccopietre, maxPietreInTama, n);
				tama1=g1.tamaInCampo();
				b=true;
				
			} else if (tama2.getVita() <= 0 && tamaTotali-g2.getTamagolemEvocati()>0) {
				System.out.println("Giocatore 2 la cattiva notizia è che hai perso un Tamagolem!");
				tamarimasti=tamaTotali-g1.getTamagolemEvocati();
				System.out.println("Quella buona è che puoi evocare ancora " + tamarimasti + "!");
				System.out.println("Evoca un'altro Tamagolem:");
				g2.evocaTamagolem(saccopietre, maxPietreInTama, n);
				tama2=g2.tamaInCampo();
				b=true;
			} else if (tamaTotali-g1.getTamagolemEvocati()<=0) {
				System.out.println("Giocatore 1 mi dispiace molto ma non ha più Tamagolem!");
				System.out.println("Quindi il Giocatore 2 si aggiudica la vittoria!! ");
				
				break;
			} else if (tamaTotali-g2.getTamagolemEvocati()<=0) {
				System.out.println("Giocatore 2 mi dispiace molto ma non ha più Tamagolem!");
				System.out.println("Quindi il Giocatore 1 si aggiudica la vittoria!! ");
				break;
			}
		} while (b==true);
	}
}
