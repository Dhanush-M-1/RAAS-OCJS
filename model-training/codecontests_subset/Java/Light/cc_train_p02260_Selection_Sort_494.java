import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		
		int countChange = 0;
		for (int i = 0; i < num; i++) {
			int minj = i;
			int j;
			for (j = i; j < num; j++) {
				if (arr[j] < arr[minj]) {
					minj = j;
				}
			}
			
			if (i != minj) {
				int temp = arr[i];
				arr[i] = arr[minj];
				arr[minj] = temp;
				countChange++;
			}
		}
		
		
		for (int i = 0; i < num; i++) {
			System.out.print(arr[i]);
			if (i != num - 1)
				System.out.print(" ");
		}
		System.out.println("");
		System.out.println(countChange);
	}
}