import java.io.*;
import java.util.*;

public class Codeforces831D {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		int[] b = new int[k];
		String[] sp = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(sp[i]);
		sp = br.readLine().split(" ");
		for (int i = 0; i < k; i++)
			b[i] = Integer.parseInt(sp[i]);
		Arrays.sort(a);
		Arrays.sort(b);
		
		int[][] dynamic = new int[n][k];	
		for (int i = n-1; i >= 0; i--) {
			for (int j = k-1; j >= 0; j--) {
				if ((i == n-1) && (j == k-1)) {
					dynamic[n-1][k-1] = Math.abs(p-b[k-1])+ Math.abs(b[k-1]-a[n-1]);
				}
				else if ((i == n-1) && (j < k-1)) {
					dynamic[i][j] = Math.min(dynamic[i][j+1], Math.abs(p-b[j])+Math.abs(b[j]-a[i]));
				}
				else if ((n-i) > (k-j))
					dynamic[i][j] = 2000000001;
				else {
					dynamic[i][j] = Math.min(dynamic[i][j+1], Math.max(dynamic[i+1][j+1], Math.abs(p-b[j])+Math.abs(b[j]-a[i])));
				}
				
			}
		}
		System.out.println(dynamic[0][0]);
			
	}
}
