import java.util.Scanner;

public class Main {
	public static void swap(int a, int b, int[] li) {
		int tmp = li[a];
		li[a] = li[b];
		li[b] = tmp;
	}

	public static int selectionSort(int[] array, int N) {
		int count = 0;
		for(int i = 0; i < N; i++) {
			boolean flag = false;
			int min = i;
			for(int j = i + 1; j < N; j++) {
				if(array[min] > array[j]) {
					min = j;
					flag = true;
				}
			}
			if(flag) {
				swap(min, i, array);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int N = scanner.nextInt();
		int[] array = new int[N];
		for(int i = 0; i < N; i++) array[i] = scanner.nextInt();
		int count = selectionSort(array, N);
		for(int i = 0; i < N; i++) System.out.print(array[i] + (i == N - 1 ? "\n":" "));
		System.out.println(count);
		scanner.close();
	}
}
