import java.util.*;
public final class BookReading
{
	public static void main(String[] args) {
		
		Scanner br=new Scanner(System.in);
		int n=br.nextInt();
		int m=br.nextInt();
		int[] s=new int[1010];
		int[] d=new int[1010];
		int[] w=new int[510];
		ArrayList<Integer> list=new ArrayList<Integer>();
		for (int i=1;i<=n;i++)
			w[i]=br.nextInt();
		for(int i=1;i<=m;i++)
		{	d[i]=br.nextInt();
			if(s[d[i]]==0)
				{
					list.add(d[i]);
					s[d[i]]=1;
				}
		}
		
		int j=0,tot=0;
		for(int i=1;i<=m;i++)
		{	j=0;
			int f=d[i];
			while(list.get(j)!=f)
			{
				tot+=w[list.get(j)];
				j++;
			}
			int book=list.remove(j);
			list.add(0,book);

		}
		System.out.println(tot);


		
	}
} 