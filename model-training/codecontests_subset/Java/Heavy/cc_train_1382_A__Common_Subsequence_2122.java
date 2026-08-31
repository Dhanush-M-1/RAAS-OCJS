import java.util.*;
public class subseq
{
	public static void main(String[] args) {
		int t,i,j,l=0,bc=0,m=0;
		Scanner sc = new Scanner(System.in);
		t=sc.nextInt();
		for(i=0;i<t;i++)
		{
			int l1=sc.nextInt();
			int l2= sc.nextInt();
			int a[]= new int[l1];
			int b[]= new int[l2];
			for(j=0;j<l1;j++)
			{
				a[j] = sc.nextInt();
			}
			for(j=0;j<l2;j++)
			{
				b[j] = sc.nextInt();
			}
			for(int k = 0;k<l2;k++)
			{

			for(j=0;j<l1;j++)
			{
             if(a[j]==b[k])
             {
             	l=1;
                m=a[j];
             	bc++;
             	
             }
			}
		}
		if(bc==0)
			System.out.println("NO");
		else
		{
			System.out.println("YES");
			System.out.println(l+" "+m);
		}
		bc=0;m=0;
	}
}
}