import java.io.*;
import java.util.*;

public class CF379A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = a, m = 0, h = 0;
		while (n > 0) {
			h += n;
			m += n;
			n = m / b;
			m %= b;
		}
		System.out.println(h);
	}
}
