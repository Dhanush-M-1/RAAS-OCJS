import java.util.*;
public class  VA593
{
	public static void main(String[] args)
	{
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
	   while(t>0)
	   {
		int a=s.nextInt();
		int b=s.nextInt();
		int c=s.nextInt();
		int ans=0;
		int k=0;
		if(c/2<b)
		{
		  k=c/2;
		  ans+=3*k;
		  b-=k;
		  ans+=3*Math.min(a,b/2);
		}
		else
		{
		  k=b;
		  ans+=3*k;
		  
		}
		System.out.println(ans);
		t--;
	   }
	}
}
