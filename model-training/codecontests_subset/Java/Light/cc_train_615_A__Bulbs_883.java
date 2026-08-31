import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Set<Integer> set = new HashSet<Integer>();
		int n = scan.nextInt();
		int m = scan.nextInt();
		for (int i = 0; i < n; i++)
		{
			int x = scan.nextInt();
			for (int j = 0; j < x; j++)
				set.add(scan.nextInt());
		}
		System.out.println(set.size() == m ? "YES" : "NO");
		
		scan.close();
	}
}