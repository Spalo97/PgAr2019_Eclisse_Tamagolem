
public class TamagolemMain {
	
	public static int n;

	public static void main(String[] args) {
		
		

		Battaglia partita = new Battaglia();
		Supporto interazioni = new Supporto();

		
		
		interazioni.introduzione();
		n = interazioni.sceltaLivello();
		partita.scontro(n);
		
		

		
	}
}