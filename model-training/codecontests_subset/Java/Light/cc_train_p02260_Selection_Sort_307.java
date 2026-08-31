import java.util.Scanner;

class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = in.nextInt();
		}
		selectionSort(c);
		in.close();
	}

	private static void selectionSort(int[] A) {
		int minj;
		int wk;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			minj = i;
			for (int j = i; j < A.length; j++) {
				if (A[j] < A[minj]) {

					minj = j;

				}

			}
			if(minj!=i) {
				wk=A[minj];
				A[minj]=A[i];
				A[i]=wk;
				count+=1;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length; i++) {
			if (i > 0) {
				sb.append(" ");
			}
			sb.append(A[i]);

		}
		System.out.println(sb.toString());
		System.out.println(count);
	}

}

