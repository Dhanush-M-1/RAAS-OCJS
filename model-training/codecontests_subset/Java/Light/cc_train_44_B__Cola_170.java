import java.util.Scanner;
public class Cola44B
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int ans =0 ,ck =0 ;
		for(int i=0;i<=c;i++)
		{
			for(int j=0;j<=b;j++)
			{
				ans = (n -2*i-j)*2;
				if(ans>=0 && ans<=a)
					ck++;
			}
		}
		System.out.println(ck);
	}
}