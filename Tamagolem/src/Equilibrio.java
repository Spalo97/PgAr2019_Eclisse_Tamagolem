import java.util.*;

public class Equilibrio {

	private int n=TamagolemMain.N_ELEMENTI;
	
	private int somma = 0;

	private int[][] equilibrio = new int[n][n];
	
	Random rand =new Random();
	
	public Equilibrio() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) {
					equilibrio[i][j]=0;
				}else if (j>i){
					if(somma==0) {
						equilibrio[i][j]=rand.nextInt(11);
						equilibrio[j][i]=-equilibrio[i][j];
						somma=somma+equilibrio[i][j];
						break;
					}
					if(somma<0) {
						equilibrio[i][j]=rand.nextInt(somma);
						equilibrio[j][i]=-equilibrio[i][j];
						somma=somma+equilibrio[i][j];
						break;
					}
					if(somma>0) {
						equilibrio[i][j]=-rand.nextInt(somma);
						equilibrio[j][i]=-equilibrio[i][j];
						somma=somma+equilibrio[i][j];
						break;
					}
				}
			}
		}
	}
	
	public void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(equilibrio[i][j]);
			}
			System.out.println("");
		}
	}
	
}