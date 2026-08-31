import java.util.Scanner;


public class Partidos {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int m = 0;		
		int n = sc.nextInt();	
		
		int[][]matriz = new int [n][2];
		for(int i = 0; i < n; i++){
			matriz[i][0]= sc.nextInt();
			matriz [i][1]= sc.nextInt();		
	}
		for(int fila=0 ; fila<n ; fila++){
			for(int fila2=0;fila2<n;fila2++){
			if(matriz[fila][0]== matriz[fila2][1]){
				m ++;
			}
		}
			

	}
		System.out.println(m);

}
}
