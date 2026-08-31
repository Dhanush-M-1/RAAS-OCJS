import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.max;
import static java.lang.Math.min;


public class Main {
	//pray for this code//
	static InputReader in = new InputReader(System.in);
    static PrintStream out = new PrintStream(System.out);
	
	static int max = 0;
	static String d = null;
    public static void main (String[] args) throws IOException {
        int n = in.nextInt();
    	String str = in.next();
        str = str.toLowerCase();
    	
        int[][] arr = new int[26][26];
        
        for (int i = 0; i < n - 1; i++) {
        	char a = str.charAt(i);
        	char b = str.charAt(i + 1);
        	arr[(int) a - 97][(int) b - 97]++;
        }
        
        for (int i = 0; i < 26; i++) {
        	for (int j = 0; j < 26; j++) {
        		if (arr[i][j] > max) {
        			max = arr[i][j];
        			d = new String(new char[]{(char) (i + 97), (char) (j + 97)});
        		}
        	}
        }
        out.println(d.toUpperCase());
    }
    
    
    
    
    
    

 
    
    
    
    static class InputReader {
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;

	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream), 32768);
	        tokenizer = null;
	    }

	    public String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {tokenizer = new StringTokenizer(reader.readLine());} 
	            catch (IOException e) {throw new RuntimeException(e);}
	        }
	        return tokenizer.nextToken();
	    }

	        public int nextInt() {
	            return Integer.parseInt(next());
	        }
	        
	        public long nextLong() {
	        	return Long.parseLong(next());
	       }
	 }
}