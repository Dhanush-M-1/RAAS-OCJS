import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int x = scanner.nextInt();
			if (x == 0) {
				break;
			}

			boolean right = false, left = false;
			int num = 0;
			for (int i = 0; i < x; i++) {
				String step = scanner.next();

				if (step.indexOf("l") != -1) {
					if (left) {
						left = false;
					} else {
						left = true;
					}
				} else {
					if (right) {
						right = false;
					} else {
						right = true;
					}
				}

				if (left && right) {
					left = false;
					right = false;
					num++;
				}

			}
			System.out.println(num);
		}

	}

	static int nextInt() {
		int c;
		try {
			c = System.in.read();
			while (c != '-' && (c < '0' || c > '9'))
				c = System.in.read();
			if (c == '-')
				return -nextInt();
			int res = 0;
			while (c >= '0' && c <= '9') {
				res = res * 10 + c - '0';
				c = System.in.read();
			}
			return res;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

}