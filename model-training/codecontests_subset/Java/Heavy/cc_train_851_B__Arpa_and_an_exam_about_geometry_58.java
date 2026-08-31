/*
 * Copyright (c) 2017 SSI Schaefer Noell GmbH
 *
 * $Id: Solution 6:47 PM $ / $HeadURL:  $
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author <a href="mailto:ivan.rykov@ssi-schaefer.ru">ivan.rykov</a>
 * @version $Revision: 1227 $, $Date: 2014-08-08 09:02:22 +0400 (Fri, 08 Aug 2014) $, $Author: ir $
 */
public class Solution {

	private static void solve() {
		long x1 = readLong();
		long y1 = readLong();
		long x2 = readLong();
		long y2 = readLong();
		long x3 = readLong();
		long y3 = readLong();

		if (sameLine(x1, y1, x2, y2, x3, y3) || !sameDist(x1, y1, x2, y2, x3, y3)) {
			out.print("No");
		} else {
			out.print("Yes");
		}
	}

	private static boolean sameDist(long x1, long y1, long x2, long y2, long x3, long y3) {
		return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2) == (x2-x3)*(x2-x3)+(y2-y3)*(y2-y3);
	}

	private static boolean sameLine(long x1, long y1, long x2, long y2, long x3, long y3) {
		return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
	}

	private static boolean isPalindrome(char[] c) {
		for (int i = 0; i < c.length / 2; i++) {
			if (c[i] != c[c.length - i - 1]) return false;
		}
		return true;
	}

	private static BufferedReader in;
	private static PrintWriter out;
	private static StringTokenizer tok;

	public static void main(String[] args) {
		init();
		solve();
		out.close();
	}

	private static void init() {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		tok = new StringTokenizer("");
	}

	private static String readString() {
		while (!tok.hasMoreTokens()) {
			try {
				tok = new StringTokenizer(in.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return tok.nextToken();
	}

	private static int readInt() {
		return Integer.parseInt(readString());
	}

	private static long readLong() {
		return Long.parseLong(readString());
	}
}
