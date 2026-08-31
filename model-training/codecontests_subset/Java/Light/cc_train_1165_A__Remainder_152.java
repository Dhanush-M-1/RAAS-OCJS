import java.util.*;
import java.lang.*;

public class Remainder 
{
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		String s=sc.next();
		int i,ans=0;
		char[]arr=s.toCharArray();
		for(i=n-1;i>=0;i--)
		{
			if(y>0&&arr[i]=='1')
			{
				ans++;
			}
			if(y==0&&arr[i]=='0')
			{
				ans++;
			}
			if(y<0&&x>0&&arr[i]=='1')
			{
				ans++;
			}
			y--;
			x--;
			if(x==0)break;
		}
		System.out.println(ans);
	}
}