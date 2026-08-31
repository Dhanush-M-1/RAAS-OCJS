import java.util.Scanner;

/*

12
***.********

 */

public class a {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		String line = in.next();
		
		int count = 0;
		
		for(int start = 0; start < n && count < 5; ++start)
		{
			for(int len = 1; len+start <= n && count < 5; ++len)
			{
				int c = 0;
				for(int jump = 0; jump <= (n-start) / len && jump <= 5 && start + len*jump < n && line.charAt(start + len*jump) == '*'; ++jump)
				{
					//System.out.println("Start: "+start +", len: "+len +", jump: "+jump);
					++c;
				}
				count = Math.max(c, count);
			}
		}
		
		if(count > 4)
			System.out.println("yes");
		else
			System.out.println("no");
		
		in.close();
	}

}
