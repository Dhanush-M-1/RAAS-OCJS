import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		for ( int i = 0 ; i < N ; i++ ) {
			A[i] = sc.nextInt();
		}
		for ( int i = 0 ; i < N ; i++ ) {
			B[i] = sc.nextInt();
		}
		for ( int i = 0 ; i < N - 1 ; i++ ) {
			C[i] = sc.nextInt();
		}
		sc.close();

		int s = 0;
		for ( int i = 0 ; i < N ; i++ ) {
			s += B[A[i] - 1];
			if ( i >= 1 && A[i] == A[i - 1] + 1 ) {
				s += C[A[i - 1] - 1];
			}
		}
		System.out.println(s);
	}
}
