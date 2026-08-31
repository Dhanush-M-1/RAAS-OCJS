import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static String solve (int time) {
		String h = time / 3600 + "";
		if (h.length() == 1) h = "0" + h;
		time %= 3600;
		String m = time / 60 + "";
		if (m.length() == 1) m = "0" + m;
		time %= 60;
		String s = time  + "";
		if (s.length() == 1) s = "0" + s;
		return h + ":" + m + ":" + s;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] str = br.readLine().split(" ");
			int h = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			int s = Integer.parseInt(str[2]);
			if (h == -1 && m == -1 && s == -1) break;
			int normal = 7200 - (h * 3600 + m * 60 + s);
			System.out.println(solve(normal));
			System.out.println(solve(normal * 3));
		}

	}

}