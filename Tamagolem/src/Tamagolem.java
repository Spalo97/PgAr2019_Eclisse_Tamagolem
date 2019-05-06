import java.util.ArrayList;
import java.util.Scanner;

public class Tamagolem {

	public static final int TOT_PIETRE = 15;
	public static final int MAX_PIETRE = 3;
	private final int VITA_INIZIALE = 100;
	
	private String nome;
	private int vita;
	private ArrayList<Integer> pietreIngerite = new ArrayList<>();
	private ArrayList <Integer> saccopietre = new ArrayList<>(5);

	public Tamagolem() {
		this.vita = VITA_INIZIALE;
	}
	
	public void preparasacco() {
		for(Integer pietra: saccopietre) {
			pietra = 3;
		}
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

	public void setPietraIngerita() {
		for (int i = 0; i < MAX_PIETRE; i++) {
			int scelta = inputElementi();
			pietreIngerite.add(scelta);
		}
	}

	public int inputElementi() {
		Scanner in = new Scanner(System.in);
		System.out.println("Inserisci il tipo di elemento:");
		
		//print degli elementi su console
		for (int i = 0; i < TipoElemento.values().length; i++) {
			System.out.printf("[%d] %s\t", i, TipoElemento.values()[i]);
		}
		System.out.println();
		
		int x = in.nextInt();
		if(saccopietre.get(x)==0) {
			do {
				System.out.println("Non ci sono più pietre di questo tipo!");
				System.out.println("Inserisci il tipo di elemento:");
				for (int i = 0; i < TipoElemento.values().length; i++) {
					System.out.printf("[%d] %s\t", i, TipoElemento.values()[i]);
				}
				System.out.println();
				x = in.nextInt();	
			}while(saccopietre.get(x)==0);
		}
		saccopietre.set(x,saccopietre.get(x)-1);
		return x;
	}

	public String inputNome() {
		System.out.println("Come si chiama il tuo Tamagolem?");
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
}
