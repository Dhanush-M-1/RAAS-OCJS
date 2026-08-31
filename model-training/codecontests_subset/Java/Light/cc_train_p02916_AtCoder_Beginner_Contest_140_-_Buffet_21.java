import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int sum = 0;
		int A[] = new int[N];
		int B[] = new int[N];
		int C[] = new int[N];

		for(int i = 0; i < N; i++){
			A[i] = stdIn.nextInt();
		}

		for(int i = 0; i < N; i++){
			B[i] = stdIn.nextInt();
			sum = sum + B[i];
		}

		for(int i = 0; i < N - 1; i++){
			C[i] = stdIn.nextInt();
		}

		for(int i = 0; i < N - 1; i++){
			if(A[i]  == A[i+1] - 1){
				sum = sum + C[A[i] - 1];
			}
		}


		System.out.println(sum);
		stdIn.close();
	}
}