import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i; j < N; j++) {
				if (A[min] > A[j]) {
					min = j;
				}
			}
			if (A[i] != A[min]) {
				count++;
			}
			int temp = A[i];
			A[i] = A[min];
			A[min] = temp;
		}
		for (int i = 0; i < N; i++) {
			if (i == N - 1) {
				System.out.println(A[i]);
			} else {
				System.out.print(A[i] + " ");
			}
		}
		System.out.println(count);
	}
}
