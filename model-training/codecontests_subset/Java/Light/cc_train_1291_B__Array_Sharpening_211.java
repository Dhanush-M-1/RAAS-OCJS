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
			boolean dec=false,ans=true;
			for(int i=0;i<n-1;i++){
				if(a[i]<a[i+1]&&dec){
					a[i+1]=a[i]-1;
					if(a[i+1]<0){
						ans=false;
						break;
					}
				}
				else if(a[i]>a[i+1]){
					if(i+1>a[i+1]&&!dec){
					    dec=true;
					}
				}
				else if(a[i]==a[i+1]){
				    if(dec){
    					a[i+1]=a[i]-1;
    					if(a[i+1]<0){
    						ans=false;
    						break;
    					}
				    }
				    else{
    					if(i+1>a[i]){
    					    dec=true;
        					a[i+1]=a[i]-1;
        					if(a[i+1]<0){
        						ans=false;
        						break;
        					}
    					}
				    }
				}
			}
			if(ans)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}