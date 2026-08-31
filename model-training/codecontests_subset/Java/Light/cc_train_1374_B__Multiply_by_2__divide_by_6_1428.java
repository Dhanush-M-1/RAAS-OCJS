import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int z = 0; z < t; z++)
		{		
			int n= sc.nextInt();
			int n2=0;
			int n3=0;
			
			while(n>1)
			{
				if(n%2==0)
				{
					n/=2;
					n2++;
				}
				else if(n%3==0)
				{
					n/=3;
					n3++;
				}
				else
				{
					n3=-1;
					break;
				}
			}	
			
			if(n3>=n2)
				System.out.println(n3-n2+n3);
			else
				System.out.println("-1");
		}
	}
}