

import java.util.Scanner;

public class Stones {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int t = reader.nextInt();
		int count;
		int a,b,c;
		for(int i = 0; i < t; i++)
		{
			a = reader.nextInt();
			b = reader.nextInt();
			c = reader.nextInt();
			count = 0;
			if(b >= c/2)
			{
				count += 3* (int)(c/2);
				b -= c/2;
			}
			else
			{
				count += 3*b;
				b = 0;
			}				
			if(b >= 2 && a >= 1)
			{
				
				count += 3*Math.min(a,b/2);
			}
			System.out.println(count);
		}
		
		
		
		
		
		
			
	}

}
