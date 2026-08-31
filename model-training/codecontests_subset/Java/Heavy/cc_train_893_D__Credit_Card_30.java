import java.util.*;


import java.io.*;
 
 
 
public class Main 
{   
	
	static long MOD=(long) (1e9+7);
	public static void main(String[] args) throws IOException 
	{ 
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer s=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(s.nextToken());
		int d =Integer.parseInt(s.nextToken());
		
		 s=new StringTokenizer(br.readLine());
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(s.nextToken());
		}
		long amount=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				if(amount<0)
					amount=0;
			}else {
				amount+=arr[i];
				if(amount>d) {
					pw.println(-1);
					pw.close();
				}
				
			}
		}
		
		
		amount=0;
		int ans=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				if(amount<0) {
					ans++;
					amount=d;
				}
			}else {
				amount+=arr[i];
				if(amount>d)
					amount=d;	
			}
		}
		
		pw.println(ans);
		pw.close();
		
		
	}
	

}