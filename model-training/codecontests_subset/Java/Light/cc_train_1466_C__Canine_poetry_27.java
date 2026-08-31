import java.util.*;
import java.io.*;
public class C
{
	public static void main (String[] args) throws java.lang.Exception
	{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  PrintWriter pw=new PrintWriter(System.out);
	  int t = Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
		  
		  long c=0;
	     
	       String s = br.readLine();
	       StringBuffer str=new StringBuffer(s);
	       int n=str.length();
	       for(int i=0;i<n;i++)
	       {
	    	   if(i<n-1)
	    	   {
	    	   if(str.charAt(i)==str.charAt(i+1) && str.charAt(i)>=97 && str.charAt(i)<=122)
	    	   {
	    		   c++;
	    		   str.setCharAt(i+1,'A');
	    		   if(i!=0)
	    			   i--;
	    	   }
	    	   }
	    	   if(i<n-2)
	    	   {
	    		   if(str.charAt(i)==str.charAt(i+2) && str.charAt(i)>=97 && str.charAt(i)<=122)
	    		   {
	    			   c++;
		    		   str.setCharAt(i+2,'B');
	    		   }
	    	   }
	    	   
	    	   
	       }
	       
	      
	       pw.println(c);
	  }
	  pw.flush();
	  
	}
}
