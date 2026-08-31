import java.util.*;
import java.io.*;
public class B {
	public static void main(String...pleasedonthack) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}		
		long[] tr = new long[n+1]; tr[0] = 0;
		for(int i = 1; i <= n; i++){
			tr[i] = tr[i-1] + i;
			if(tr[i] >= k){
				k -= tr[i-1]; break;
			}
		}
		System.out.println(arr[k-1]);
	}
}
