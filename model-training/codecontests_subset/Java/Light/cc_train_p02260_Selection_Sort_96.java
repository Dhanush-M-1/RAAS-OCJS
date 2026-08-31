import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] A = inpNum(n);

		selectionSort(A);
		sc.close();

	}

	private static void selectionSort(int[] A) {
		int cnt = 0;

		for (int i = 0; i < A.length - 1; i++ ) {
			int mini = i;
			for (int j = i + 1; j < A.length; j++ ) {

				if ( A[j] < A[mini] ) {
					mini = j;
				}
			}

				if (mini != i) {
					int tmp = A[i];
					A[i] = A[mini];
					A[mini] = tmp;
					cnt++;
				}
		}

		for (int k = 0; k < A.length; k++ ) {
			System.out.print(A[k]);
			if(k < A.length -1) {
				System.out.print(" ");
			}

		}
		System.out.println();
		System.out.println(cnt);

	}

	private static int[] inpNum(int n) {
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		return nums;
	}

}
