/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
//System.out.println();
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int T = 0; T < t; T++) {
		    int n = Integer.parseInt(br.readLine());
		    int pp = 0;
		    int pc = 0;
		    boolean flag = true;
		    for(int i = 0; i < n; i++) {
		        String s[] = br.readLine().split(" ");
		        int cp = Integer.parseInt(s[0]);
		        int cc = Integer.parseInt(s[1]);
		        
		        if(i == 0){
		            if(cp < cc) {
		                flag = false;
		            }
		        }else {
		            if(cp < cc) {
		                flag = false;
		            }
		            
		            if(pp > cp || pc > cc || (cp - pp) < (cc - pc)) {
		                flag = false;
		            }
		        }
		        
		        pp = cp;
		        pc = cc;
		    }
		    
		    if(flag)
		    System.out.println("YES");
		    else
		    System.out.println("NO");
		    
		}
		
		
		
	}

}
