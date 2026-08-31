import java.util.*;

public class helloWorld 
{
	public static void main(String[] args) 
	{		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String ans = "YES";
		
		int idle = 3;
		for(int i = 1; i <= n; i++) {
			int a = in.nextInt();
			if(a == idle) {
				ans = "NO";
				break;
			}
			for(int j = 1; j <= 3; j++)
				if(j != idle && j != a) {
					idle = j;
					break;
				}
		}
		
		System.out.println(ans);

		in.close();
	}
}