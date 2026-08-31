import java.util.Arrays;
import java.util.Scanner;

public final class p3 {

	public static void main(String[] args) {

		Scanner a = new Scanner(System.in);
		int n =a.nextInt();
		int m =a.nextInt();
		int [] A =new int[n];
		int [] B =new int[n];
		for(int i=0;i<n;i++)
		{
			A[i]=a.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			B[i]=a.nextInt();
		}
		int [] x =new int[n];
		for(int i=0;i<n;i++)
		{
			x[i]= (B[0]-A[i]+m)%m;
		}
		Arrays.sort(B);
		Arrays.sort(x);
		//for(int i=0;i<n;i++)
		//{
		//	System.out.println(x[i]);
		//}
		int [] temp = new int[n];
		int flag = 0;
		for(int j=0;j<n;j++)
		{
			//int [] temp = new int[n];
			flag =0;
			for(int i=0;i<n;i++)
			{
				temp[i]=(A[i]+x[j])%m;
			}
			Arrays.sort(temp);
			for(int i=0;i<n;i++)
			{
				if(temp[i]!=B[i])
				{
					flag =1;
					break;
				}
			}
			if(flag ==0)
			{
				System.out.println(x[j]);
				break;
			}
			
		}
		
		
	a.close();}

}
