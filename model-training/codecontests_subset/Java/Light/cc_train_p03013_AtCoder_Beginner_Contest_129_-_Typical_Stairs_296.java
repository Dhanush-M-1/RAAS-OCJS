import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main { //atcoder ABC128C -

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[n+1];
		long[] count = new long[n+1];
		for(int i = 0; i < m; i++){
			int a = Integer.parseInt(br.readLine());
			arr[a] = true;
		}
		count[0] = 1;
		count[1] = arr[1] ? 0 : 1;
		for(int i = 2; i <= n; i++){
			if(!arr[i]) {
				count[i] = (count[i-1] + count[i-2]) % 1000000007;
			}
		}
		System.out.println(count[n]);
	}
}
