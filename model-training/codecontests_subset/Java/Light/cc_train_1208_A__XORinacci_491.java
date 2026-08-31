
import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Dynamic_programming 
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)) ;
		
			int t=Integer.parseInt(br.readLine());
		    while(t-->0) 
		    {
		    	String line[]=br.readLine().split(" ");
			    
		    	int a=Integer.parseInt(line[0]);
		    	int b=Integer.parseInt(line[1]);
		    	int n=Integer.parseInt(line[2]);
		         
		    	if((n)%3==0)
		          System.out.println(a);
		    	else if (n%3==1)
		    		System.out.println(b);
		    	else if (n%3==2)
		    		System.out.println(a^b);
		    }
		    
		
	}
	

}
