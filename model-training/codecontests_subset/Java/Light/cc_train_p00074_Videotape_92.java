import java.util.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;

// AOJ 0074
public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while (true) {
			int h = sc.nextInt(), m = sc.nextInt(), s = sc.nextInt();
			if (h == -1) break;
			int rest = 120 * 60 - (h * 60 * 60 + m * 60 + s);
			int rest3 = rest * 3;
			disp(rest);
			disp(rest3);
		}
	}
	
	public static void disp(int r) {
		int h, m;
		h = r / (60 * 60);
		r -= h * 60 * 60;
		m = r / 60;
		r -= m * 60;
		System.out.printf("%02d:%02d:%02d", h, m, r);
		System.out.println();
	}
}