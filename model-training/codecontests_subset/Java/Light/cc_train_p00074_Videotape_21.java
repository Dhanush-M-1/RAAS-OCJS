import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";

		StringBuilder sb = new StringBuilder();
		while (!(line = br.readLine()).equals("-1 -1 -1")) {

			int hc, mc, sc, h1, m1, s1, h3, m3, s3;
			hc = mc = sc = h1 = m1 = s1 = h3 = m3 = s3 = 0;
			
			StringTokenizer st = new StringTokenizer(line);
			hc = Integer.parseInt(st.nextToken());
			mc = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());

			// sp
			s1 -= sc;
			if (s1 < 0) {
				s1 += 60;
				mc++;
			}
			m1 -= mc;
			if (m1 < 0) {
				m1 += 60;
				hc++;
			}
			h1 = 2 - hc;

			// ep
			s3 = s1 * 3;
			m3 = m1 * 3;
			h3 = h1 * 3;

			m3 += s3 / 60;
			s3 %= 60;

			h3 += m3 / 60;
			m3 %= 60;

			sb.append(String.format("%02d:%02d:%02d\n", h1, m1, s1));
			sb.append(String.format("%02d:%02d:%02d\n", h3, m3, s3));
		}
		System.out.print(sb.toString());
	}
}