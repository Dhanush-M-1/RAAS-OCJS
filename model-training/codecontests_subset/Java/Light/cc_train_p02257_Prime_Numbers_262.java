import java.util.*;
import java.math.*;
class Main {
	static boolean isPrime(int N)
	{
		for (int i = 2; i <= Math.sqrt(N); i++) 
		{
			if(N % i == 0){return false;}
	    }
		return N!=1;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for (int i=0; i<n; i++) {
			if(isPrime(sc.nextInt()))
				cnt++;
		}
		System.out.println(cnt);
	}
    


}



