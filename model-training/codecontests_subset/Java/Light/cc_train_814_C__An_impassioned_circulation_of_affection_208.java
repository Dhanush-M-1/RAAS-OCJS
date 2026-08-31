import java.io.*;
import java.util.*;

public class Garland {
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		int[]garland  = new int[N];
		for(int i = 0; i<N; i++) {
			garland[i] = str.charAt(i)-'a'; 
		}
		
		int[][]ans = new int[26][N+1];
		
		for(int i = 0; i<26; i++) {			
			for(int j = 1; j<=N; j++) {
				
				int max = 0;
				int replaced = 0;
				int right = 0;
				
				for(int left = 0; left<N; left++) {
					while(right<N && replaced<=j) {
						if(garland[right]!=i){
							replaced++;
						}
						if(replaced<=j)right++;
					}
					replaced--;
					if(right-left>max) {
						max = right-left;
					}
					if(garland[left]!=i)replaced--;
				}
				
				ans[i][j]=max;
			}
			
		}
		
				
		int Q = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		
		for(int i= 0; i<Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int c = st.nextToken().charAt(0)-'a';
			
			sb.append(ans[c][m]+"\n");
			
			
		}
		System.out.println(sb.toString());
		
	}
}
