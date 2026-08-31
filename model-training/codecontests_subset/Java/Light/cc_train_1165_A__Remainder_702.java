/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s  =  new Scanner(System.in);
		int n = s.nextInt();
		int x = s.nextInt();
		int y = s.nextInt();
	    String a = s.next();
		int ans=0;
		for(int i=n-1;i>n-1-x;i--){
		    if(i!=n-1-y){
		        if(a.charAt(i)!='0'){
		            ans++;
		        }
		    }
		    else{
		        if(a.charAt(i)!='1'){
		            ans++;
		        }
		    }
		}
		System.out.println(ans);
	}
}
