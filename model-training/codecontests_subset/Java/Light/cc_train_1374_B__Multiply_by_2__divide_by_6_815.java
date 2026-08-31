import java.util.*;
public class b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0)
		{
			int n = sc.nextInt();
			if(n == 1)
			{
				System.out.println(0);
				continue;
			}
			
			int three = 0;
			int two = 0;
			int x = n;
			while(x%3 == 0)
			{
				three++;
				x = x/3;
			}
			
			while(x%2 == 0)
			{
				two++;
				x = x/2;
			}
			
			if(x == 1 && three >= two)
			{
				int ans = three-two+three;
				System.out.println(ans);
			}
			
			else
				System.out.println(-1);
		}
		
		
	}

}
