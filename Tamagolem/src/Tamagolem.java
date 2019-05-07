import java.util.ArrayList;
import java.util.Scanner;

public class Tamagolem {

	
	
	private final int VITA_INIZIALE = 100;
	
	private int maxPietreInTama;
	private int pietreTotali;
	private String nome;
	private int vita;
	private ArrayList<Integer> pietreIngerite = new ArrayList<>(5);
	private ArrayList <Integer> saccopietre = new ArrayList<>(10);

	public void setMaxPietreInTama(int n) {
		maxPietreInTama=(int)(Math.ceil((n+1)/3)+1);
	}
	
	public int getMaxPietreInTama() {
		return maxPietreInTama;
	}
	
	
	public int getPietreTotali() {
		return pietreTotali;
	}
	
	public void setPietreTotali(int n, int g, int p) {
		pietreTotali = (int) (Math.ceil(((2*g*p)/n))*n);
	}

	
	public Tamagolem() {
		this.vita = VITA_INIZIALE;
	}
	
	public void preparasacco(int s, int n) {
		int pietre = s/n;
		for(int i =0; i<n ; i++) {
			saccopietre.add(pietre);
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
		for (int i = 0; i < maxPietreInTama; i++) {
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
