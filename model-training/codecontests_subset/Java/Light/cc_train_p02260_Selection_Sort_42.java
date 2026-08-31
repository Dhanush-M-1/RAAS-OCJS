import java.util.Scanner;

public class Main {
	
	int count = 0;
	
	void swap(int[] A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
		count++;
	}
	
	void selectionSort(int[] A) {
		for (int i = 0; i < A.length; i++) {
			int minj = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < A[minj]) {
					minj = j;
				}
			}
			if (minj != i) swap(A, i, minj);
		}
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = scan.nextInt();
		}
		count = 0;
		selectionSort(A);
		System.out.print(A[0]);
		for (int i = 1; i < A.length; i++) {
			System.out.print(" " + A[i]);
		}
		System.out.println();
		System.out.println(count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

}

