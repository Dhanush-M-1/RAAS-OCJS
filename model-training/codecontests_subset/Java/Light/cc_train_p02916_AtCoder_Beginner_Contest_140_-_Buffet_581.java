import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int[] A = new int[N], B = new int[N], C = new int[N];
		int ans = 0;
		for(int i = 0;i < N;i++) {
			A[i] = scn.nextInt();
		}
		for(int i = 0;i < N;i++) {
			B[i] = scn.nextInt();
			ans += B[i];
		}
		for(int i = 0;i < N-1;i++) {
			C[i] = scn.nextInt();
		}
		int b = -2;
		int n = A[0];
		for(int i = 0;i < N-1;i++) {
			b = n;
			n = A[i+1];
			if(n-b==1) {
				ans += C[b-1];
			}
		}
		System.out.println(ans);
	}

}
