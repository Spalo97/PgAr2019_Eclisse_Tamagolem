import java.util.ArrayList;

public class Giocatore {
	
	private int tamagolemTotali;
	private ArrayList<Tamagolem> mieiTamagolem = new ArrayList<>(9);
	private int tamagolemRimasti = tamagolemTotali;
	private boolean inGioco = true;

	
	public int getTamagolemTotali() {
		return tamagolemTotali;
	}

	public void setTamagolemTotali(int n, int p) {
		double q1 =(n-1)*(n-2);
		this.tamagolemTotali = (int) Math.ceil(q1/(2*p));
	}

	public ArrayList<Tamagolem> getMieiTamgolem() {
		return mieiTamagolem;
	}
	
	public Tamagolem tamaInCampo() {
		Tamagolem tama = new Tamagolem();
		tama = mieiTamagolem.get(tamagolemRimasti);
		return tama;
	}

	public int getTamagolemRimasti() {
		return tamagolemRimasti;
	}

	public boolean evocaTamagolem() {
		if (isInGioco()) {
			tamagolemRimasti -= 1;
			Tamagolem tamagolem = new Tamagolem();
			tamagolem.setNome();
			tamagolem.setPietraIngerita();
			mieiTamagolem.add(tamagolemRimasti,tamagolem);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void cambiapietre() {
		Tamagolem tama = new Tamagolem();
		tama = mieiTamagolem.get(tamagolemRimasti);
		tama.setPietraIngerita();
	}
	

	public boolean isInGioco() {
		if (tamagolemRimasti > 0) {
			inGioco = true;
		}
		else {
			inGioco =false;
		}
		return inGioco;
	}

}
