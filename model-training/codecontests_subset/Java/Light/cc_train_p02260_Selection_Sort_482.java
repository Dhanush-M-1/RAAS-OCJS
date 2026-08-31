import java.util.Scanner;

public class Main {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[]A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = scan.nextInt();
		}
		scan.close();
		selectionSort(A, N);
		disp(A, N);
		System.out.println(cnt);
	}
	static void selectionSort(int[]A, int n) {
		for(int i = 0; i < n - 1; i++) {
			int min_j = i;
			for(int j = i; j < n; j++) {
				if(A[j] < A[min_j]) {
					min_j = j;
				}
			}
			int t = A[i];
			A[i] = A[min_j];
			A[min_j] = t;
			if(i != min_j) {
				cnt++;
			}
		}
	}
	static void disp(int[]A, int n) {
		for(int i = 0; i < n; i++) {
			if(i == n - 1) {
				System.out.println(A[i]);
			}else {
				System.out.print(A[i] + " ");
			}
		}
	}
}
