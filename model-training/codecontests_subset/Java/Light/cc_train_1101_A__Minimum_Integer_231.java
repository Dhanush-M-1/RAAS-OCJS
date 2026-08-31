import java.io.*;
import java.util.*;

public class MinimumInteger {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (d < l) System.out.println(d);
			else System.out.println(r + d - r % d );
		}
	}
}
