import java.util.Scanner;

public class Main {

	private void solve() {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N-1];
		for (int i = 0; i < A.length; i++) {
			A[i] = in.nextInt()-1;
		}
		for (int i = 0; i < B.length; i++) {
			B[i] = in.nextInt();
		}
		for (int i = 0; i < C.length; i++) {
			C[i] = in.nextInt();
		}
		
		int total = 0;
		int prev = -100;
		for (int i = 0; i < A.length; i++) {
			total += B[A[i]];
			if(A[i] == prev+1) {
				total += C[prev];
			}
			prev = A[i];
		}
		System.out.println(total);
 	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}

