	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
	
	public class A339 {
		BufferedReader br;
		StringTokenizer in;
		PrintWriter out;
		
		public String nextToken() throws IOException {
		    while (in == null || !in.hasMoreTokens()) {
		        in = new StringTokenizer(br.readLine());
		    }

		    return in.nextToken();
		}

		public int nextInt() throws IOException {
		    return Integer.parseInt(nextToken());
		}

		public long nextLong() throws IOException {
		    return Long.parseLong(nextToken());
		}

		public double nextDouble() throws IOException {
		    return Double.parseDouble(nextToken());
		}
		
		public void solve() throws IOException {
			br = new BufferedReader(new InputStreamReader(System.in));
	        out = new PrintWriter(System.out);
	 
	        String input = br.readLine();
	        String [] values = input.split("\\+");
	        Arrays.sort(values);
	        out.print(values[0]);
	        for(int i = 1 ; i < values.length ; i++)
	        	out.print("+"+values[i]);
	        out.println();
	        out.close();
		}
		
		public static void main (String [] args) throws IOException {
			new A339().solve();
		}
	}