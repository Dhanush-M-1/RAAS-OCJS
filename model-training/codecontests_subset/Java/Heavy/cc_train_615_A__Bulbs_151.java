import java.util.*;
import java.io.*;
import java.math.*;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);	
		int m = Integer.parseInt(line[1]);	
		
		boolean[] used = new boolean[m+1];
		used[0] = true;
		for (int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			for (int j = 1; j < line.length; j++) {
				used[Integer.parseInt(line[j])] = true;
			}
		}
		
		for (boolean b : used) {
			if (!b) {
				pw.println("NO");
				pw.flush();
				pw.close();
				return;
			}
		}
		
		pw.println("YES");

		pw.flush();
		pw.close();
	}
}
