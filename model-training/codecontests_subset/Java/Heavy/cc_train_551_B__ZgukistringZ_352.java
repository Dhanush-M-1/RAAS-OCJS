import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class B {

	static int[] a , b, c;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		String A = sc.next();
		a = new int[26];
		for (int i = 0; i < A.length(); i++) 
			a[A.charAt(i) - 'a']++;
		
		String B = sc.next();
		b = new int[26];
		for (int i = 0; i < B.length(); i++) 
			b[B.charAt(i) - 'a']++;
		
		String C = sc.next();
		c = new int[26];
		for (int i = 0; i < C.length(); i++) 
			c[C.charAt(i) - 'a']++;
		
		int maxB = 0;
		int maxC = 0;
		
		for (int i = 0; i <= A.length() / B.length(); i++) {
			boolean can = true;
			
			for (int j = 0; j < 26; j++) 
				if(b[j] * i > a[j])
					can = false;
			if(!can)
				break;
			
			int curC = (int) 1e6;
			
			for (int j = 0; j < 26; j++) 
				if(c[j] > 0)
					curC = Math.min(curC, (a[j] - b[j] * i) / c[j]);
			if(i + curC >= maxB + maxC) {
				maxB = i;
				maxC = curC;
			}
		}
		
		for (int i = 0; i < maxB; i++)
			out.print(B);

		for (int i = 0; i < maxC; i++)
			out.print(C);
		
		for (int i = 0; i < 26; i++) {
			a[i] -= maxB * b[i] + maxC * c[i];
			
			for (int j = 0; j < a[i]; j++) 
				out.print((char) (i + 'a'));
			
		}
		out.println();
		
		out.flush();
		out.close();
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