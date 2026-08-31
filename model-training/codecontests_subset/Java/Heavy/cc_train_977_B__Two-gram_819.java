import java.util.*;
public class Twogram
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n,i,max=-1,count=0,j;
		String str,nm="",z="",k="";
		char x;
		n=sc.nextInt();sc.nextLine();
		str=sc.nextLine();
		for(i=0;i<str.length()-1;i++)
		{
		    nm=str.substring(i,i+2);
		    count=0;
		    //System.out.println("nm is"+nm);
		    for(j=0;j<str.length()-1;j++)
		    {
		        k=str.substring(j,j+2);
		        if(k.equals(nm))
		        count++;
		        //System.out.println("k is "+k);
		        
		    }
		    //System.out.println("count is "+ count+"max is"+max);
		    if(count>=max)
		    {
		        max=count;
		        z=nm;
		    }
		}
		System.out.println(z);
	}
	
}