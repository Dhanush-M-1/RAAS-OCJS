
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;


public  class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		HashSet<String> hs = new HashSet<String>();
		
		int ans = 0;
		String s;
		while ((s = in.readLine()) != null) {
			if (s.charAt(0) == '+') {
				hs.add(s.substring(1));
			} else
			if (s.charAt(0) == '-') {
				hs.remove(s.substring(1));
			} else {
				if (s.charAt(s.length() - 1) == ':') continue;
				s = s.split("[:]")[1];
				ans += s.length() * hs.size();
			}
		}
		
		out.println(ans);
		out.close();
	}
}