
 import java.util.*;
 import java.math.*;
 public class A
 {
 	public static void main (String[] args)
 	{
 		Scanner in = new Scanner(System.in);
 		int k = in.nextInt();
 		int n = in.nextInt();

 		int ans = Integer.MAX_VALUE;
 		for (int i = 0; i < k; ++i)
 		{
 			int a = in.nextInt();
 			if(n % a == 0) ans = Math.min(ans, (n / a));
 		}
 		System.out.println(ans);

 	}
 }

