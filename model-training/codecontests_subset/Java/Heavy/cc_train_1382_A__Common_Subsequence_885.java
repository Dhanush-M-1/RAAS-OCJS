
import java.util.*;
public class Practice
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			Set<Integer> st=new LinkedHashSet<Integer>();
			Set<Integer> st1=new LinkedHashSet<Integer>();
			while(n-->0)
				st.add(sc.nextInt());
			while(m-->0)
				st1.add(sc.nextInt());
				if(st.size()>=st1.size())
				{
					st.retainAll(st1);
					if(st.size()!=0)
					{
						System.out.println("YES");
						System.out.print("1 ");
						for(int i:st)
						{
							System.out.println(i+" ");
							break;
						}
					}
					else
						System.out.println("NO");
				}
				else
				{
					st1.retainAll(st);
					if(st1.size()!=0)
					{
						System.out.println("YES"+" ");
						System.out.print("1 ");
						for(int i:st1)
						{
							System.out.println(i+" ");
						break;
						}
					}
					else
						System.out.println("NO ");
				}
		}
		
	}
}