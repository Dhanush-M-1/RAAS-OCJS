import java.util.*;

public class helloWorld 
{
	public static void main(String[] args) 
	{
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int rem = 0;
		int ans = 0;
		

		for(; n > 0; n /= m) {
			ans += n;
			n += rem;
			rem = n % m;
		}
		
		System.out.print(ans);

		in.close();
	}
}
