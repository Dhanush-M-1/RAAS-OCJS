import java.io.*;
import java.util.*;

public class task168a {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n, x, y;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			double s = (double) n / 100 * (double) y;
			int k = (int) Math.floor(s);
			if (k < s)
				k++;			
			int result = k - x;
			if (result < 0)
				result = 0;
			System.out.println(result);
		} catch (IOException e) {
		}
	}
}
