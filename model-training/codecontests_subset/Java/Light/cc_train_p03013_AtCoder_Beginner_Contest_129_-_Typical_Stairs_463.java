import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
 
public class Main {
	
	long[] Ni = null;
	
	
	public void solve() {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		Ni = new long[N+1];
		Arrays.fill(Ni, -1);
		Ni[N] = 1;
		Ni[N-1] = 1;
		
		for (int i=0; i<M; i++) {
			Ni[in.nextInt()] = 0;
		}
		in.close();
		
		
		for (int i=N-2; i>=0; i--) {
			if (Ni[i] != 0) {
				Ni[i] = (Ni[i+1] + Ni[i+2]) % 1000000007;
			}
		}
		
		System.out.println(Ni[0]);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solve();
	}
 
}
