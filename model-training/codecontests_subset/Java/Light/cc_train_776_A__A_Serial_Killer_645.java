import java.util.*;

public class SerialKiller
{
	public static void main(String[]args)
	{
		Scanner skan = new Scanner(System.in);
		String s = skan.nextLine();
		String[] names = s.split(" ");
		String bla = skan.nextLine();
		int n = Integer.parseInt(bla);
		System.out.println(s);

		for(int i = 0; i < n; i++)
		{
			s = skan.nextLine();
			String[] change = s.split(" ");

			if(change[0].equals(names[0]))
			{
				names[0] = change[1];
			}	
			else
			{
				names[1] = change[1];
			}	

			System.out.println(names[0] + " " + names[1]);
		}	
	}
}