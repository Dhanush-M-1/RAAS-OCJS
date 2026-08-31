/*
ID: wilbs43
LANG: JAVA7
STATUS: incomplete
 */
import java.io.*;
import java.util.*;

public class CF526A {
	public static void main(String[] args) throws IOException {
		BufferedReader in;
		//in = new BufferedReader(new FileReader(new File("CF526A.in")));
			in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine().trim());
		char[] line = in.readLine().toCharArray();
		
		
		
		
		System.out.println(check(n,line)?"YES":"NO");
		in.close();
	}

	public static boolean check(int n, char[] field) {
		for (int i = 0; i < n-4; i++) {
			for (int sep = 1; i+4*sep < n; sep++) {
				int jump = 0;
				for (; jump < 5; jump++) {
					if(field[i+jump*sep]!='*') {
						break;
					}
				}
				if(jump==5) return true;
			}
		}		
		return false;
	}
}