import java.util.Arrays;
import java.util.Scanner;
public class partidos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() ; // numero de jugadas
		//int resp = coords.length();
		//int p = 0; //partidos 
		//int fi = sc.nextInt();
		//int []part = new int [n]; //jugadas de los partidos
		int [][] coords = new int [n][2];
		for ( int i = 0 ; i < n; i ++){     // ¿ ++ o --?
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
