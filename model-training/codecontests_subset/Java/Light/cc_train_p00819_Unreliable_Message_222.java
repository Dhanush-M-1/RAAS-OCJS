import java.util.Scanner;

public class Main {
	char[] ms;
	char[] msg;

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n != 0) {
			ms = sc.next().toCharArray();
			msg = sc.next().toCharArray();
			solve();
			n--;
		}
	}

	void solve() {
		for (int k = ms.length - 1; k >= 0; k--) {
			StringBuilder sb = new StringBuilder();
			switch (ms[k]) {
			case 'A':
				msg = sb.append(msg).reverse().toString().toCharArray();
				break;
			case 'J':
				sb.append(msg[msg.length - 1]);
				for (int i = 0; i < msg.length - 1; i++)
					sb.append(msg[i]);
				msg = sb.toString().toCharArray();
				break;
			case 'C':
				for (int i = 1; i < msg.length; i++)
					sb.append(msg[i]);
				sb.append(msg[0]);
				msg = sb.toString().toCharArray();
				break;
			case 'P':
				for (int i = 0; i < msg.length; i++) {
					if (msg[i] - '0' >= 0 && msg[i] - '0' <= 9) {
						if (msg[i] == '0') {
							msg[i] = '9';
						} else {
							msg[i]--;
						}
					}
				}
				break;
			case 'M':
				for (int i = 0; i < msg.length; i++) {
					if (msg[i] - '0' >= 0 && msg[i] - '0' <= 9) {
						if (msg[i] == '9') {
							msg[i] = '0';
						} else {
							msg[i]++;
						}
					}
				}
				break;

			case 'E':
				if (msg.length % 2 == 0) {
					for (int i = msg.length / 2; i < msg.length; i++) {
						sb.append(msg[i]);
					}
					for (int i = 0; i < msg.length / 2; i++) {
						sb.append(msg[i]);
					}
				} else {
					for (int i = msg.length / 2 + 1; i < msg.length; i++) {
						sb.append(msg[i]);
					}
					sb.append(msg[msg.length / 2]);
					for (int i = 0; i < msg.length / 2; i++) {
						sb.append(msg[i]);
					}
				}
				msg = sb.toString().toCharArray();
				break;
			}
		}
		System.out.println(new StringBuilder().append(msg).toString());
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
	}
}