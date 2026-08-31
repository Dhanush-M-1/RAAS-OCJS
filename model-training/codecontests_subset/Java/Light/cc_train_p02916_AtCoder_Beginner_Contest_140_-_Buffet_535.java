import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N-1];
		for(int i=0;i<N;i++){
			A[i] = sc.nextInt();
		}
		for(int i=0;i<N;i++){
			B[i] = sc.nextInt();
		}
		for(int i=0;i<N-1;i++){
			C[i] = sc.nextInt();
		}
		int score = 0;
		int before = -1;
		for(int i=0;i<N;i++){
			score += B[A[i]-1];
			if(before+1 == A[i]){
				score += C[before-1];
			}
			before = A[i];

		}
		System.out.println(score);
	}
}