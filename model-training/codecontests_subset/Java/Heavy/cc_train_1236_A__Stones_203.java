import java.util.*;
import java.io.*;

public class Main {
		public static void main(String[] args) {
	        InputStream inputStream = System.in;
	        OutputStream outputStream = System.out;
	        InputReader in = new InputReader(inputStream);
	        PrintWriter out = new PrintWriter(outputStream);
	        TaskA solver = new TaskA();
	        solver.solve(1, in, out);
	        out.close();
	    }
	 
	    static class TaskA {
	        public void solve(int testNumber, InputReader in, PrintWriter out) {
	            int t = in.nextInt();
	            int a, b, c , counter;
	            for(int i = 0; i < t; i++) {
	            	counter = 0;
	            	a = in.nextInt();
	            	b = in.nextInt();
	            	c = in.nextInt();
	            	while(b > 0 && c > 1) {
	            		counter++;
	            		b -= 1;
	            		c -= 2;
	            	}
	            	while(b > 1 && a > 0) {
	            		counter++;
	            		b -= 2;
	            		a -= 1;
	            	}
	            	out.println(3*counter);
	            }
	        }
	 
	    }
	    
	    
	    //template code
	 
	    static class InputReader {
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
}