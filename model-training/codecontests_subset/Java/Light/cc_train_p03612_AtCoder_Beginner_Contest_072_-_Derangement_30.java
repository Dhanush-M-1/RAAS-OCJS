import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt()-1;
		}
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(i == arr[i]) {
				count++;
				i++;
			}
		}
		System.out.println(count);
	}
}