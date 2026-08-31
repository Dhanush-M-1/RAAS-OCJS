import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int b, count = 0;
		for(int i = 0; i < n; i++)
		{
			if( isPrime( input.nextInt() ) )
				count++;
		}
		
		System.out.println(count);
	}

	private static boolean isPrime(int num)
	{
		if (num == 2 ) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
    	return true;
	}
}