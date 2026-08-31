import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ZgukistringZ_CF551B2 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		String a = sc.next();
		String b = sc.next();
		String c = sc.next();
		
		int al [] = new int [26];
		int bl [] = new int [26];
		int cl [] = new int [26];
		
		for(int i = 0; i < a.length(); i++)
			al[a.charAt(i)-'a']++;
		
		for(int i = 0; i < b.length(); i++)
			bl[b.charAt(i)-'a']++;
		
		for(int i = 0; i < c.length(); i++)
			cl[c.charAt(i)-'a']++;

		
		int maxb1 = a.length();
		for(int i = 0; i < 26; i++)
			if(bl[i]!=0)
				maxb1 = Math.min(maxb1,al[i]/bl[i]);
		
		int max = 0;
		int maxind = 0;
		for(int i = 0; i <= maxb1; i++)
		{
			
			int maxc = a.length();
			for(int j = 0; j < 26; j++)
				if(cl[j] != 0)
					maxc = Math.min(maxc, (al[j] - bl[j] *i)/cl[j]);
			
			if(i + maxc > max)
			{
				max = i + maxc;
				maxind = i;
			}
		}
		int maxc = max - maxind;
		for ( int i = 0; i < maxind; i++)
			out.print(b);
		for(int i = 0; i < maxc; i++)
			out.print(c);
		for(int i = 0; i < 26; i++)
		{
			int count = al[i] - maxind * bl[i] - maxc * cl[i];
			while(count-- > 0)
				out.print((char)('a'+i));
		}
		
		
		
		
		
		out.flush();
		out.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
