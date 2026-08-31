/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG {
	public static void main (String[] args) {
		int flag=0;
		Scanner ss = new Scanner(System.in);
		String pass= ss.next();
	    int n= ss.nextInt();
	    String s = new String();
	    for(int i=0;i<n;i++)
	    {   String s1=ss.next();
	    	s+=s1;
	    	  }
	    if(pass.equals(s))
	    {
	        System.out.print("YES");
	        System.exit(0);
	    }
	   int c=0;
	    
	    for(int i=0;i<s.length()-1;i+=2)
	    { 
	        String h=s.substring(i,i+2);
	    	 
	    	 if(pass.equals(h))
	          {
	            System.out.print("YES");
	            System.exit(0);
	          }
	    	if(h.charAt(1)==pass.charAt(0)&&c==0)
	    	{  
              flag++;c++;
	    	}
	    }
	    if(flag<1){System.out.print("NO");System.exit(0);}
	    	 for(int i=0;i<s.length()-1;i+=2)
	    { String h=s.substring(i,i+2);
	    	if(h.charAt(0)==pass.charAt(1))
	    	{  
              flag++;break;
	    	}
	   	 }
	    	 
	   if(flag>1){System.out.print("YES");System.exit(0);}
	    System.out.print("NO");
	    
	}  
}