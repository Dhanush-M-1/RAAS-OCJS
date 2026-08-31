import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N-1];
		for(int i = 0;i < N;i++){
			A[i] = Integer.parseInt(sc.next());
		}
		for(int i = 0;i < N;i++){
			B[i] = Integer.parseInt(sc.next());
		}
		for(int i = 0;i < N-1;i++){
			C[i] = Integer.parseInt(sc.next());
		}
		sc.close();

		int ans = 0;
		for(int i = 0;i < N;i++){
			ans += B[A[i]-1];
			if(i > 0&& A[i] - A[i-1]==1){
				ans += C[A[i-1]-1];
			}
		}
		System.out.println(ans);
	}
}