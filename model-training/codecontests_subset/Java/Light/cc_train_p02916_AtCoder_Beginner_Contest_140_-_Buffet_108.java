import java.util.Scanner;

public class Main {
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a[] = new int[n];
		int b[] = new int[n];
		int c[] = new int[n];

		for(int j = 0;j < n;j++) {
			a[j] = sc.nextInt();
		}

		for(int j = 0;j < n;j++) {
			b[j] = sc.nextInt();
		}

		for(int j = 0;j < n - 1;j++) {
			c[j] = sc.nextInt();
		}

		int result = 0;
		int beforeEat = -1;
		for(int x : a) {
			result += b[x - 1];

			if((beforeEat + 1) == x) {
				result += c[x - 2];
			}
			beforeEat = x;
		}

		System.out.println(result);
	}
}