import java.io.*;
import java.util.*;
public class Problem851b
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		long ax = sc.nextInt(), ay = sc.nextInt(), bx = sc.nextInt(), by = sc.nextInt(), cx = sc.nextInt(), cy=sc.nextInt();
		if(ax-bx == bx-cx && ay-by == by-cy)
		{
			System.out.println("No");
		}
		else System.out.println(((ax-bx)*(ax-bx) + (ay-by)*(ay-by) == (bx-cx)*(bx-cx) + (by-cy)*(by-cy))?"Yes":"No");
	}
}