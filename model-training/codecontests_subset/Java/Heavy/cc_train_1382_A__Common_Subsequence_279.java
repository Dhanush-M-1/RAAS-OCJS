import java.util.*;
public class CS{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int i=0;i<t;i++)
		{
			int n=sc.nextInt();
		                  int m=sc.nextInt();
			ArrayList<Integer> a=new ArrayList<Integer>();
			ArrayList<Integer> b=new ArrayList<Integer>();
			ArrayList<Integer> c1=new ArrayList<Integer>();
			for(int j=0;j<n;j++)
				a.add(sc.nextInt());
			for(int j=0;j<m;j++)
				b.add(sc.nextInt());
		
			int c=0,prevk=-1,prevf=-1;
		for(int k=0;k<n;k++)
		{
			if(b.contains(a.get(k)) )
			{
				
				int f=b.indexOf(a.get(k));
				if(c==0)
				{
					c++;
					c1.add(a.get(k));
					prevk=k;
					prevf=f;
					break;
				}
				else 
				{
					if(k>prevk && f>prevf)
					{
					c++;
					c1.add(a.get(k));
					prevk=k;
					prevf=f;
					}
				}
				
			}
		}
		if(c>0)
		{
			System.out.println("YES");
			
			System.out.print(c+" ");
			
				System.out.print(c1.get(0));
			System.out.print("\n");
		}
		else
			System.out.println("NO");
		}	
	}
}