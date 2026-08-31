import java.util.Scanner;
public class ArraySharpening {

	public static void main(String[] args) {
		Scanner obj=new Scanner(System.in);
		int t=obj.nextInt();
		while(t-->0)
		{
			int n=obj.nextInt();
			int prefix=0,sufix=0;
			int[] a=new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]=obj.nextInt();
			}
			for(int i=0;i<n;i++)
			{
				if(!(a[i]>=i))
				{
					break;
				}
				prefix=i;
			}
			for(int i=n-1;i>=0;i--)
			{
				if(!(a[i]>=(n-1)-i))
				{
					break;
				}
				sufix=i;
			}
			//System.out.println(prefix);
			//System.out.println(sufix);
			if(sufix<=prefix)
			{
				System.out.println("YES");
			}
			else
				System.out.println("NO");
		}
	}

}
