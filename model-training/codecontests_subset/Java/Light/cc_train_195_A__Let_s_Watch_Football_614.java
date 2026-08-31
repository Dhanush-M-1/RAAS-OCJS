import java.util.*;
import java.io.*;

public class Solution {

	static Scanner scn = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] HastaLaVistaLa) {
		int t = 1;
		while(t-- > 0) solve();
		System.out.println(sb);
	}

	public static void solve() {
		// Insert an inspiration Quote here
		int a = scn.nextInt(), b = scn.nextInt(), c = scn.nextInt();
		int toDown = a * c, took = (toDown + b - 1) / b;
		int canGet = (b * c);
		int left = toDown - canGet, min = 1, max = took;
		while(min < max) {
			int mid = min + (max - min) / 2;
			if(mid * b >= left) max = mid;
			else min = mid + 1;
		}
		sb.append(min);
	}
}