 

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// author : Enigma27


public class RobinKarp {

	static int n;
	static int k;
	static int office;
	
	static Long[][] dp;
	static int[][] con;

	static List<Integer> people = new ArrayList<>();
	static List<Integer> keys = new ArrayList<>();

	public static void main(String[] args) throws IOException {
	
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		k = in.nextInt();
		office = in.nextInt();
		
		for(int i=0; i<n; i++) {
			people.add(in.nextInt());
		}
		
		for(int i=0; i<k; i++) {
			keys.add(in.nextInt());
		}
		
		Collections.sort(people);
		Collections.sort(keys);
		
		dp = new Long[n][k];
		con = new int[n][k];
		
		System.out.println(rec(0, 0));

	}

	private static long rec(int i, int j) {
		if(i == n) {
			return 0;
		}
		else if(j == k) {
			return 99999999999999l;
		}
		else if(dp[i][j] != null) {
			return dp[i][j];
		}
		else  {
			// we want minimize the maximums
			return dp[i][j] = Math.min( Math.max(rec(i+1, j+1), dist(people.get(i), keys.get(j))) , rec(i, j+1)); 
		}
	}

	private static long dist(int x, int xx) {
		return Math.abs(x - xx) + Math.abs(xx - office);
	}

}