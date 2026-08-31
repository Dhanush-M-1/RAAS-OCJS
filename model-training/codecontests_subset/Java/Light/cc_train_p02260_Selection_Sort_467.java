import java.util.Scanner;

public class Main {

	public static void printArray(int num, int[] array) {
		for (int i = 0; i < num; i++) {
			if (i != 0) {
				System.out.print(" ");
			}
			System.out.print(array[i]);
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] array = new int[100];
		int num;
		int minIndex;
		int temp;
		int count = 0;

		// 入力
		num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			array[i] = scan.nextInt();
		}

		// ソート
		for (int i = 0; i < num; i++) {
			minIndex = i;
			for (int j = i; j < num; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			if (i != minIndex) {
				temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
				count++;
			}
		}

		// 出力
		printArray(num, array);
		System.out.println(count);

	}
}
