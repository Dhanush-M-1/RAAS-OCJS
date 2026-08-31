import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader reader = 
			new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args){

		// the number of ppl
		long n = Long.parseLong(getLine());

		String[] inp = getLine().split("\\s+");

		long[] ary = new long[inp.length];

		for (int i = 0; i < inp.length; i++){
			ary[i] = Long.parseLong(inp[i]);
		}

		double total = 0; 
		long max = 0;
		for (long a : ary){
			total += a;
			max = Math.max(max, a);
		}

		long ans = (long) Math.max(max, Math.ceil(total / (n - 1)));
		System.out.println(ans);
	}
	static String getLine(){
		try {
			return reader.readLine();
		} catch (Exception e){
		}
		return null;
	}
}
