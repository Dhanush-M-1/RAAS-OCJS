import java.io.*;
import java.util.*;
import java.math.*;
 
public class codeforces
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int one=0,two=0,sum=0;;
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
        	   a[i] = sc.nextInt();
        	   if(a[i]==100)
        	   {
        	   	     one++;
        	   }
        	   else
        	   {
        	   	     two++;
        	   }
        	   sum+=a[i];
        }
        boolean ans=false;
        sum=sum/100;
        // System.out.println(sum);
        // System.out.println("one = "+one);
        // System.out.println("two = "+two);
        
        if(sum%2==0)
        {
        	    if(two==0)
        	    {
        	    	   ans=true;
        	    }
        	    else 
        	    {
        	             if(one>0)
        	             {
            	           if(one%2==0)
            	           {
            	                 ans=true;
            	           }
        	             }
        	             else
        	             {
        	                  if(two%2==0)
        	                  {
        	                        ans=true;
        	                  }
        	             }
        	    }
        }
        if(ans)
        {
        	  System.out.println("YES");
        }
        else
        {
        	  System.out.println("NO");
        }

   
     




    
   

    }

}