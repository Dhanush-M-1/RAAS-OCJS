import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N-1];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		for(int i=0; i<N; i++) {
			B[i] = sc.nextInt();
		}
		for(int i=0; i<N-1; i++) {
			C[i] = sc.nextInt();
		}
		sc.close();
		int s = 0;
		int b = 0;
		for(int i=0; i<N; i++) {
			int a = A[i]-1;
			s+=B[a];
			if(i>0 && a-b==1) {
				s+=C[A[i-1]-1];
			}
			b = a;
		}
		System.out.println(s);
	}

}