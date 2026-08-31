import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 140_B
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] A = new int[N+1];
		int[] B = new int[N+1];
		int[] C = new int[N+1];

		int i = 0;
		int ret = 0;

		for(i=1; i<=N; i++) {
			A[i] = sc.nextInt();
		}
		for(i=1; i<=N; i++) {
			B[i] = sc.nextInt();
		}
		for(i=1; i<=N-1; i++) {
			C[i] = sc.nextInt();
		}
	    // Scannerクラスのインスタンスをクローズ
		sc.close();

		ret += B[1];
		for(i=2; i<=N; i++) {
			ret += B[i];
			if(A[i]-A[i-1] == 1) {
				ret += C[A[i-1]];
			}
		}

		System.out.println(ret);

	}
}
