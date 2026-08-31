import java.util.*;
public class Main
{
	
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		ArrayList <Integer> a=new ArrayList();
		ArrayList <Integer> b=new ArrayList();
		ArrayList <Integer> c=new ArrayList();
		for(int i=0;i<n;i++)
		{
			int t=sc.nextInt();
			int x=sc.nextInt();
			int y=sc.nextInt();
			if(x==1 && y==1)
				a.add(t);
			else if(x==1 && y==0)
				b.add(t);
			else if(x==0 && y==1)
				c.add(t);
		}
		Collections.sort(b);
		Collections.sort(c);
		int j=0;
		while(j<b.size() && j<c.size())
		{
			a.add(b.get(j)+c.get(j));
			j++;
		}
		Collections.sort(a);
		if(a.size()<k)
				System.out.println(-1);
		else
		{
			int sum=0;
			for(int i=0;i<k;i++)
				sum+=a.get(i);
			System.out.println(sum);
		}
		
	}
}