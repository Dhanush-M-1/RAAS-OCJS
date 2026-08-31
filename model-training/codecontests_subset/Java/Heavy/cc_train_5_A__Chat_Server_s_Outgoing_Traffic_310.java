import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A {
	public static void main(String[] args) throws IOException {
		new A().run();
	}

	private void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;
		String line;
		int n = 0;
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.startsWith("+")) {
				n++;
			} else if (line.startsWith("-")) {
				n--;
			} else {
				String msg = line.substring(line.indexOf(':') + 1);
				res += msg.length() * n;
			}
		}
		br.close();
		System.out.println(res);
	}
}
