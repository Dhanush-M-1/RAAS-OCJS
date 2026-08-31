
import java.util.Scanner;

public class Main {
	public static int selectionSort(int A[], int N) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			int minj = i;
			int oki;
			for (int j = i; j < N; j++) {
				if (A[j] < A[minj]) {
					minj = j;
				}
			}
			if(i!=minj) {
				oki = A[minj];
				A[minj] = A[i];
				A[i] = oki;
				count++;
				}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = scanner.nextInt();
		}
		int count=selectionSort(A,N);
		for(int i=0;i<N;i++) {
			if(i!=N-1) {
			System.out.print(A[i]+" ");
		}else {
			System.out.println(A[i]);
		}
			}
		System.out.println(count);

	}

}

