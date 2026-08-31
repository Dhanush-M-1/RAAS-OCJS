import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
	
	
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		char[] a = sc.next().toCharArray(), b = sc.next().toCharArray(), c = sc.next().toCharArray();
		int[] occA = new int[26], occB = new int[26], occC = new int[26];
		for(char x : a) occA[x - 'a']++;
		for(char x : b) occB[x - 'a']++;
		for(char x : c) occC[x - 'a']++;
		
		int maxC = 0, max = 0, maxB = 0;
		for(int takeB = 0; takeB < a.length / b.length; takeB++)
		{
			boolean stop = false;
			for(char x = 'a'; x <= 'z'; x++)
				if(occB[x - 'a'] * takeB > occA[x - 'a']){stop = true; break;}
			if(stop) break;
			int min = (int)1e5+5;
			for(char x = 'a'; x <= 'z'; x++)
				if(occC[x - 'a'] > 0)
					min = Math.min(min, (occA[x - 'a'] - occB[x - 'a'] * takeB) / occC[x - 'a']);
			if(min + takeB > max)
			{
				max = min + takeB;
				maxC = min;
				maxB = takeB;
			}
		}
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < maxB; i++)
			ans.append(b);
		for(int i = 0; i < maxC; i++)
			ans.append(c);
		for(char x = 'a'; x <= 'z'; x++)
		{
			occA[x - 'a'] -= (maxB * occB[x - 'a'] + maxC * occC[x - 'a']);
			while(occA[x - 'a'] --> 0)
				ans.append(x);
		}
		out.println(ans);
		out.flush();
		out.close();
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {br = new BufferedReader(new InputStreamReader(system));}
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