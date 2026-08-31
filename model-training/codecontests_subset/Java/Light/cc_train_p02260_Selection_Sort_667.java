import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		// int[] A = Arrays.stream(sc.nextLine().split("
		// ")).mapToInt(Integer::parseInt).toArray();

		int[] A = new int[N];

		for (int k = 0; k < N; k++) {
			A[k] = Integer.parseInt(sc.next());
		}

		int tmp;
		int minj;
		int count = 0;
		
		for (int i=0; i<N; i++) {
			minj = i;
			for (int j=i; j<N; j++) {
				if (A[j] < A[minj])
					minj = j;
			}
			if (A[minj] != A[i])
				count++;
			tmp = A[minj];
			A[minj] = A[i];
			A[i] = tmp;
		}
			
		out_put(A);

		System.out.println(count);

		sc.close();
	}

	private static void out_put(int array[]) {

		System.out.printf("%d", array[0]);

		for (int i = 1; i < array.length; i++) {
			System.out.printf(" %d", array[i]);
		}
		System.out.printf("\n");
	}
}

