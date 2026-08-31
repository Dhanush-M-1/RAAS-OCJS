import java.util.Scanner;

public class newyearscandles {
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int val = scan.nextInt();
		
		int ans = total;
		
		int remainder = 0;
		
		boolean eh = true;
		while(eh)
		{
			ans += total / val;
			remainder = total % val;
			total = (total / val) + remainder;
			
			if(total < val)
			{
				eh = false;
			}
		}
		
		System.out.println(ans);
	}
}
