import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int Ap = s.nextInt();
		int Bp = s.nextInt();
		int C = s.nextInt();
		int P = Ap;
		int t[] = new int[n];
		
		for(int i=0; i<n; i++){
			t[i] = s.nextInt();
		}
		
		Arrays.sort(t);
		
		for(int i=n-1; i>=0; i--)
		  if((double)t[i]/Bp > (double)C/P){
			   C+=t[i];
			   P+=Bp;
			  }

		System.out.println(C/P);

	}
}