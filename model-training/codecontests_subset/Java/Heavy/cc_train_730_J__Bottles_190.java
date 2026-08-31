import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

	static int n, total;
	static int memo[][][];
	static Bottle[] arr;
	
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		n = sc.nextInt();
		int[] a = new int[n], b = new int[n];
		int curCap = 0; total = 0; 
		for(int i = 0; i < n; i++) total += a[i] = sc.nextInt();
		for(int i = 0; i < n; i++) b[i] = sc.nextInt();
		arr = new Bottle[n];
		for(int i = 0; i < n; i++)
			arr[i] = new Bottle(a[i], b[i]);
		Arrays.sort(arr);
		int k = -1, remTotal = total;
		for(int i = 0; i < n; i++)
		{
			curCap += arr[i].rem;
			remTotal -= arr[i].cur;
			if(curCap >= remTotal)
			{
				k = i + 1;
				break;
			}
		}
		memo = new int[n][k + 1][10000+1];
		for(int[][] l : memo) for(int[] s : l) Arrays.fill(s, -1);
		out.println(k + " " + (total - dp(0, k, 0)));
		out.flush();
		out.close();
	}
	
	static int dp(int i, int remK, int curVol)
	{
		if(remK == 0 && curVol >= total) return 0;
		if(i == n || remK == 0) return -2000000000;
		if(memo[i][remK][curVol] != -1) return memo[i][remK][curVol];
		int take = arr[i].cur + dp(i + 1, remK - 1, curVol + arr[i].cap);
		int leave = dp(i + 1, remK, curVol);
		return memo[i][remK][curVol] = Math.max(take, leave);
	}

	static class Bottle implements Comparable<Bottle>
	{
		int cap, cur, rem;
		Bottle(int r, int p)
		{
			cur = r; cap = p; rem = cap - cur;
		}
		@Override
		public int compareTo(Bottle o) {
			if(cap != o.cap) return o.cap - cap;
			return o.rem - rem;
		}
		
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream System){br = new BufferedReader(new InputStreamReader(System));}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public String nextLine()throws IOException{return br.readLine();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public double nextDouble() throws IOException {return Double.parseDouble(next());}
		public char nextChar()throws IOException{return next().charAt(0);}
		public Long nextLong()throws IOException{return Long.parseLong(next());}
		public boolean ready() throws IOException{return br.ready();}
		public void waitForInput(){for(long i = 0; i < 3e9; i++);}
	}
}