import java.util.*;

public class GFG 
{
	public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int N=sc.nextInt();
	    String s=sc.next();
	    int f=0;
	    int i=0;
	    for(i=0;i<s.length()-1;i++)
	    {
	        char c=s.charAt(i);
	        char ch=s.charAt(i+1);
	        if(c>ch)
	        {
	            f=1;
	            break;
	        }
	    }
	    int j=i;
	    for(j=i+1;j<s.length()-1;j++)
	    {
	        char c=s.charAt(j);
	        char ch=s.charAt(j+1);
	        if(c<ch)
	        {
	            break;
	        }
	    }
	    if(f==1)
	    {
	        System.out.println("YES "+(i+1)+" "+(j+1));
	    }
	    else
	    {
	        System.out.println("No");
	    }
	}
}