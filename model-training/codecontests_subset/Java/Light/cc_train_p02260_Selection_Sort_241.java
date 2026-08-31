import java.util.Scanner;

public class Main { //InsertionSort

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int count = 0;
		for(int i = 0; i < n; i++) {
			int min = i;
			for(int j = i; j < n; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			if(i != min) {
				count++;
			}
			int v = arr[min];
			arr[min] = arr[i];
			arr[i] = v;
		}
		for(int i = 0; i < n; i++) {
			if(i == n - 1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println(count);
	}
}

