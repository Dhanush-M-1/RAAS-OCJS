import java.util.*;
import java.io.*;

public class MinimumEulerCycle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long l = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());

			int section = (n - 1) * 2;
			int base = 1;
			long shift = 0;
			while (section + shift < l && base < n) {
				shift += section;
				section -= 2;
				base++;
			}

			while (l <= r) {
				if ((l & 1) == 1) {
					sb.append(base < n ? base : 1);
				} else {
					sb.append(base + (l - shift) / 2);
				}
				sb.append(' ');
				if (++l > section + shift) {
					shift += section;
					base++;
					section -= 2;
				}
			}

			sb.setLength(sb.length()-1);
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}