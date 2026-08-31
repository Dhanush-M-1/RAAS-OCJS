import java.util.*;
import java.io.*;
public class B670 {
public static void main(String[] args) throws IOException {
	FS input = new FS(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = input.nextInt(), k = input.nextInt();
	int[] id = new int[n];
	for(int i = 0; i<n; i++) id[i] = input.nextInt();
	int at = 1, len = 1;
	while(at + len <= k)
	{
		at += len;
		len++;
	}
	out.println(id[k-at]);
	out.close();
}

static class FS {
	BufferedReader br;
	StringTokenizer st;

	FS(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
	}

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
}
