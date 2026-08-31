import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long l, r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Long.parseLong(st.nextToken());
		r = Long.parseLong(st.nextToken());
		if (l == r) {
			System.out.println(l);
		}
		else {
			System.out.println(2);
		}
	}
}
