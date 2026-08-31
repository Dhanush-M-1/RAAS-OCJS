
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int ans = 0, a = sc.nextInt(), b = sc.nextInt();
		
		int[] a2 = extract(a, 2), b2 = extract(b, 2);
		ans += Math.abs(a2[1] - b2[1]);
		
		int[] a3 = extract(a2[0], 3), b3 = extract(b2[0], 3);
		ans += Math.abs(a3[1] - b3[1]);
		
		int[] a5 = extract(a3[0], 5), b5 = extract(b3[0], 5);
		ans += Math.abs(a5[1] - b5[1]);
		
		if(a5[0] != b5[0])
			out.println(-1);
		else
			out.println(ans);
		out.flush();
		out.close();
	}
	
	static int[] extract(int n, int d)
	{
		int c = 0;
		while(n%d == 0)
		{
			++c;
			n /= d;
		}
		return new int[]{n, c};
	}

	static class Scanner
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}
		
	}
}
