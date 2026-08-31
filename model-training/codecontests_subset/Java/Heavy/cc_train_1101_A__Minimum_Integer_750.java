
/*
USER: caoash3
LANG: JAVA
TASK: 
*/

import java.io.*;
import java.util.*;

public class min {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		//BufferedReader br = new BufferedReader(new FileReader("X.in"));
		//PrintWriter pw = new PrintWriter(new FileWriter("X.out"));

		X solver = new X();
		solver.solve(br, pw);
	}

	static class X {
		public void solve(BufferedReader br, PrintWriter pw) throws IOException {
			
			long n = Long.parseLong(br.readLine());

			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				long l = Long.parseLong(st.nextToken());
				long r = Long.parseLong(st.nextToken());
				long x = Long.parseLong(st.nextToken());
				
				if(x >= l) {
					if((r+1)%x==0) {
						pw.println(r+1);
					}
					else {
					pw.println((r+1) + x - ((r+1)%x));
					}
				}
				else {
					pw.println(x);
				}
				
			}
			
			
			
			pw.close();
		}
	}
}
 

