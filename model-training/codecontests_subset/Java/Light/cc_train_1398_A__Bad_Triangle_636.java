import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner cin=new Scanner(System.in);
		int[] a=new int [100010];
		int t,n;
		t=cin.nextInt();
		while(t!=0)
		{
			n=cin.nextInt();
			for(int i=1;i<=n;++i)
			a[i]=cin.nextInt();
			if(a[1]+a[2]>a[n])
			System.out.println("-1");
			else
			System.out.println("1 2 "+n);
			t--;
		}
	}
}
