import java.util.Arrays;
import java.util.Scanner;

public class Main {
	MyScanner sc = new MyScanner();
	Scanner sc2 = new Scanner(System.in);
	int mod = 1000000007;
	String order, msg;

	void run() {
		int N = sc.nextInt();
		while (N-- > 0) {
			order = sc.next();
			msg = sc.next();
			for (int i = order.length() - 1; i >= 0; i--) {
				operation(order.charAt(i));
			}
			System.out.println(msg);
		}
	}

	void operation(char op) {
		String tmp = "";
		int len = msg.length();
		switch (op) {
		case 'C':
			tmp = msg.substring(1, len);
			tmp += msg.charAt(0);
			break;
		case 'J':
			tmp = msg.charAt(len - 1) + "";
			tmp += msg.substring(0, len - 1);
			break;
		case 'E':
			int h = msg.length() / 2;
			if (len % 2 == 0) {
				tmp = msg.substring(h, len);
				tmp += msg.substring(0, h);
			} else {
				tmp = msg.substring(h + 1, len);
				tmp += msg.charAt(h);
				tmp += msg.substring(0, h);
			}
			break;
		case 'A':
			tmp = new StringBuilder(msg).reverse().toString();
			break;
		case 'M':
			for (int i = 0; i < len; i++) {
				if (Character.isDigit(msg.charAt(i))) {
					tmp += (Integer.valueOf(msg.charAt(i) - '0') + 1) % 10;
				} else {
					tmp += msg.charAt(i);
				}
			}
			break;
		case 'P':
			for (int i = 0; i < len; i++) {
				if (Character.isDigit(msg.charAt(i))) {
					int t = Integer.valueOf(msg.charAt(i) - '0') - 1;
					tmp += t < 0 ? 9 : t;
				} else {
					tmp += msg.charAt(i);
				}
			}
			break;
		default:
			break;
		}
		msg = tmp;
	}

	public static void main(String[] args) {
		new Main().run();
	}

	void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}

	void debug2(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	class MyScanner {
		int nextInt() {
			try {
				int c = System.in.read();
				while (c != '-' && (c < '0' || '9' < c))
					c = System.in.read();
				if (c == '-')
					return -nextInt();
				int res = 0;
				do {
					res *= 10;
					res += c - '0';
					c = System.in.read();
				} while ('0' <= c && c <= '9');
				return res;
			} catch (Exception e) {
				return -1;
			}
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String next() {
			try {
				StringBuilder res = new StringBuilder("");
				int c = System.in.read();
				while (Character.isWhitespace(c))
					c = System.in.read();
				do {
					res.append((char) c);
				} while (!Character.isWhitespace(c = System.in.read()));
				return res.toString();
			} catch (Exception e) {
				return null;
			}
		}
	}
}