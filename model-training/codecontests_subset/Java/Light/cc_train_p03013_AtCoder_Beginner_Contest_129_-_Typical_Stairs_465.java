import java.util.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		// 入力
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[] = new int[n+1];
		for(int i = 0; i < m; i++){
		    a[sc.nextInt()] = 1;
		}
		// 計算
		long result = 0;
		long[] dp = new long[n+1];
		for(int i = 1; i < n+1; i++){
		    if(a[i] == 1){
		        dp[i] = 0;
		    }else if(i == 1){
		        dp[i] = 1;
		    }else if(i == 2){
		        dp[i] = dp[i-1] + 1;
		    }else{
		        dp[i] = dp[i-1] + dp[i-2];
		        dp[i] %= 1000000007;
		    }
		}
		result = dp[n];
		// 出力
		System.out.println(result);
		
	}
}
