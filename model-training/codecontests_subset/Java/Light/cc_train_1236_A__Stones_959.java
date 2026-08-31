import java.util.Scanner;

public class Stones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int x1 = min(a, b/2);
			int y1 = min(b - 2*x1, c/2);
			int n1 = 3*(x1+y1);
			int y2 = min(b, c/2);
			int x2 = min(a, (b-y2)/2);
			int n2 = 3*(x2+y2);
			System.out.println(max(n1, n2));
		}
	}

	private static int max(int a, int b) {
		if (a >= b) {
			return a;
		}else {
			return b;
		}
	}

	private static int min(int a, int b) {
		if (a <= b) {
			return a;
		}else {
			return b;
		}
	}
}

