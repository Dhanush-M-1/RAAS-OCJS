import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		int[] A = new int[N];
		int[] C = new int[N-1];
		Arrays.setAll(A, i->sc.nextInt());
		
		for (int i=0; i<N; i++) {
			ans += sc.nextInt();
		}
		
		Arrays.setAll(C, i->sc.nextInt());
		
		for (int i=0; i<N-1; i++) {
			if (A[i]+1 == A[i+1]) {
				ans += C[A[i]-1];
			}
		}
		System.out.println(ans);
	}
}