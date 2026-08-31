import java.util.*;

public class stones 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
    		int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
    		int a1=a;
    		int b1=b;
    		int c1=c;
    		int count=0,ans=0;
    		
    		while(b>=1 && c>=2)
    		{
    		    ans += 3;
    		    b--;
    		    c -= 2;
    		}
    		while(a>=1 && b>=2)
    		{
    		    ans += 3;
    		    a--;
    		    b -= 2;
    		}
    		count = ans;
    		ans=0;
    		while(a>=1 && b>=2)
    		{
    		    ans += 3;
    		    a--;
    		    b -= 2;
    		}
    		while(b>=1 && c>=2)
    		{
    		    ans += 3;
    		    b--;
    		    c -= 2;
    		}
    		int max = Math.max(ans,count);
    		System.out.println(max);
		}
	}
}