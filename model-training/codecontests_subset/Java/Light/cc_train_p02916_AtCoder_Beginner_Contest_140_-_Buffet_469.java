import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		int B[] = new int[N];
		int C[] = new int[N];
		for(int i = 0 ; i < N ; ++i) {
			A[i] = sc.nextInt() - 1;
		}
		for(int i = 0 ; i < N ; ++i) {
			B[i] = sc.nextInt();
		}
		for(int i = 0 ; i < N - 1; ++i) {
			C[i] = sc.nextInt();
		}
		int S = 0;
		for(int i = 0 ; i < N ; ++i) {
			S += B[A[i]];
			if(i >= 1) {
				int cur = A[i];
				int prev = A[i - 1];
				if(prev + 1 == cur) {
					S += C[prev];
				}
			}
		}
		System.out.println(S);
	}
}
