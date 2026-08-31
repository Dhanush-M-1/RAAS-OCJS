import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int count = 0;
		
		while (in.hasNextLine())
		{	
			boolean prime = true;
			int num = in.nextInt();
			in.nextLine();
			
			if (num % 2 == 0 && num != 2)
			{
				prime = false;
			} else {
				for (int i = 3; i * i <= num; i += 2)
				{
					if (num % i == 0)
					{
						prime = false;
					}
				}
			}
			
			if (prime)
			{
				count++;
			}
			
		}
		
		System.out.println(count);
		
	}

}
