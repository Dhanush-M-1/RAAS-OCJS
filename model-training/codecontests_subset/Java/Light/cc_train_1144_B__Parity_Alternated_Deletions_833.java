import java.util.*;
public class _1144B
{
	public static void main(String args[])
	{
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int[] a = new int[n];
		ArrayList<Integer> e = new ArrayList<Integer>();
		ArrayList<Integer> o = new ArrayList<Integer>();
		int i,j,sum=0;
		for(i=0;i<n;i++)
		{
			a[i] = scan.nextInt();
			if(a[i]%2==0)
				e.add(a[i]);
			else
				o.add(a[i]);
		}
		Collections.sort(e);
		Collections.sort(o);
		if(e.size()-o.size()-1>0)
		{
			for(i=0;i<e.size()-o.size()-1;i++)
			{
				sum+=e.get(i);
			}
			System.out.println(sum);
		}
		else if(o.size()-e.size()-1>0)
		{
			for(i=0;i<o.size()-e.size()-1;i++)
			{
				sum+=o.get(i);
			}
			System.out.println(sum);
		}
		else
			System.out.println(0);
	}
}