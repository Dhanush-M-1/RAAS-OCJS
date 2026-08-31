import java.io.*;
import java.util.*;

public class problemB {
		public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int arr [] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long ans = 0;
		for(int i = 0;i<=n/2;i++){
			if(arr[i]>s) ans+=arr[i]-s;
		}
		for(int i = n/2;i<n;i++){
			if(arr[i]<s) ans+=s-arr[i];
		}
		System.out.println(ans);
		
	}
}