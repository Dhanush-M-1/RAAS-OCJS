import java.io.*;
import java.util.*;

public class officeKeys {
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		long[]people = new long[N];
		long[]keys = new long[K];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<K; i++) {
			keys[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(people);
		Arrays.sort(keys);
		
		
		long min = Long.MAX_VALUE;
		for(int i = 0;i<=K-N; i++) {
			long greatest = 0;
			for(int j = 0; j<N && greatest<min; j++) {
				greatest= Math.max(greatest, Math.abs(people[j]-keys[i+j])+Math.abs(keys[i+j]-P));
			}
			
			if(greatest<min) {
				min = greatest;
			}
		}
		
		System.out.println(min);
	}
}
