import java.util.*;
	public class RunForYourPrize 
	{
	 public static void main(String args[])
	    {
	        
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int l=(int)Math.pow(10,6);
	    int a1=0,a2=l;
	    for(int i=0;i<n;i++)
	    {
	    	 int num=sc.nextInt();
	        if(num<=(l/2) && num>a1)
	        a1=num;
	        else if(num>(l/2) && num<a2)
	        a2=num;
	    }
	    System.out.println(Math.max(a1-1,l-a2));
	}
	}