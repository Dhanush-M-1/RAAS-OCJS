
import java.util.*;
import java.io.*;

/*
ID: jamesou1
LANG: JAVA
PROB: equilize
*/

public class equilize {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		StringTokenizer tokens = new StringTokenizer(input.nextLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		
		int[] a = new int[n];
		tokens = new StringTokenizer(input.nextLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Set<Integer> possibleNum = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			for(int j = a[i]; j > 0; j/= 2) {
				possibleNum.add(j);
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int num: possibleNum) {
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			for(int i = 0; i < n; i++) {
				int cnt = 0;
				int j = a[i];
				for(; j > num; j/= 2) {
					//System.out.print(j + " ");
					cnt++;
				} //System.out.println(":" + cnt + " " + j + " " + num);
				if(j == num)
					pq.add(cnt);
			}
			
			int total = 0;
			for(int i = 0; i < k; i++) {
				if(pq.isEmpty()) total = Integer.MAX_VALUE;
				else total+= pq.poll();
			}
			//System.out.println(total);
			ans = Math.min(ans, total);
		}
		
		System.out.println(ans);

		input.close();

	}

}

