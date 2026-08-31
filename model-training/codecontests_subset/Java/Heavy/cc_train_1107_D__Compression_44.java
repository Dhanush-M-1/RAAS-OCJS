import java.util.*;
import java.lang.*;


public class D{
	public static class Main {
		public int n;
		public int [][]a;
		public int index(char c) {
			if(c >= '0' && c <= '9') return c - '0';
			return c - 'A' + 10;
		}
		public int get(int lx, int ly, int rx, int ry) {
			int res = a[rx][ry];
			if(lx > 0) res -= a[lx - 1][ry];
			if(ly > 0) res -= a[rx][ly - 1];
			if(lx > 0 && ly > 0) res += a[lx - 1][ly - 1];
			return res;
		}
		public boolean check(int x) {
			for(int i = x - 1; i < n; i += x) {
				for(int j = x - 1; j < n; j += x) {
					int temp = get(i - (x - 1), j - (x - 1), i, j);
					if(!(temp == 0 || temp == x * x)) return false; 
				}
			}
			return true;
		}
		public Main() {
			Scanner scan = new Scanner(System.in);
			n = scan.nextInt();
			scan.nextLine();
			a = new int[n][];
			for(int i = 0; i < n; ++i) {
				a[i] = new int[n];
				String s = scan.nextLine();
				for(int j = 0; j < n / 4; ++j) {
					int c = index(s.charAt(j));
					for(int k = 0; k < 4; ++k) {
						a[i][j * 4 + k] = (c >> (3 - k)) & 1;
					}
				}
			}
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(i > 0) a[i][j] += a[i - 1][j];
					if(j > 0) a[i][j] += a[i][j - 1];
					if(i > 0 && j > 0) a[i][j] -= a[i - 1][j - 1];
				}
			}
			for(int i = n; i > 0; --i) {
				if(n % i == 0 && check(i)) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	public static void main(String []args) {
		new Main();
	}
}
