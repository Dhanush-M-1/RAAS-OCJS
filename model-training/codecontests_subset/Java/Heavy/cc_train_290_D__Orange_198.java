import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		String s = inB.readLine();
		int n = nextInt();
		String d4 = "";
		s = s.toLowerCase();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c < n + 97){
				d4 += Character.toUpperCase(c);
			} else {
				d4 += Character.toLowerCase(c);
			}
		}
		println(d4);
		
		
	}
	
	private static PrintWriter out =  new PrintWriter(System.out);
	private static BufferedReader inB = new BufferedReader(new InputStreamReader(System.in));	
	private static StreamTokenizer in = new StreamTokenizer(inB);
	
	private static void exit(Object o) throws Exception {
		out.println(o);
		out.flush();
		System.exit(0);
	}
	private static void println(Object o) throws Exception{
		out.println(o);
		out.flush();
	}
	private static void print(Object o) throws Exception{
		out.print(o);
		out.flush();
	}
	private static int nextInt() throws Exception {
		in.nextToken();
		return (int)in.nval;
	}  
	private static String nextString() throws Exception {
		in.nextToken();
		return in.sval;        
	}
	
} 