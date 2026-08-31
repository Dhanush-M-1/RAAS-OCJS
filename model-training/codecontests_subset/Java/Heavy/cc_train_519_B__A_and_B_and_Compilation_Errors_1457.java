import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in); 
		int N = in.nextInt();
		int [] E1 = new int [N];
		int [] E2 = new int [N-1];
		int [] E3 = new int [N-2];
		for (int i=0; i<N; i++) {
			E1[i]= in.nextInt();
		}
		for (int i=0; i<N-1; i++) {
			E2[i]= in.nextInt();
		}
		for (int i=0; i<N-2; i++) {
			E3[i]= in.nextInt();
			}
		Arrays.sort(E1);
		Arrays.sort(E2);
		Arrays.sort(E3);
		int primer = -1, segundo = -1; 
		for (int i=0; i<N-1;i++) {
			if (E2[i] != E1[i]) {
				primer = E1[i];
				break;
			}
			if (primer == -1) {
				primer = E1 [N-1];
			}
		}
		for (int i=0; i<N-2;i++) {
			if (E3[i] != E2[i]) {
				segundo = E2[i];
				break;
			}
			if (segundo == -1) {
				segundo = E2 [N-2];
			}
		}
		
		System.out.println(primer);
		System.out.println(segundo);
		
	}

}
	 	 	 	  	    			 			  		  		 	