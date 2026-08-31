import java.util.Scanner;

public class gh {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	int r=sc.nextInt(),t=sc.nextInt();
	sc.nextLine();
	int a[]=new int[t];
	for(int i=0;i<r;i++)
	{
		int p=sc.nextInt();
		//String s=sc.nextLine();
		for(int j=0;j<p;j++)
		{
			int k=sc.nextInt();
			//System.out.println(k);
			a[k-1]=1;
		}
	}
	int e;
	for( e=0;e<t;e++)
	{
		if(a[e]==0)
			break;
	}
	if(e==t)
	{
		System.out.println("YES");

	}
	else
	{
		System.out.println("NO");
		
	}
	}
}