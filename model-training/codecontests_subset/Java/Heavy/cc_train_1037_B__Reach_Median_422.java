import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * 
 * Comments Here
 * 
 */
public class C1037_B
{
	static BufferedReader br; 
	static BufferedWriter bw; 
	static StringTokenizer st;

	public static void main(String[] args) throws java.lang.Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
    		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long s = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		long[] arr = new long[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int ind = n/2;
		long mid_val = arr[ind];
		
		long moves = 0;
		if(mid_val > s) {
			
			while(ind >= 0) {
				if(arr[ind] > s){
					moves += (arr[ind]-s);
					--ind;
				} else
					break;
			}
			
		} else if(mid_val < s) {
			
			while(ind < n) {
				if(arr[ind] < s){
					moves += (s-arr[ind]);
					++ind;
				} else
					break;
			}
			
		} 
		
		bw.write(moves + "\n");
		
		br.close();
		bw.close();
	}
	

	
	
}

