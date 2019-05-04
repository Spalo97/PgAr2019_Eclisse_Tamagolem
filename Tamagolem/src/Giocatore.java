import java.util.ArrayList;

public class Giocatore {
	
	//private Tamagolem[] tama= new Tamagolem[];
	//il numero da tamagolem è da stabilire in base al numero di elementi
	private final int TAMAGOLEM_TOTALI = 6;
	private ArrayList<Tamagolem> mieiTamgolem = new ArrayList<>();
	private int tamagolemRimasti = TAMAGOLEM_TOTALI;
	private boolean inGioco = true;

	public ArrayList<Tamagolem> getMieiTamgolem() {
		return mieiTamgolem;
	}

	public int getTamagolemRimasti() {
		return tamagolemRimasti;
	}

	public boolean evocaTamaGolem() {
		if (isInGioco()) {
			tamagolemRimasti -= 1;
			Tamagolem tamagolem = new Tamagolem();
			tamagolem.setNome();
			tamagolem.setPietraIngerita();
			mieiTamgolem.add(tamagolem);
			return true;
		}
		else {
			return false;
		}
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
