import java.io.*;
import java.util.*;
public class Main
{
    
	public static void main(String[] args) throws Exception
	{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine());
	    for(int i=0;i<t;i++)
	    {
	        String s=br.readLine();
	        String ss[]=s.split(" ");
	        int a=Integer.parseInt(ss[0]);
	        int b=Integer.parseInt(ss[1]);
	        int n=Integer.parseInt(ss[2]);
	        if(n%3==0)
	        {
	            System.out.println(a);
	            continue;
	        }
	        if(n%3==1)
	        {
	            System.out.println(b);
	            continue;
	        }
	        else
	        {
	            System.out.println(a^b);
	        }
	    }
	}
}
