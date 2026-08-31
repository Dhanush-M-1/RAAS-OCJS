import java.util.*;
public class Stones{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int count = 0;
			int flag = 1;
			while(flag==1)
			{
				if(b>=1&&c>=2)
				{
					count = count+3;
					b = b-1;
					c = c-2;
				}
				else if(a>=1&&b>=2)
				{
					count = count+3;
					a=a-1;
					b=b-2;
				}
				else
					flag=0;
			}
			System.out.println(count);
			t--;
		}
	}
}