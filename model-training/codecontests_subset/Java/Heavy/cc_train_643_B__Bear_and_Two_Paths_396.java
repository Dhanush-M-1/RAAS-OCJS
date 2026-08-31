import java.util.*;
import java.io.*;
public class D673 {
public static void main(String[] args) throws IOException {
	FS input = new FS(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int n = input.nextInt(), k = input.nextInt();
	int a = input.nextInt()-1, b = input.nextInt()-1, c = input.nextInt()-1, d = input.nextInt()-1;
	if(n == 4 || k <= n) out.println(-1);
	else
	{
		ArrayList<Integer> others = new ArrayList<Integer>();
		for(int i = 0; i<n; i++)
		{
			if(i == a || i == b || i == c || i == d) continue;
			others.add(i+1);
		}
		out.print(a+1+" "+(c+1)+" ");
		for(int x : others) out.print(x+" ");
		out.println((d+1)+" "+(b+1));
		out.print(c+1+" "+(a+1)+" ");
		for(int x : others) out.print(x+" ");
		out.println(b+1+" "+(d+1));
	}
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
