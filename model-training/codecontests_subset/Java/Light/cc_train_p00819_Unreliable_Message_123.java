import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		// discard first line.
		br.readLine();

		while ((line = br.readLine()) != null && !line.isEmpty()) {

			char[] msgrs = line.toCharArray();
			char[] msg = br.readLine().toCharArray();

			//infer
			for (int i = msgrs.length - 1; i >= 0; i--) {
				switch (msgrs[i]) {
					case 'J':
						msg = J(msg);
						break;
					case 'C':
						msg = C(msg);
						break;
					case 'E':
						msg = E(msg);
						break;
					case 'A':
						msg = A(msg);
						break;
					case 'M':
						msg = M(msg);
						break;
					case 'P':
						msg = P(msg);
						break;
				}
			}
			//ans.
			System.out.println(new String(msg));
		}
	} //end while

	//operation
	public static char[] J(char[] msg) {
		char[] _msg = new char[msg.length];
		for (int i = 0, j = 1; i < msg.length - 1; i++, j++) {
			_msg[j] = msg[i];
		}
		_msg[0] = msg[_msg.length - 1];
		return _msg;
	}

	public static char[] C(char[] msg) {
		char[] _msg = new char[msg.length];
		for (int i = 1, j = 0; i < msg.length; i++, j++) {
			_msg[j] = msg[i];
		}
		_msg[_msg.length - 1] = msg[0];
		return _msg;
	}

	public static char[] E(char[] msg) {
		int d;
		if (msg.length % 2 == 0) d = 0;
		else d = 1;
		for (int i = 0; i < msg.length / 2; i++) {
			int j = i + (msg.length / 2) + d;
			char c1 = msg[i];
			char c2 = msg[j];
			msg[i] = c2;
			msg[j] = c1;
		}
		return msg;
	}

	public static char[] A(char[] msg) {
		char[] _msg = new char[msg.length];
		for (int i = msg.length - 1, j = 0; i >= 0; i--, j++) {
			_msg[j] = msg[i];
		}
		return _msg;
	}

	public static char[] P(char[] msg) {
		for (int i = 0; i < msg.length; i++) {
			char c = msg[i];
			if ('0' <= c && c <= '9') {
				if (c == '0') msg[i] = '9';
				else msg[i]--;
			}
		}
		return msg;
	}

	public static char[] M(char[] msg) {
		for (int i = 0; i < msg.length; i++) {
			char c = msg[i];
			if ('0' <= c && c <= '9') {
				if (c == '9') msg[i] = '0';
				else msg[i]++;
			}
		}
		return msg;
	}

} //end main