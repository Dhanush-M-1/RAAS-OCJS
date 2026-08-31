import java.io.*;
import java.util.*;
		
public class Main {

		private BufferedReader input;
		private PrintWriter output;
		private StringTokenizer stoken;
		
		String fin = "input";
		String fout = "output";
		

		private void solve() throws IOException {
			
			int r1 = nextInt();
			int r2 = nextInt();
			int c1 = nextInt();
			int c2 = nextInt();
			int d1 = nextInt();
			int d2 = nextInt();
			
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			
			boolean key = false;
			for (a=1; a<=9; a++) {
				for (b=1; b<=9; b++) {
					for (c=1; c<=9; c++) {
						for (d=1; d<=9; d++) {
							if (
								(a != b) && (a != c) && (a != d) &&
								(b != c) && (b != d) &&
								(c != d) &&
								(a + b == r1) &&
								(c + d == r2) &&
								(a + c == c1) &&
								(b + d == c2) &&
								(a + d == d1) &&
								(b + c == d2)
								) {
								key = true;
								break;
							}
						}
						if (key) break;
					}
					if (key) break;
				}
				if (key) break;
			}

			if (key) {
				output.println( a + " " + b );
				output.println( c + " " + d );
			} else {
				output.println( -1 );
			}
			
						
		}






		Main() throws IOException {
				//input = new BufferedReader(new InputStreamReader(System.in));
				//output = new PrintWriter(System.out);

				//input = new BufferedReader(new FileReader(fin + ".txt"));
				//output = new PrintWriter(new FileWriter(fout + ".txt"));
			

				//input = new BufferedReader(new FileReader(fin + ".txt"));
				input = new BufferedReader(new InputStreamReader(System.in));
				output = new PrintWriter(System.out);
				
				
				solve();

				
				input.close();
				output.flush();
				output.close();
		}

		
		int nextInt() {
				return Integer.parseInt(nextToken());
		}

		
		long nextLong() {
				return Long.parseLong(nextToken());
		}

		double nextFloat() {
				return Float.parseFloat(nextToken());
		}

		double nextDouble() {
				return Double.parseDouble(nextToken());
		}
		

		String nextToken() {
				while ((stoken == null) || (!stoken.hasMoreTokens())) {
						try {
								String line = input.readLine();
								stoken = new StringTokenizer(line);
						} catch (IOException e) {
								e.printStackTrace();
						}
				}
				return stoken.nextToken();
		}
		

    
		public static void main(String[] args) throws IOException {
				new Main();
		}

}




