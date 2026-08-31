import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader scn = new InputReader(inputStream);
		PrintWriter prn = new PrintWriter(outputStream);
		II__ASC__II Mechanism = new II__ASC__II();
		Mechanism.Process(scn, prn);
		prn.close();
	}
}

class II__ASC__II {

	public void Process(InputReader scn, PrintWriter prn) throws IOException {
		long q = scn.nextLong();
	      long[] div = new long[2];
	      int root = (int) Math.sqrt(q);
	      for (int i = 2; i <= root; i++) {
	        if (q % i == 0) {
	          if (div[0] == 0) {
	            div[0] = i;
	          } else {
	            div[1] = i;
	            break;
	          }
	        }
	      }
	      
	      if (q == div[0] * div[0] * div[0]) {
	        prn.println(1);
	        prn.println(div[0] * div[0]);
	      } else if (div[0] == 0) {
	    	  prn.println(1);
	    	  prn.println(0);
	      } else if (div[1] == 0) {
	    	  prn.println(2);
	      } else {
	    	  prn.println(1);
	    	  prn.println((div[1] % div[0] == 0) ? div[1] : div[0] * div[1]);
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
	
	 public String nextLine() throws IOException { 
	        return reader.readLine(); 
	    } 

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}
}