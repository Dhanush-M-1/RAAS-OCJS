import java.util.*;

public class Solution
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int q=in.nextInt();
		for(int i=0;i<q;i++)
		{
			int l=in.nextInt();
			int r=in.nextInt();
			int d=in.nextInt();
			if(l-d>0)
				System.out.println(d);
			else
			{
				if(r<d)
				{
					System.out.println(d);
				}
				else
				{
					if(r%d==0)
					{
						System.out.println(r+d);
					}
					else
					{
						System.out.println(((r/d)+1)*d);
					}
				}
			}
		}
	}
}
