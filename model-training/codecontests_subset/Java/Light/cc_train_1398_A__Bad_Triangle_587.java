import java.util.*;
public class BadTriangle {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int t1=1;t1<=t;t1++)
		{
			int n=sc.nextInt();
			long a[]=new long[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextLong();
			int flag=0,z=0;
			long x=a[0];
			long y=a[1];
			for(int i=2;i<n;i++)
			{
				
					if(x+y<=a[i])
						{
							
							z=i+1;
							flag=1;
							break;
						}
					
			}
			if(flag==1)
			System.out.println(1+" "+2+" "+z);
			else
				System.out.println(-1);	
		}
	}
}
