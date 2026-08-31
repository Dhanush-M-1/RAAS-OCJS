import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class D {



	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt();
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++)
			a[i] = sc.nextInt();
		int[] gP = new int[n + 1];
		Stack<Integer> s = new Stack<>();

		for (int i = 1; i <= n; i++) {
			while(!s.isEmpty() && a[s.peek()] <= a[i])
				s.pop();

			if(!s.isEmpty())
				gP[i] = s.peek();
			else
				gP[i] = 0;
			s.push(i);
		}

		int[] gS = new int[n + 1];
		s = new Stack<>();

		for (int i = n; i > 0; i--) {
			while(!s.isEmpty() && a[s.peek()] < a[i])
				s.pop();

			if(!s.isEmpty())
				gS[i] = s.peek();
			else
				gS[i] = n + 1;
			s.push(i);
		}

		int[][] bitPS = new int[31][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 31; j++) {
				bitPS[j][i] = bitPS[j][i - 1];
				if((a[i] & (1 << j)) != 0)
					bitPS[j][i]++;
			}
		}

		long ans = 1l * n * (n - 1) / 2;

		for (int i = 1; i <= n; i++) {


			int l = i + 1;
			int h = gS[i] - 1;
			int res1 = -1;

			while(l <= h) {
				int mid = (l + h) / 2;
				boolean can = false;
				for (int j = 0; j < 31; j++) {
					if((a[i] & (1 << j)) == 0) {
						if(bitPS[j][mid] - bitPS[j][i] > 0) {
							can = true;
							break;
						}
					}
				}

				if(can) {
					h = mid - 1;
				}else {
					res1 = mid;
					l = mid + 1;
				}

			}

			int l1 = (res1 == -1) ? 0 : res1 - i;


			//////////////////////////


			l = gP[i] + 1;
			h = i - 1;
			int res2 = -1;

			while(l <= h) {
				int mid = (l + h) / 2;
				boolean can = false;
				for (int j = 0; j < 31; j++) {
					if((a[i] & (1 << j)) == 0) {
						if(bitPS[j][i - 1] - bitPS[j][mid - 1] > 0) {
							can = true;
							break;
						}
					}
				}

				if(can) {
					l = mid + 1;
				}else {
					res2 = mid;
					h = mid - 1;
				}

			}

			int l2 = (res2 == -1) ? 0 : i - res2;
			l1++;
			l2++;
			ans -= (1l * l1 * l2 - 1);

		}

		out.println(ans);


		out.flush(); 
		out.close();
	}



	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String file) throws FileNotFoundException{	br = new BufferedReader(new FileReader(file));}
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
