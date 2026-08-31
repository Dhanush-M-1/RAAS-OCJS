import java.util.Scanner;
import java.util.HashSet;

public class P5A 
{
	public static void main(String[] args) 
	{
		Scanner myScanner = new Scanner(System.in);
		HashSet<String> users = new HashSet<String>();
		long count = 0;
		while (myScanner.hasNextLine())
		{
			String s = myScanner.nextLine();
			if (s.charAt(0) == '+')
			{
				users.add(s.substring(1));	
			}
			else if (s.charAt(0) == '-')
			{
				users.remove(s.substring(1));				
			}
			else
			{
				String t[] = s.split(":");
				if (t.length == 2)
				count += t[1].length()*users.size();
			}
		}
		System.out.println(count);
	}

}
