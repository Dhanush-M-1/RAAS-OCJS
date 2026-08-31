import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		br.close();

		String key = "keyence";
		boolean flg = false;
		for (int i = 0; i <= 7; i++) {
			String a = key.substring(0, i);
			String b = key.substring(i, 7);
			if (s.startsWith(a) && s.endsWith(b)) {
				System.out.println("YES");
				flg = true;
				break;
			}
		}

		if (!flg) {
			System.out.println("NO");
		}
	}
}
