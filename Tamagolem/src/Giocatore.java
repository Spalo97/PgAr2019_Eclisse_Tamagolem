import java.util.ArrayList;

public class Giocatore {
	
	private final int TAMAGOLEM_TOTALI = 2;
	private ArrayList<Tamagolem> mieiTamagolem = new ArrayList<>(2);
	private int tamagolemRimasti = TAMAGOLEM_TOTALI;
	private boolean inGioco = true;

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
