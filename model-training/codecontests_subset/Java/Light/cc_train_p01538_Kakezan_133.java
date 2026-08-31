import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int Q = scanner.nextInt();
		for (int q = 0; q < Q; q++) {
			String query = scanner.next();
			int steps = 0;
			while (query.length() > 1) {
				int max = 0;
				for (int i = 1; i < query.length(); i++) {
					int a = Integer.parseInt(query.substring(0, i));
					int b = Integer
							.parseInt(query.substring(i, query.length()));
					max = Math.max(max, a * b);
				}
				query = String.valueOf(max);
				steps++;
			}
			System.out.println(steps);

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