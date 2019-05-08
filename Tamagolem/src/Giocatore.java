import java.util.ArrayList;

public class Giocatore {
	
	private int tamagolemTotali;
	private ArrayList<Tamagolem> mieiTamagolem = new ArrayList<Tamagolem>();
	private int tamagolemEvocati;
	private int tamaInCampo;
	private boolean inGioco = true;

	
	public Giocatore(int tamaTotali) {
		this.tamagolemTotali = tamaTotali;
		tamagolemEvocati=0;
		tamaInCampo=tamagolemEvocati-1;
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
		return mieiTamagolem.get(tamaInCampo);
	}

	public int getTamagolemEvocati() {
		return tamagolemEvocati;
	}

	public boolean evocaTamagolem(ArrayList<Integer> saccopietre, int maxPietre, int n) {
		if (isInGioco()) {
			Tamagolem tamagolem = new Tamagolem();
			tamagolem.setNome();
			tamagolem.setPietraIngerita(saccopietre, maxPietre, n);
			mieiTamagolem.add(tamagolem);
			tamagolemEvocati += 1;
			tamaInCampo+=1;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void cambiapietre(ArrayList<Integer> saccopietre, int maxpietreinTama, int n) {
		mieiTamagolem.get(tamaInCampo).cambiaPietre(saccopietre, maxpietreinTama, n);
	}
	

	public boolean isInGioco() {
		if (tamagolemEvocati < tamagolemTotali) {
			inGioco = true;
		}
		else {
			inGioco =false;
		}
		return inGioco;
	}

}
