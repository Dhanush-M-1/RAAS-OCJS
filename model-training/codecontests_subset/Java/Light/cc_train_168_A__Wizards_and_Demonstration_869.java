import java.util.Scanner;


public class P168A
{
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		int ans = n*y/100 -x;
		if ((n*y/(double)100) != (double)(n*y/100)) ans++;
		System.out.println(Math.max(0, ans));
	}
	
}
