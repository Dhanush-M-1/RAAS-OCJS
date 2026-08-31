

import java.util.Scanner;

public class NewYearCandles {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int total=a;
		int q=a;
		boolean status=true;
		while(status)
		{
			int c=q;
			q=q/b;
			if(q==0)
			{
				break;
			}
			else
			{
				total=total+q;
				int rem=c%b;
				q=q+rem;
			}
		}
		System.out.println(total);
		sc.close();
	}

}
