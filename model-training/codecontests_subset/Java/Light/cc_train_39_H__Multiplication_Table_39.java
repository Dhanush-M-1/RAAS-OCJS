import java.util.Scanner;

public class Main {

	public static final double EPS = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < n; ++j) {
				if (j > 1) {
					System.out.print(" ");
				}
				System.out.print(f(j * i, n));
			}
			System.out.println();
		}
	}

	private static String f(int i, int n) {
		String s = "";
		if(i==0) {
			return "0";
		}
		while(i>0) {
			s = (i%n) + "" + s;
			i/=n;
		}
		return s;
	}

}
