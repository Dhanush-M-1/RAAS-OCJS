import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class B {

	public static void main(String args[]) {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int c = 0;
		int ar[] = new int[n];
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
			set.add(ar[i]);
		}
		int l = 1;
		int r = 1000000;
		int time = 0;
		while(true) {
			if(set.contains(l))c++;
			if(set.contains(r))c++;
			if(c == n) break;
			time++;
			l++;
			r--;
		}
		System.out.println(time);
		
		
		out.close();
		
	}
	
	
	
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(String s) {
			try{
				br = new BufferedReader(new FileReader(s));
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		public FastScanner(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String nextToken()	{
			while(st == null ||!st.hasMoreElements()){
				try {
				st = new StringTokenizer(br.readLine());}
				catch(IOException e) {
					e.printStackTrace();
				}			
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(nextToken());
		}
		long nextLong() {
			return Long.parseLong(nextToken());
		}
		double nextDouble() {
			return Double.parseDouble(nextToken());
		}
		String next() {
			return nextToken();
		}
		
	}
	
}
