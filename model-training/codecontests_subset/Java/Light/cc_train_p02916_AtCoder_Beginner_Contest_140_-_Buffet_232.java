import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N-1];
		for (int i=0;i<N;i++) {
			A[i] = Integer.parseInt(sc.next());
		}
		for (int i=0;i<N;i++) {
			B[i] = Integer.parseInt(sc.next());
		}
		for (int i=0;i<N-1;i++) {
			C[i] = Integer.parseInt(sc.next());
		}
		int ans = 0;
		int before = -10;
		for (int i=0;i<N;i++) {
			int index = A[i]-1;
			ans += B[index];
			if (before+1 == index) {
				ans += C[before];
			}
			before = index;
		}
		System.out.println(ans);
	}
}