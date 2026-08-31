import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N-1];
		int sum = 0;
		
		for(int i = 0; i < N; i ++) {
			A[i] = stdIn.nextInt();
		}
		for(int i = 0; i < N; i ++) {
			B[i] = stdIn.nextInt();
			sum += B[i];
		}
		for(int i = 0; i < N-1; i ++) {
			C[i] = stdIn.nextInt();
		}
		
		for(int i = 0; i < N-1; i++) {
			if(A[i+1]-A[i] == 1) {
				sum += C[A[i]-1];
			}
		}
		
		System.out.println(sum);

	}

}