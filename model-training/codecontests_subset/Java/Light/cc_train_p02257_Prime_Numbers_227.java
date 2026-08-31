import java.util.*;

public class Main{
	final int MOD = 1000000007;
	final int INF = 1000000000;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int cnt = 0;
		for(int i = 0; i < n; ++i){
			int a = Integer.parseInt(sc.next());
			if(isPrime(a)) ++cnt;
		}
		sc.close();
		System.out.println(cnt);
	}
	
	public static boolean isPrime(int x){
		if(x < 2) return false;
	    if(x == 2) return true;
	    if(x % 2 == 0) return false;
	    for(int i = 3; i * i <= x; i += 2)
	        if(x % i == 0) return false;
	    return true;
	}
	
}

