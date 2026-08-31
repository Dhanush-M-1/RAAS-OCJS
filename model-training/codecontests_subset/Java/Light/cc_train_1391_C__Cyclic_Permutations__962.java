import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args)throws Exception
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter pw=new PrintWriter(System.out);
	    long n=Long.parseLong(br.readLine());
	   long m=1000000000l;
	   m+=7;
	   //long m=7l;
	    long x=1l;
	    for(long i=2l;i<=n;i++)
	    {
	        x*=i;
	        x=x%m;
	    }
	    long minus=1l;
	    long two=2l;
	    for(long i=1l;i<=n-1l;i++)
	    {
	        minus*=two;
	        minus=minus%m;
	    }
	    long ans=(x-minus);
	    if(ans<0l)
	    {
	        ans+=m;
	    }
	    
	    pw.println(ans);
	    pw.flush();
	}
	
}
