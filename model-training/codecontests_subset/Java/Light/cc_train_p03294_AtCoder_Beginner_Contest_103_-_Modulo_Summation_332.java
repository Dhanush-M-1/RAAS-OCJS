import java.util.Scanner;

public class Main{

	public static void main(String[] args) 
	{
		Scanner s =new Scanner(System.in);
		int n = s.nextInt();
		int number[] = new int[n];
		long sum = 0;
		for(int i = 0 ; i<n; i++)
		{
			number[i] = s.nextInt();
			sum = sum  + number[i];
		}
		System.out.println(sum - n);
	
	}

}
