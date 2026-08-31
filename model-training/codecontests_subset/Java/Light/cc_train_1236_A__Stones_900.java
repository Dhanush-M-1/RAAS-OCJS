

import java.util.Scanner;

public class Stones {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int t = reader.nextInt();
		int count;
		for(int i = 0; i < t; i++)
		{
			int a = reader.nextInt();
			int b = reader.nextInt();
			int c = reader.nextInt();
			count = 0;
			while(true)
			{
				if(b >= 2 && a >= 1 && b > c)
				{
					count += 3;
					b -= 2;
					a--;
				}
				else if(b >= 1 && c >= 2)
				{
					count += 3;
					c -= 2;
					b--;
				}
				else
					break;
			}
			System.out.println(count);
		}
		
		
		
		
			
	}

}
