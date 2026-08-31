import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Stones {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(in.readLine().trim());
		
		StringTokenizer st;
		
		while(n --> 0) {
			st = new StringTokenizer(in.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int stones = 0;
			
			
			while(c >= 2 && b >= 1) {
				stones += 3;
				c -= 2;
				b -= 1;
			}
			
			while(b >= 2 && a >= 1) {
				stones += 3;
				b -= 2;
				a -= 1;
			}
			
			out.println(stones);
		}
		
		out.close();
	}
}
