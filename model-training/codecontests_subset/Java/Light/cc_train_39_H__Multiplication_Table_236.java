import java.util.*;
public class CF39H {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n-1; i ++)
		{
			for(int j = 0; j < n-1; j ++)
				System.out.print(changeBase((i+1)*(j+1), n) + " " );
			System.out.println();
		}
	}
	static long changeBase(int a, int b)
	{
		long ans = 0;
		int pow = 0;
		while(a!=0)
		{
			ans+=(a%b)*Math.pow(10,  pow);
			a/=b;
			pow++;
		}
		return ans;
	}
}
