import java.util.*;

public class Yash 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int ans = 0;
			if(c/2 < b)
			{
				ans+= 3*(c/2);
				b-=c/2;
			}
			else
			{
				ans+= 3*b;
				b = 0;
			}
			if(b/2 < a)
				ans+= 3*(b/2);
			else
				ans+= 3*a;
			
			System.out.println(ans);
		}
	}
}