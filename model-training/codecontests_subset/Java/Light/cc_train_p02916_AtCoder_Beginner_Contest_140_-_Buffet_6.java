import java.util.Scanner;

public class Main {
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a[] = new int[n];
		int b[] = a.clone();
		int c[] = new int[n - 1];

		for(int j = 0;j < n;j++) {
			a[j] = sc.nextInt();
		}

		for(int j = 0;j < n;j++) {
			b[j] = sc.nextInt();
		}

		for(int j = 0;j < n - 1;j++) {
			c[j] = sc.nextInt();
		}

		int result = java.util.Arrays.stream(b).sum();
		int beforeEat = -1;
		for(int x : a) {
			result += ((beforeEat + 1) == x) ? c[x - 2] : 0;
			beforeEat = x;
		}

		System.out.println(result);
	}
}
