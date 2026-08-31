import java.util.*;
import java.io.*;
public class Main {
public static void main(String [] args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int k = Integer.parseInt(st.nextToken());
	int array[] = new int[n];
	st = new StringTokenizer(br.readLine());
	for(int i = 0;i < n;i++){
		array[i] = Integer.parseInt(st.nextToken());
	}
	Arrays.sort(array);
	
	int big = n%k,small = k - n%k;
	int bigLen = n/k + 1,smallLen = n/k;
	
	int dp[][] = new int[small + 1][big + 1];
	
	for(int i = 0;i <= small;i++)
		Arrays.fill(dp[i],Integer.MAX_VALUE);
		
	dp[0][0] = 0;
	for(int i = 0;i <= small;i++){
		for(int j = 0;j <= big;j++){
			int pos = i*smallLen + j*bigLen;
			if(dp[i][j] == Integer.MAX_VALUE)continue;
			//System.out.println(pos + " " + (pos - smallLen));
			if(i + 1 <= small)
			dp[i + 1][j] = Math.min(dp[i + 1][j],dp[i][j] + array[pos - 1 + smallLen] - array[pos]);
			if(j + 1 <= big)
			dp[i][j + 1] = Math.min(dp[i][j + 1],dp[i][j] + array[pos - 1 + bigLen] - array[pos]);	                   
		}
	}
	System.out.println(dp[small][big]);
}
}
    