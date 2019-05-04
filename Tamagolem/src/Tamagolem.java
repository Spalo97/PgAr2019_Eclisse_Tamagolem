import java.util.ArrayList;
import java.util.Scanner;

public class Tamagolem {

	private final int MAX_PIETRE = 3;
	private final int VITA_INIZIALE = 100;
	private final int INDICE_INIZIALE = 0;
	private String nome;
	private int vita;
	private int indice;
	//Il numero di pietre dipenderà dal numero di elementi
	private ArrayList<TipoElemento> pietreIngerite = new ArrayList<>();

	public Tamagolem() {
		this.vita = VITA_INIZIALE;
		this.indice = INDICE_INIZIALE;
	}

	public String getNome() {
		return nome;
	}

	public int getVita() {
		return vita;
	}

	public TipoElemento getPietreIngerite(int i) {
		return pietreIngerite.get(i);
	}

	public void setNome() {
		this.nome = inputNome();
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public void setPietraIngerita() {
		for (indice = 0; indice < MAX_PIETRE; indice++) {
			int scelta = inputElementi();
			pietreIngerite.add(indice, TipoElemento.values()[scelta]);
		}
	}

	public static int inputElementi() {
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci il tipo di elemento:");
		for (int i = 0; i < TipoElemento.values().length; i++) {
			System.out.printf("[%d] %s\t", i, TipoElemento.values()[i]);
		}
		System.out.println();
		int x = in.nextInt();
		return x;
	}

	public static String inputNome() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
}
