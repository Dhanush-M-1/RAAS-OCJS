import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		solve(in.nextInt());
		in.close();
	}
	
	static void solve(int n) {
		switch (n) {
		case 1:
			System.out.print(1);
			break;
		case 2:
			System.out.print(2);
			break;
		default:
			if (n % 2 == 0)
				if (n % 3 == 0)
					System.out.print((long)(n-1) * (n-2) * (n-3));
				else
					System.out.print((long)n * (n-1) * (n-3));
			else
				System.out.print((long)n * (n-1) * (n-2));
		}
	}

}
