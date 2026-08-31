//package school1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class H {

	static StreamTokenizer in =
		new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	
	static int nextInt() throws IOException{
		in.nextToken();
		return (int)in.nval;
	}
	
	static PrintWriter out = new PrintWriter(System.out);
	
	static void base(int n, int b){
		int res[] = new int[10];
		int l = 0;
		
		while (n != 0){
			res[l++] = n%b;
			n /= b;
		}
		
		for (int i=l-1; i>=0; i--)
			out.print(res[i]);
		out.print(' ');
	}
	
	public static void main(String[] args) throws IOException{
		int k = nextInt();
		
		for (int i=1; i<k; i++){
			for (int j=1; j<k; j++)
				base(i*j, k);
			out.println();
		}
		
		out.flush();
	}

}
