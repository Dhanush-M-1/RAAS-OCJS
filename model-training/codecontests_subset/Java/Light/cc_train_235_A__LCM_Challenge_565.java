import java.util.*;

public class C {
	public static long gcd(long a, long b){
		while(b != 0){
			long t = b;
			b = a%b;
			a = t;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		if(n == 1){
			System.out.println(1);
		}else if(n == 2){
			System.out.println(2);
		}else if(n % 2 != 0){
			System.out.println(n*(n-1)*(n-2));
		}else{
			long first = (n-1)*(n-2)*(n-3);
			long second = n*(n-1);
			
			long max = Integer.MIN_VALUE;
			for(long i=n-2; i>0; i--){
				long curr = i/gcd(second, i);
				
				if(curr > max){
					max = curr;
				}
			}
			
			second *= max;
			
			long ans = Math.max(first, second);
			
			System.out.println(ans);
		}
	}
}
