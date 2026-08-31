import java.util.*;
import java.io.*;

public class Garden {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer t = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(t.nextToken());
		int K = Integer.parseInt(t.nextToken());
		t = new StringTokenizer(in.readLine());
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < N; ++i) {
			int a = Integer.parseInt(t.nextToken());
			if(a <= K && K % a == 0 && K / a < ans)
				ans = K / a;
		}
		out.println(ans);
		in.close();
		out.close();
	}
}