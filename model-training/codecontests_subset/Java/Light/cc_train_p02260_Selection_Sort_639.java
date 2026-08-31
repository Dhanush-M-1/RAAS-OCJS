import java.io.IOException;
import java.util.Scanner;

/**
 * 選択ソート
 * 
 *
 */

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		selectionSort(arr, n);
		
	}
	
	public static void selectionSort(int[] arr, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			int minj = i;
			for (int j = i; j < n; j++) {
				if (arr[j] < arr[minj]) {
					minj = j;
				}
			}
			if (i != minj) {
				count++;
			}
			int tmp = arr[i];
			arr[i] = arr[minj];
			arr[minj] = tmp;
		}
		printArray(arr);
		System.out.println(count);
	}
	
	public static void printArray(int[] arr) {
		String ans = "";
		for (int i = 0; i < arr.length; i++) {
			ans += arr[i] + " ";
		}
		System.out.println(ans.trim());
	}
}
