import java.util.*;
public class QA
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int ans = -1;
			ArrayList<Integer> a = new ArrayList<Integer>();
			ArrayList<Integer> b = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
			{
				int x = sc.nextInt();
				a.add(x);
			}
			for(int i=0;i<m;i++)
			{
				int x = sc.nextInt();
				b.add(x);
			}
			if(n<=m)
			{
				for(int i=0;i<n;i++)
				{
					if(b.indexOf(a.get(i))>=0)
					{
						ans = a.get(i);
						System.out.println("YES");
						System.out.println("1 "+ans);
						break;
					}
				}
			}
			else
			{
				for(int i=0;i<m;i++)
				{
					if(a.indexOf(b.get(i))>=0)
					{
						ans = b.get(i);
						System.out.println("YES");
						System.out.println("1 "+ans);
						break;
					}
				}
			}
			if(ans==-1)
				System.out.println("NO");
			t--;
		}
	}
}