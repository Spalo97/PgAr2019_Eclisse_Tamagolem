import java.util.ArrayList;
import java.util.Scanner;

public class Tamagolem {

	
	
	private final int VITA_INIZIALE = 100;
	
	
	private String nome;
	private int vita;
	private ArrayList<Integer> pietreIngerite = new ArrayList<Integer>();


	public Tamagolem() {
		this.vita = VITA_INIZIALE;
	}
	

	public String getNome() {
		return nome;
	}

	public int getVita() {
		return vita;
	}

	public int getPietreIngerite(int i) {
		return pietreIngerite.get(i);
	}

	public void setNome() {
		this.nome = inputNome();
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public void setPietraIngerita(ArrayList<Integer> sacco, int maxPietreIngerite, int n) {

		for (int i = 0; i < maxPietreIngerite; i++) {
			int scelta = inputElementi(sacco, n);
			pietreIngerite.add(scelta);
			
		}
	}

	public int inputElementi(ArrayList<Integer> sacco, int n) {
		Scanner in = new Scanner(System.in);
		Battaglia e = new Battaglia();
		System.out.println("Inserisci il tipo di elemento:");
		
		//print degli elementi su console
		for (int i = 0; i < TipoElemento.values().length && i< n; i++) {
			System.out.printf("[%d] %s", i, TipoElemento.values()[i]+"\n");
		}
		System.out.println();
		
		int x = in.nextInt();
		if(sacco.get(x)==0) {
			do {
				System.out.println("Non ci sono più pietre di questo tipo!");
				System.out.println("Inserisci il tipo di elemento:");
				for (int i = 0; i < TipoElemento.values().length; i++) {
					System.out.printf("[%d] %s", i, TipoElemento.values()[i]+"\n");
				}
				System.out.println();
				x = in.nextInt();	
			}while(sacco.get(x)==0);
		}
		e.rimuoviPietra(sacco, x);
		System.out.println("Arrivi qui?");
		return x;
	}

	public String inputNome() {
		System.out.println("Come si chiama il tuo Tamagolem?");
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
}
