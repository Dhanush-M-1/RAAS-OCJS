
//package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class remainder {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] ss = s.trim().split(" ");
		int n = Integer.parseInt(ss[0]);
		int x = Integer.parseInt(ss[1]);
		int y = Integer.parseInt(ss[2]);
		String a = br.readLine();
		int count = 0;
		for (int i = n - x; i < n; ++i) {
			if (i == n - y - 1) {
				if (a.charAt(i) == '0')
					count += 1;
			}
				else {
					if (a.charAt(i) == '1')
					count += 1;
				}
		}
		System.out.println(count);
	}

}