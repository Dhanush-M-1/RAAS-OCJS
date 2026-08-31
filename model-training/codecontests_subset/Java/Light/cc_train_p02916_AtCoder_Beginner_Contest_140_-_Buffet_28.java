import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		int B[] = new int[N];
		int C[] = new int[N - 1];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt() - 1;
		}
		for(int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		for(int i = 0; i < N - 1; i++) {
			C[i] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans += B[A[i]];
			if(i > 0) {
				if(A[i] - A[i - 1] == 1) {
					ans += C[A[i - 1]];
				}
			}
		}
		System.out.println(ans);
	}
}
