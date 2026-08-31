import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] A = new int[N];
		for(int i=0; i<N; i++ ) {
			A[i] = scan.nextInt();
		}
		scan.close();
		int r = selectionSort(A, N);
		for(int i=0; i<=N-1; i++) {
			if(0<i) {
				System.out.print(" ");
			}
			System.out.print(A[i]);
		}
		System.out.println();
		System.out.println(r);
	}

	private static int selectionSort(int[] A, int N) {
		int replaceCount = 0;
		for(int i=0; i<=N-1; i++) {
			int minj = i;
			for(int j=i; j<=N-1; j++) {
				if(A[j] < A[minj]) {
					minj = j;
				}
			}
			int t = A[i];
			A[i] = A[minj];
			A[minj] = t;
			if(i!=minj) {
				replaceCount++;
			}
		}
		return replaceCount;
	}

}
