import java.util.Scanner;
public class B670 {
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		double k= sc.nextInt();
		double identifier[]=new double[n+1];
		int temp=0;
		for(int i=1; i<=n; i++)
		{
			identifier[i]=sc.nextInt();
			if (temp+i<k)
			{
				temp+=i;
			}
		}
		System.out.println((int)identifier[(int) (k-temp)]);
	}
}
