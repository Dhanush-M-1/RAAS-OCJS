import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		char a[] = sc.nextLine().toCharArray();
		char b[] = sc.nextLine().toCharArray();
		char c[] = sc.nextLine().toCharArray();
		
		int letA[] = new int[26];
		int letB[] = new int[26];
		int letC[] = new int[26];
		
		for(int i = 0; i < a.length; ++i) letA[a[i] - 'a']++;
		for(int i = 0; i < b.length; ++i) letB[b[i] - 'a']++;
		for(int i = 0; i < c.length; ++i) letC[c[i] - 'a']++;
		
		int i = 0;
		int max = 0, maxb = 0, maxc = 0;
		
		label: while(true) {
			for(int j = 0; j < 26; ++j)
				if(letA[j] - i * letB[j] < 0) break label;
			
			int min = 1000_000;
			
			for(int j = 0; j < 26; ++j) {
				if(letC[j] > 0)
					min = Math.min(min, (letA[j] - i * letB[j]) / letC[j]);
			}
			
			if(i + min > max) {
				maxb = i;
				maxc = min;
				max = maxb + maxc;
			}
			i++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(i = 0; i < maxb; ++i)
			sb.append(b);
		for(i = 0; i < maxc; ++i)
			sb.append(c);
		for(i = 0; i < 26; ++i) {
			letA[i] -= ((maxb * letB[i]) + (maxc * letC[i]));
		}
		for(i = 0; i < 26; ++i) {
			while(letA[i]-- > 0) sb.append((char) (i + 'a'));
		}
		
		out.println(sb.toString());
		
		out.flush();
		out.close();
	}

	static class Pair {
		int a, b;
		
		public Pair(int x, int y) {
			a = x;
			b = y;
		}
	}
	
	static class Scanner{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public Scanner(FileReader r){	br = new BufferedReader(r);}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException { return Double.parseDouble(next()); }

		public boolean ready() throws IOException {return br.ready();}
	}
}