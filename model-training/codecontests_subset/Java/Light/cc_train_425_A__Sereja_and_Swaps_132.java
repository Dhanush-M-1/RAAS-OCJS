import java.io.*;
import java.util.*;
public final class sereja_and_swaps
{
	static Scanner sc=new Scanner(System.in);
	static PrintWriter out=new PrintWriter(System.out);
	
	public static void main(String args[]) throws Exception
	{
		int n=sc.nextInt(),k=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			int sum=0;
			List<Integer> list=new ArrayList<Integer>();
			for(int j=i;j<n;j++)
			{
				sum+=a[j];
				int sum1=sum;
				list.add(a[j]);
				List<Integer> list1=new ArrayList<Integer>(list);
				List<Integer> list2=new ArrayList<Integer>();
				for(int l=0;l<n;l++)
				{
					if(l<i || l>j)
					{
						list2.add(a[l]);
					}
				}
				int k2=0;
				Collections.sort(list1);
				Collections.sort(list2,Collections.reverseOrder());
				while(k2<k && list1.size()>0 && list2.size()>0)
				{
					int elem1=list1.remove(0);
					sum1-=elem1;
					int elem2=list2.remove(0);
					sum1+=elem2;
					k2++;
				}
				while(k2<k && list1.size()>1 && list1.get(0)<0)
				{
					sum1-=list1.remove(0);
					k2++;
				}
				if(sum1>max)
				{
					max=sum1;
				}
			}
		}
		out.println(max);
		out.close();
	}
}
