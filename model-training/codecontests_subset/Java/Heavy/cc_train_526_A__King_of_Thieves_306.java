import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class A {
	public static void main(String[] args){
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
		
	}
}

class TaskA {
	public void solve(int test, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		String s = in.next();
		boolean flag;
		flag = false;
		for (int i = 0; i < n; i ++){
			for (int k = 1; k < n; k ++){
				if (i + 4*k < n){
					if ((s.charAt(i) == '*') & (s.charAt(i + k) == '*') & (s.charAt(i + 2*k) == '*') & (s.charAt(i + 3*k) == '*') & (s.charAt(i + 4*k)) == '*'){
						flag = true;
						
					}
				}
			}
		}
		if (flag == true){
			out.println("yes");
		}
		else{
			out.println("no");
		}
		
		
	}
	
	
}

class InputReader {
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream), 32768);
	        tokenizer = null;
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

	    public int nextInt() {
	        return Integer.parseInt(next());
	    }
	}


