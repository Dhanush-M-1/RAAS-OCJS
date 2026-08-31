import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n];
		int[] h = new int[n];
		for(int i=0;i<n;i++){
			x[i]=in.nextInt();
			h[i]=in.nextInt();
		}
		if(n==1){
			System.out.println(1);
			return;
		}
		
		int ans =2;
		boolean prevdown=false;
		for(int i=1;i<n-1;i++){
			if(!prevdown){
				if(x[i]-h[i]>x[i-1])
					ans++;
				else if(x[i]+h[i]<x[i+1]){
					ans++;
					prevdown=true;
				}
			}
			else{
				if(x[i]-h[i]>x[i-1]+h[i-1]){
					ans++;
					prevdown=false;
				}
				else if(x[i]+h[i]<x[i+1]){
					ans++;
					prevdown=true;
				}
				else{
					prevdown=false;
				}
			}
			
		}
		System.out.println(ans);
	}
	
	
	
	static class Scanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public Scanner(InputStream inputstream) {
			reader = new BufferedReader(new InputStreamReader(inputstream));
			tokenizer = null;
		}

		public String nextLine(){
			String fullLine=null;
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					fullLine=reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
} 

