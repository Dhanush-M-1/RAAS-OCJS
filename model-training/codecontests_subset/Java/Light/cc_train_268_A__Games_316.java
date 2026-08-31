import java.util.Arrays;
import java.util.Scanner;
public class partidos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() ; // numero de jugadas
		int [][] coords = new int [n][2];
		for ( int i = 0 ; i < n; i ++){     // Â¿ ++ o --?
			coords [i][0] = sc.nextInt(); //se guarda i partidos
			coords [i][1] = sc.nextInt();
		}
		int resp = 0;
	
		 for (int l = 0 ;l < n; l++ ){
			 for ( int d= 0 ; d < n ; d++){
				if(coords[l][0]==coords[d][1]&& l != d){
					resp = resp+1;
				}
					
		 }
			 
		 }
		 System.out.println(resp);
	}

}