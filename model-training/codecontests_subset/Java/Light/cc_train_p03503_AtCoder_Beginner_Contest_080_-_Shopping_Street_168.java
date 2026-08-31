import java.util.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] opens = new int[n];
		for (int i = 0; i < n; i++) {
			String[] lines = br.readLine().split(" ", 10);
			int base = 0;
			for (int j = 0; j < 10; j++) {
				base *= 2;
				base += Integer.parseInt(lines[j]);
			}
			opens[i] = base;
		}
		int[][] benefits = new int[n][11];
		for (int i = 0; i < n; i++) {
			String[] lines = br.readLine().split(" ", 11);
			for (int j = 0; j < 11; j++) {
				benefits[i][j] = Integer.parseInt(lines[j]);
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < 1024; i++) {
			int revenue = 0;
			for (int j = 0; j < n; j++) {
				revenue += benefits[j][getCount(i, opens[j])];
			}
			max = Math.max(max, revenue);
		}
		System.out.println(max);
	}
	
	
	static int getCount(int x, int y) {
		int target = x & y;
		int count = 0;
		while (target > 0) {
			count += target % 2;
			target /= 2;
		}
		return count;
	}
}
