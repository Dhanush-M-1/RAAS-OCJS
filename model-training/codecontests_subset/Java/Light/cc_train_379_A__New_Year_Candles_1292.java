import java.util.*;

public class candles {

	public static void main(String[] args)
	{
		int a,b;
		Scanner s = new Scanner(System.in);
		a = s.nextInt();
		b = s.nextInt();
		
		int ans = a;
		int have = a;
		int used;
		int buffer=a%b;
		boolean flag = true;
		while(flag)
		{
			if(have>=b)
			{
				buffer = have % b;
				ans = ans + have/b;
				used = have/b;
				have = used + buffer;
			}
			else
			{
				break;
			}
		}
		
		System.out.println(ans);
		s.close();
	}
}
