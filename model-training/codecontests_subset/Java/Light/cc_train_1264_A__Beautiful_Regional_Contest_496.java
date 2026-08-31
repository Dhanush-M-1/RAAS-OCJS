
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CF {

	private static Scanner cin = new Scanner(System.in);
	static final int N = 100111;
	static int tc;
	int n;
	
	public void init() {
	}
	int getMin(int x, int y) {
		return x < y ? x : y;
	}
	public void input() {
		n = cin.nextInt();
		int p = cin.nextInt();
		int a=0, b=0, c=0, ansC=-1;
		int s = 0;
		for (int i = 1; i < n; i++) {
			int x = cin.nextInt();
			if (x != p) {
				if (s == 0) {
					a = i;
					s = 1;
					b = 1;
				} else if (s == 1) {
					if (b > a) {
						s = 2;
						c = 1;
					} else {
						b++;
					}
				} else {
					if (a+b+c <= n / 2 && c > a) {
						ansC = c;
					}
					c++;
				}
			} else {
				if (s == 1) {
					b++;
				} else if (s == 2) {
					c++;
				}
			}
			p = x;
		}
		if (s == 2 && ansC != -1) {
			System.out.printf("%d %d %d\n", a, b, ansC);
		} else {
			System.out.println("0 0 0");
		}
	}
	
	public void solve() {
		
	}
	public static void main(String[] args) {
		
		CF cf = new CF();
		int tc = cin.nextInt();
		while (tc-- > 0) {
			cf.input();
			cf.solve();
//			System.out.println(Arrays.toString(cf.b));
		}
	}
}
