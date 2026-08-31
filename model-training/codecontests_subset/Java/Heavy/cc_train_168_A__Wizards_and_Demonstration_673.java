import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		PrintWriter out = new PrintWriter(System.out, true);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		// Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int cl = (int)((double)n*y/100.0);
		if((double)n*y/100.0 - (int)((double)n*y/100.0) > 0) cl++;
		if(cl-x < 0) {
			out.println(0);
		}else{
			out.println(cl-x);
		}
	}

}
