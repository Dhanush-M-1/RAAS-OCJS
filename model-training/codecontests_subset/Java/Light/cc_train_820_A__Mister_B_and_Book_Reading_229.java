import java.util.*;

public final class sar
{
	public static void main(String[] args)
	{	  
		Scanner sc=new Scanner(System.in);
		
		int c=sc.nextInt();
		int v0=sc.nextInt();
		int v1=sc.nextInt();
		int a=sc.nextInt();
		int l=sc.nextInt();
		
		int pos = v0;
		int t = 1;
		
		int add = v0;
		
		while(pos < c)
		{	add = Math.min(v1, add + a);
			pos += add - l;
			t++;
		}
		System.out.println(t);
	}
}