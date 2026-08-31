import java.util.*;
import java.io.*;

public class Garden {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(sc.nextLine());
		sc.close();
		int[] buckets = new int[n];
		for(int i = 0; i < n; i ++) {
			buckets[i] = Integer.parseInt(st.nextToken());
		}
		
		int mintime = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			if(k % buckets[i] == 0) {
				if(k / buckets[i] < mintime)
					mintime = k / buckets[i];
			}
		}
		
		pw.println(mintime);
		pw.close();
	}
}
