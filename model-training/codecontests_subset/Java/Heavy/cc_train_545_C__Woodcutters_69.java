//package CF545C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {

	//0, 向左
	//1, 向右
	static int n, x[], h[], DP[][], mx;
	
	public static void main(String[] args) throws IOException {
		n = nextInt();
		x = new int[n+1];
		h = new int[n+1];
		DP = new int[n+1][3];
		for(int i = 1 ; i <= n ; ++i) {
			x[i] = nextInt();
			h[i] = nextInt();
		}
		DP[1][0] = DP[1][1] = 1;
		for(int i = 2 ; i <= n ; ++i) {
			DP[i][0] = Math.max(DP[i-1][0],DP[i-1][1]);
			if(x[i]-x[i-1]>h[i-1]) DP[i][0] = Math.max(DP[i][0],DP[i-1][2]);
			if(x[i]-x[i-1]>h[i]) DP[i][1] = Math.max(DP[i-1][1]+1,DP[i-1][0]+1);
			if(x[i]-x[i-1]>h[i]+h[i-1]) DP[i][1] = Math.max(DP[i][1],DP[i-1][2]+1);
			DP[i][2] = Math.max(DP[i-1][0],DP[i-1][1]) + 1;
			if(x[i]-x[i-1]>h[i-1]) DP[i][2] = Math.max(DP[i][2],DP[i-1][2]+1);
		}
		out.println(Math.max(Math.max(DP[n][0],DP[n][1]),DP[n][2]));
		out.flush();
	}

	static StringBuilder print = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StreamTokenizer st = new StreamTokenizer(br);
	static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static int nextInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
	
}
