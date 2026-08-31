import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        /*int n = stdin.nextInt();
        for(int i = 0; i < n; i++)
        {
        	test(stdin);
        }*/
        test(stdin);
        stdin.close();
    }
    public static void test(Scanner stdin)
    {
    	int n = stdin.nextInt();
    	int dp[] = new int[n];
    	for(int i = 0; i < n - 1; i++)
    	{
    		dp[stdin.nextInt() - 1]++;
    		dp[stdin.nextInt() - 1]++;
    	}
    	boolean good = true;
    	for(int i = 0; i < n; i++)
    	{
    		if(dp[i] == 2)
    		{
    			good = false;
    		}
    	}
    	if(good)
    	{
    		System.out.println("YES");
    	}
    	else {
			System.out.println("NO");
		}
    }
}