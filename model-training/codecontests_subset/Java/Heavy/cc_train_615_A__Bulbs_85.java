import java.io.*;
import java.util.*;
public class Main {   
	
	private static StringTokenizer stringTokenizer;
	private static PrintWriter writer = new PrintWriter(System.out);
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	static String next() throws IOException {
		while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
			stringTokenizer = new StringTokenizer(reader.readLine());
		}
		return stringTokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
    
	public static void main(String[] args) throws IOException {
		
		int n=nextInt();
		int m=nextInt();
		boolean []bulb=new boolean[105];
		
		for(int i=0;i<105;i++) {
			bulb[i]=false;
		}
		
		for(int i=0;i<n;i++) {
			int x=nextInt();
			for(int j=0;j<x;j++) {
				int y=nextInt();
				bulb[y]=true;
			}
		}

		for(int i=1;i<=m;i++) {
			if(bulb[i]==false) {
				writer.println("NO");
				writer.close();
				return;
			}
		}
		
		writer.println("YES");
		writer.close();
    }
}