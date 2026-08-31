import java.util.*;
import java.io.*;

public class Solution{
	public static void main (String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String[] temp=br.readLine().trim().split(" ");
		
		int numTestCases=Integer.parseInt(temp[0]);
		while(numTestCases-->0) {
			temp=br.readLine().trim().split(" ");
			int n=Integer.parseInt(temp[0]);
			int[][] arr=new int[n][2];
			for(int i=0;i<n;i++) {
				temp=br.readLine().trim().split(" ");
				arr[i][0]=Integer.parseInt(temp[0]);
				arr[i][1]=Integer.parseInt(temp[1]);
			}
			
			int prevPlays=0,prevClears=0;
			int i=0;
			for(;i<n;i++) {
				int plays=arr[i][0];
				int clears=arr[i][1];
				int diffPlays=plays-prevPlays;
				int diffClears=clears-prevClears;
				if(diffClears>diffPlays)
				{
					out.println("NO");
					break;
				}
				if(diffPlays<0 || diffClears<0) {
					out.println("NO");
					break;
				}
				prevPlays=plays;
				prevClears=clears;
			}
			if(i==n) {
				out.println("YES");
			}
		}
		
		out.flush();
		out.close();
	}
	
}