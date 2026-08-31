/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t--!=0){
		    int n = Integer.parseInt(br.readLine());
		    boolean flag= true;
		    int pprev=0,cprev=0;
		    for(int i=0;i<n;i++){
		        String[] in  = br.readLine().split(" ");
		        int p = Integer.parseInt(in[0]);
		        int c = Integer.parseInt(in[1]);
		        if(c>p || p<pprev || c<cprev){
		            flag= false;
		        }
		        if(p-pprev<c-cprev){
		            flag=  false;
		        }
		        pprev = p;
		        cprev= c;
		    }
		    if(flag){
		        System.out.println("YES");
		    }
		    else{
		        System.out.println("NO");
		    }
		}
	}
}
