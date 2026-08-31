import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = 3;
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		Arrays.sort(a);
		if(a[0] + a[1] == a[2]) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
