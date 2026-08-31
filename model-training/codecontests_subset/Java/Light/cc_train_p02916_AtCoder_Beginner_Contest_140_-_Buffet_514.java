import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A, B, C;
		A = new int[N];
		B = new int[N];
		C = new int[N-1];
		int x = 0;
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		for(int i=0;i<N;i++) {
		B[i] = sc.nextInt();
		x = x + B[i];
		}
		for(int i=0;i<N-1;i++) {
			C[i] = sc.nextInt();
		}
		for(int i=0;i<N-1;i++) {
			if(A[i+1]==A[i]+1) {
				x = x + C[A[i]-1];
			}
		}
		System.out.println(x);
	}
}