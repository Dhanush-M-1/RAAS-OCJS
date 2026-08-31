/*
ID: King6997
LANG: JAVA
TASK: 
*/
import java.util.*;
import java.io.*;
public class D {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int[] ppl = new int[n];
		int[] key = new int[k];
		st = new StringTokenizer(reader.readLine());
		for(int i = 0; i < n; i++){
			ppl[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(reader.readLine());
		for(int i = 0; i < k; i++){
			key[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ppl);
		Arrays.sort(key);
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= k-n; i++){
			int dist = -1;
			for (int j = 0; j < n; j++){
				dist = Math.max(dist, Math.abs(ppl[j] - key[j+i]) + Math.abs(key[j+i] - p));
				// System.out.println("(" + i + "," + j + ") : " + dist);
			}
			ans = Math.min(ans, dist);
		}
		System.out.println(ans);
	}
}

