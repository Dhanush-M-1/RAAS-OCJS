import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] A = new int[100];
		int[] B = new int[100];
		int[] C = new int[100];

		for(int i=1; i<=N; i++) {
			A[i] = scan.nextInt();
		}
		for(int i=1; i<=N; i++) {
			B[i] = scan.nextInt();
		}		
		for(int i =1; i<=N-1; i++) {
			C[i] = scan.nextInt();
		}		
		
		int ans=0;
		
		for (int i=1;i<=N;i++) {
			ans += B[A[i]];
			if(A[i] == A[i-1]+1) {
				ans += C[A[i-1]];							
			}
		}
		
		System.out.println(ans);
	}
}