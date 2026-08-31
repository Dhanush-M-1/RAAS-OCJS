import java.io.*;
import java.util.*;
import java.math.*;

public class CaninePoetry {

	public static void main(String[] args) throws IOException {

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		
		for(int x = 0; x < T; x++) {

			int counter1 = 0;
			
			String a1 = f.readLine();
			String[] a2 = a1.split("");
			
			int[] a3 = new int[a1.length()];
			
			for(int a = 1; a < a2.length; a++) {
				
				if (a2[a].equals(a2[a-1])) {
					a2[a] = "@";
					counter1++;
				}
				else if (a >= 2 && a2[a].equals(a2[a-2])){
					a2[a] = "@";
					counter1++;
					
				}
				
			}
			out.println(counter1);
			
		}
		
		out.close();
	}
	
	
	
}
