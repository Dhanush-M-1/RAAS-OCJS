import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner ss=new Scanner(System.in);
    	long a,s,c=0,val;
    	a=ss.nextLong();
    	s=ss.nextLong();
    	long l[]=new long[(int)a];
    	int i;
    	for(i=0;i<a;i++)
    	{
    	    l[i]=ss.nextLong();
    	}
    	Arrays.sort(l);
    	val=l[(int)a/2];
    	if(val<s)
    	{
    		for(i=(int)a/2;i<a;i++)
    		{
    			if(l[i]<s)
    			{
    				c+=(s-l[i]);
    			}
    			else
    			{
    				break;
    			}
    		}
    	}
    	else
    	{
    		for(i=(int)a/2;i>=0;i--)
    		{
    			if(l[i]>s)
    			{
    				c+=(l[i]-s);
    			}
    			else
    			{
    				break;
    			}
    		}
    	}
    	System.out.println(c);
	}
}
