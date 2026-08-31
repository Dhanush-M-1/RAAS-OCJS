import java.util.*;
public final class Games
{
	public static void main(String arg[])
	{
		Scanner br=new Scanner(System.in);
		int n=br.nextInt();
		int c=0;
		int[] l=new int[101];
		int[] r=new int[101];
		for(int i=1;i<=n;i++)
		{
			int a=br.nextInt();
			int b=br.nextInt();
			
			if(l[b]>0)
				c=c+l[b];
			if(r[a]>0)
				c=c+r[a];
			l[a]++;
			r[b]++;
		}
		System.out.println(c);
	}
}