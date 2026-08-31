import java.util.*;

public class CommonSubsequence {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int t1=1;t1<=t;t1++)
		{
			int maxl=0,maxno=0,min=1000;
			
			int n=sc.nextInt();
			int m=sc.nextInt();
			int a[]=new int[n];
			int b[]=new int[m];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			for(int i=0;i<m;i++)
				b[i]=sc.nextInt();
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					if(a[i]==b[j])
						maxl++;
					
				}
				if(min>maxl && maxl!=0)
				{
					min=maxl;
				    maxno=a[i];
				}
			}
			if(min==1000)
				System.out.println("NO");
			else
			{
				System.out.println("YES");
				System.out.println(1+" "+maxno);
				
			}
				
		}
	}
}
