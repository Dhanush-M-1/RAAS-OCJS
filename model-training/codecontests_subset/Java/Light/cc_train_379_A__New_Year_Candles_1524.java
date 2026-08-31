import java.io.*;
import java.util.*;
import static java.lang.Math.sqrt;
import static java.lang.Math.floor;

public class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int newCandles = a/b, ans = a;
		
		while (newCandles-- != 0) {
		    ans++;
		    if (ans % b == 0)
		        newCandles++;
		}
		 System.out.println(ans);
		 
	}
}