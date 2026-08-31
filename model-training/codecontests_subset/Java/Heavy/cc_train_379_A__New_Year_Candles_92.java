import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class jan14 {
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int hours = a;
		int burnt ;
		int newc ;
		while (a>=b){
			newc = a/b;
			burnt = (a%b);
			hours += newc;
			a = burnt + newc;
			
		}
		PrintWriter out = new PrintWriter(System.out);
		out.println(hours);
		out.flush();
		out.close();
	}
}
