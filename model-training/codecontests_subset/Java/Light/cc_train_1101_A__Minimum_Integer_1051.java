import java.util.*;
public class R58a
{
	public static void main(String ag[])
	{
		Scanner sc=new Scanner(System.in);
		int t,n,i,j,l,r,d;
		t=sc.nextInt();
		while(t-->0)
		{
			l=sc.nextInt();
			r=sc.nextInt();
			d=sc.nextInt();
			if(d<l)
			{
				System.out.println(d);
			}
			else
			{
				int k=r/d;
				System.out.println((k+1)*d);
			}
		}
	}
}