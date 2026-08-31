import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A168 {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = null;

	private void solution() throws IOException {
		 in = new BufferedReader(new InputStreamReader(System.in));
		
		 double n=nextInt();
		 int x=nextInt();
		 double y=nextInt();
		 double g=(n/100)*y;
		 int t=0;
		 if((int)g==g){t=(int)g;}else{t=(int)g +1;}
		 if(t-x<0){System.out.println(0);}else{
		 System.out.println(t-x);}
		 
	}

	String nextToken() throws IOException {
		if (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public static void main(String args[]) throws IOException {
		new A168().solution();
	}
}