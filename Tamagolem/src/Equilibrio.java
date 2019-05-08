import java.util.*;

public class Equilibrio {

	private int n=5;
	
	private int somma = 0;

	private int[][] equilibrio = new int[n][n];
	
	boolean check = false;
	
	
	public Equilibrio() {
		
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
						if(i==j) {
							equilibrio[i][j]=0;					//diagonale di 0
						}else if(j>i)
							if(j!=(n-1)) {						//elementi sopra la diagonale
								elemento(i,j);
							}else{
								if(somma!=0) {					//ultimo elemento della riga
									equilibrio[i][j]=-somma;
									equilibrio[j][i]=somma;
								}else {
									i=resetLinea(i);
								}
						}
				}
				if(i>=0) {
					if(controlloMax(i)) {
						i=resetLinea(i);
					}
				}
				else if(i<(n-1)){
					somma=setSomma(equilibrio[i+1]);
				}
			}
	}
	
	private int resetLinea(int i) {
		if(i==0) 
			i--;
		else
			i=i-2;
		
		if(i<=0)
			somma=0;
		else
			somma=setSomma(equilibrio[i]);			
		return i;
	}
	
	private void elemento(int i,int j) {
		while(equilibrio[i][j]==0) {
			if(somma==0 && check==false) {
				equilibrio[i][j]=(int) (Math.random()*10);
				equilibrio[j][i]=-equilibrio[i][j];
				somma=somma+equilibrio[i][j];
				check=true;
			}
			if(somma<0 && check==false) {
				equilibrio[i][j]=(int) (Math.random()*10);
				equilibrio[j][i]=-equilibrio[i][j];
				somma=somma+equilibrio[i][j];
				check=true;
			}
			if(somma>0 && check==false) {
				equilibrio[i][j]=-(int) (Math.random()*10);
				equilibrio[j][i]=-equilibrio[i][j];
				somma=somma+equilibrio[i][j];
				check=true;
			}
			check=false;
		}
	}
	
	private int setSomma(int row[]) {
		int val=0;
		for(int i=0;i<n;i++) {
			val=val+row[i];
		}
		return val;
	}
		
	private boolean controlloMax(int i) {
		int val=0;
		boolean check=false;
		for(int j=0;j<n;j++) {
			if(val<equilibrio[i][j]);
				val=equilibrio[i][j];
		}
		
		if(val>10)
			return true;
		
		for(int j=0;j<n;j++) {
			if(val>equilibrio[i][j]);
				val=equilibrio[i][j];
		}
		
		if(val<-10)
			return true;
		
		return false;
	}
	
	public void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(equilibrio[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public int getDanno(int a1, int a2) {
		int danno=equilibrio[a1][a2];
		return danno;
	}
}
