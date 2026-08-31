import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	void work() {
		String s = cin.nextLine();
		int len = 0, n = 0, x = 0, y = 0;
		int[] v = new int[111];
		int[] a = new int[111];
		y ++; a[len ++] = 1;
		for(int i = 0; i < s.length(); i ++) {
			if(s.charAt(i) == '-') {
				a[len++] = -1;
				x ++;
			} else if(s.charAt(i) == '+') {
				a[len++] = 1;
				y ++;
			} else if(s.charAt(i) == '=') {
				for(int j = i+2; j < s.length(); j ++) {
					n = n * 10 + (s.charAt(j) - '0');
				}
				break;
			}
		}
		
		int sum = y-x;
		
//		System.out.println("n = " + n + " sum = " + sum + " x = " + x + " y = " + y);
		for(int i = 0; i < len; i ++)
			v[i] = 1;
		for(int i = 0; i < len; i ++) {
			while(sum < n && v[i] < n && a[i] == 1) {
				v[i] ++;
				sum ++;
			}
			while(sum > n && v[i] < n && a[i] == -1) {
				v[i] ++;
				sum --;
			}
		}
		
		if(sum != n) {
			out.println("Impossible");
		} else {
			out.println("Possible");
			int idx = 0;
			for(int i = 0; i < s.length(); i ++) {
				if(s.charAt(i) == '?') {
					out.print(v[idx++]);
				} else {
					out.print(s.charAt(i));
				}
			}
			out.println();
		}
			
	}
	
	Scanner cin = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) {
	//	System.out.println("hello");
		Main wo = new Main();
		wo.work();
		out.close();
	}
//    DecimalFormat df=new DecimalFormat("0.000000");
	
    /*
     
	class node implements Comparable<node>{
		String name;
		int a;	
		node(String _name, int _a) {
			name = _name;
			a = _a;
		}
		
		@Override
		public int compareTo(node x) { //降序
			return x.a - this.a;			
		}
	}
	
	
     public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
     */
}
