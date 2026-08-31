

import java.util.Scanner;

public class Demo {
	
	
	
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		
		int t= in.nextInt();
		
		for(int i =0;i<t;i++)
		{
			int n =in.nextInt();

			if(n==1)
			{
				System.out.println("0");
				continue;
			}
			
			int ans =0;
			
			while(n%3==0)
			{
				ans++;
				n =n/3;
			}
			
			if((int)(Math.log(n)/Math.log(2))== Math.log(n)/Math.log(2))
			{
				
					int twos =(int)(Math.log(n)/Math.log(2));
					
					if(ans>=twos)
					{
						System.out.println((ans-twos)+ans);
					}
					else {
						System.out.println("-1");
					}
					
				
				
			}
			else {
				System.out.println("-1");
			}
		}
		
	}

}
