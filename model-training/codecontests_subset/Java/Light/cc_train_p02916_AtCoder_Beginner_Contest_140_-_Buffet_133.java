import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N-1];
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			B[i] = sc.nextInt();
		}
		for(int i=0;i<N-1;i++) {
			C[i] = sc.nextInt();
		}
		
		int satisfact = 0;
		int preNum = 0;
		
		for(int i=0;i<N;i++) {
			int num = A[i];
			satisfact += B[num - 1];
			if(preNum + 1 == num && preNum != 0) {
				satisfact += C[preNum - 1];
			}
			preNum = num;
		}
		
		System.out.println(satisfact);
		
		sc.close();	
	}
}