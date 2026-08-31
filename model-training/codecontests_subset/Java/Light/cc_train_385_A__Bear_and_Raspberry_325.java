import java.util.Scanner;

public class Bear_and_Raspberry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int c = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int a = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] - arr[i + 1] > a) {
				a = arr[i] - arr[i + 1];
			}
		}
		if (a > 0) {
			a -= c;
		}
		if (a < 0) {
			a = 0;
		}
		System.out.print(a);
		scan.close();
	}

}
