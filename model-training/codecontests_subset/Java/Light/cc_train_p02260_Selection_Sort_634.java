import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int temp = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int index = i;
			for (int j = i; j < n; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			if (index != i) {
				temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
				count++;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(i == 0 ? arr[i] : " " + arr[i]);
		}
		System.out.println("\n" + count);

	}
}
