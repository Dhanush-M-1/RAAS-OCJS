import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int [] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		sc.close();
		
		selectionSort(input, n);

	}

	private static void selectionSort(int[] A, int n) {

		int count = 0;
		for (int i = 0; i < n; i++) {
			int minj = i;
			for (int j = i; j < n; j++) {
				if(A[j] < A[minj]) minj = j;
			}
			
			if(minj != i) {
				int wk = A[i];
				A[i] = A[minj];
				A[minj] = wk;
				count++;
			}
		}

		show(A, " ");
		System.out.println(count);
		
	}

	private static void show(int[] a, String joiner) {

		String line = Arrays.stream(a)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(joiner));
		
		System.out.println(line);
		
	}
}