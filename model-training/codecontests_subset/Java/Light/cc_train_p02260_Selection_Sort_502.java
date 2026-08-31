import java.util.Scanner;

public class Main{

	static int c = 0;

	public static void selectionSort(int[] A, int n) {

		for (int i = 0; i < n; i++) {

			int minj = i;

			for (int j = i; j < n; j++) {
				if (A[j] < A[minj]) {
					minj = j;
				}
			}

			if( i != minj ){
				int tmp = A[i];
				A[i] = A[minj];
				A[minj] = tmp;
				c++;
			}
		}
	}

	public static void printArray(int[] A, int n) {

		for (int i = 0; i < n - 1; i++) {

			System.out.print(A[i] + " ");
		}
		System.out.println(A[n - 1]);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		sc.close();

		selectionSort(A, n);

		printArray(A, n);

		System.out.println(c);

	}

}

