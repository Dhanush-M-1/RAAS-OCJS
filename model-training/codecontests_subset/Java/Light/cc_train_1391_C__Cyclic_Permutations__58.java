import java.io.*;
import java.util.*;
public class Ishu
{
	static Scanner scan = new Scanner(System.in);
	static void tc()
	{
	int MOD = 1000_000_007;
	int n = scan.nextInt();
	long fact = 1L;
	int i;
	for(i=1;i<=n;++i)
		fact = ((fact % MOD) * (i % MOD)) % MOD;
	
//	System.out.println(fact);
	
	long two = 1L;
	for(i=1;i<=n-1;++i)
		two = ((two % MOD) * (2 % MOD)) % MOD;
	
	//System.out.println(two);
	
	long ans = ((fact % MOD) - (two % MOD)) % MOD;
	if(ans < 0)
		ans += MOD;
	System.out.println(ans);
	}
	public static void main(String[] args)
	{
	int t ;//= scan.nextInt();
	t = 1;
	while(t-- > 0)
		tc();
	}
}
