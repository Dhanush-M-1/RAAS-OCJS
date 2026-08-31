import java.util.*;

public class Main 
{
	static long arr[];
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		String first, second, temp1, temp2;
		int n;
		first = scanner.next();
		second = scanner.next();
		n = scanner.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println(first + " " + second);
			temp1 = scanner.next();
			temp2 = scanner.next();
			if(temp1.equals(first))
				first=temp2;
			else
				second = temp2;
			
		}
		System.out.println(first + " " + second);
		scanner.close();
	}
}
