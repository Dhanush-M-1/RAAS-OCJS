import java.util.*;
import java.io.*;

public class D1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] in = new int[n];
		int[] out = new int[n];
		
		for(int i = 0; i < n - 1; i++) {
			int u = sc.nextInt(), v = sc.nextInt();
			in[v - 1]++;
			out[u - 1]++;
		}
		
		for(int i = 0; i < in.length; i++) {
			if(in[i] + out[i] == 2) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
		
	}
	
	public static class Pair {
		int u;
		int v;
		
		public Pair(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}
}