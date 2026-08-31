import java.util.*;

public class Main
{
	public static void main (String [] args)
	{
		
		Scanner sc = new Scanner(System.in);
		int spectator = 3; 
		int total = sc.nextInt();
		for(int i = 0; i < total; i++)
		{
			int num = sc.nextInt();
			if(num == spectator)
			{
				System.out.println("NO");
				return;
			}
			else if(1 != spectator && 1 != num)
			{
				spectator = 1;
			}
			else if(2 != spectator && 2 != num)
			{
				spectator = 2;
			}
			else if(3 != spectator && 3 != num)
			{
				spectator = 3;
			}
		}
		System.out.println("YES");
	}
}