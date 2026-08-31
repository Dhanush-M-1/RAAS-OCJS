import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int N = sc.nextInt();
		int[] A;
		A = new int[N];

		for(int i = 0; i < N; i++){
		 	A[i]= sc.nextInt();
		}
		int minj;
		int count = 0;
		for(int i = 0; i < N; i++){
			minj = i;
			for(int j = i; j < N; j++){
				if(A[j] < A[minj]){
					minj = j;
				}
			}
			if(minj != i){
				int temp = A[i];
				A[i] = A[minj];
				A[minj] = temp;
				count++;
			}
		}


		for(int k = 0; k < N; k++){
			System.out.printf("%d",A[k]);
			if(k != N - 1){
				System.out.printf(" ");
			}	
		}
		System.out.printf("\n%d\n",count);

	}
}
