import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Abood2B {



	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int p = 1;
		int n = 0;

		int v = 0;

		String rebus = sc.nextLine();

		ArrayList<Integer> sign = new ArrayList<>();

		for (int i = 2; i < rebus.length(); i+=4) {
			if(rebus.charAt(i) == '+') {
				p++;
				sign.add(0);
			}
			if(rebus.charAt(i) == '-') {
				n++;
				sign.add(1);
			}
			if(rebus.charAt(i) == '=') {
				v = Integer.parseInt(rebus.substring(i + 2, rebus.length()).trim());
			}
		}



		int[] ansP = new int[p];
		int[] ansN = new int[n];

		Arrays.fill(ansP, 1);
		Arrays.fill(ansN, 1);

		int r = 0;

		if(p >= n) 
			r = v - (p - n);
		else 
			r = v + (n - p);

		if(r > 0) {
			if(p == 0 || (r + p - 1) / p >= v) {
				System.out.println("Impossible");
				return;
			}

			Arrays.fill(ansP, r / p + 1);
			r %= p;

			for (int i = 0; i < r; i++)
				ansP[i]++;
		} else if( r < 0){
			r = -r;
			if(n == 0 || (r + n - 1) / n >= v) {
				System.out.println("Impossible");
				return;
			}

			Arrays.fill(ansN, r / n + 1);
			r %= n;

			for (int i = 0; i < r; i++)
				ansN[i]++;
		}

		int c1 = 1;
		int c2 = 0;

		out.println("Possible");

		out.print(ansP[0] + " ");

		for (int i = 0; i < sign.size(); i++) 
			if(sign.get(i) == 0) 
				out.print("+ " + ansP[c1++] + " ");
			else
				out.print("- " + ansN[c2++] + " ");

		out.println("= " + v);


		out.flush();
		out.close();
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

		public String nextLine() throws IOException {return br.readLine();}


		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}



	}

}