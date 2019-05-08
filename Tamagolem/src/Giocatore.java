import java.util.ArrayList;

public class Giocatore {
	
	private int tamagolemTotali;
	private ArrayList<Tamagolem> mieiTamagolem = new ArrayList<Tamagolem>();
	private int tamagolemRimasti = tamagolemTotali;
	//private boolean inGioco = true;

	
	public Giocatore(int tamaTotali) {
		this.tamagolemTotali = tamaTotali;
	}
	
	public int getTamagolemTotali() {
		return tamagolemTotali;
	}

	public void setTamagolemTotali(int tamagolemTotali) {
		this.tamagolemTotali = tamagolemTotali;
	}

	public ArrayList<Tamagolem> getMieiTamgolem() {
		return mieiTamagolem;
	}
	
	public Tamagolem tamaInCampo() {
		Tamagolem tama = new Tamagolem();
		tama = mieiTamagolem.get(tamagolemRimasti+1);
		return tama;
	}

	public int getTamagolemRimasti() {
		return tamagolemRimasti;
	}

	public boolean evocaTamagolem(ArrayList<Integer> saccopietre, int maxPietre, int n) {

		for (int i =0; i<n;i++) {
			System.out.println(saccopietre.get(i));
		}
		//if (isInGioco()) {
			tamagolemRimasti -= 1;

			Tamagolem tamagolem = new Tamagolem();

			tamagolem.setNome();
			tamagolem.setPietraIngerita(saccopietre, maxPietre, n);
			mieiTamagolem.add(tamagolemRimasti,tamagolem);
			return true;
		/*}
		else {
			return false;
		}*/
	}
	
	public void cambiapietre(ArrayList<Integer> saccopietre, int maxpietreinTama, int n) {
		Tamagolem tama = new Tamagolem();
		tama = mieiTamagolem.get(tamagolemRimasti);
		tama.setPietraIngerita(saccopietre, maxpietreinTama, n);
	}
	

/*	public boolean isInGioco() {
		if (tamagolemRimasti > 0) {
			inGioco = true;
		}
		else {
			inGioco =false;
		}
		return inGioco;
	}
*/
}
