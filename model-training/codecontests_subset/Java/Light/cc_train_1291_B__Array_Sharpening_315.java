/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class GFG {
    
	public static void main (String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine().trim());
		while(t--!=0){
			int n=Integer.parseInt(br.readLine().trim());
    		String s=br.readLine().trim();
    		String ss[]=s.split("\\s+");
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=Integer.parseInt(ss[i]);
			if(n==1){
				System.out.println("Yes");
				continue;
			}
			boolean ans=!(n%2==0&&a[n/2]==n/2-1&&a[n/2-1]==a[n/2]);
			for(int i=0;i<n;i++){
				if(a[i]<Math.min(i,n-i-1))
					ans=false;
			}
			if(ans)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}