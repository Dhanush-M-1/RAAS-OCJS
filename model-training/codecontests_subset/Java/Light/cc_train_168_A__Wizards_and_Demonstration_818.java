

import java.util.Scanner;

public class ID30 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n, x, y;
		n = s.nextInt();
		x = s.nextInt();
		y = s.nextInt();
		s.close();
		int ans = solve(n, x, y);
		System.out.println(ans);
	}
	
	public static int solve(int n, double x, int y) {
		double p = (x/n) * 100.0;
		if(p >= y)
			return 0;
		else {
			return 1 + solve(n, x+1, y);
		}
	}

}
