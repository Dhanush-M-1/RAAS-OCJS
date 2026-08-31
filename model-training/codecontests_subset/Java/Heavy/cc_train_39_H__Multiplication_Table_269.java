import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
//	static Scanner in; static int next() throws Exception {return in.nextInt();};
	static StreamTokenizer in; static int next() throws Exception {in.nextToken(); return (int) in.nval;};
//	static BufferedReader in;
	static PrintWriter out;
	
	public static void main(String[] args) throws Exception {
//		in = new Scanner(System.in);
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		int n = next();
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (i*j / n != 0) out.print(i*j/n);
				out.print((i*j % n) + " ");
			}
			out.println();
		}
		
		out.close();
	}
}