import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int count = 0;
		for (int i=0; i<n; i++) {
			if (isPrime(sc.nextInt())) {count++;}
		}
		System.out.println(count);
	}
	public static boolean isPrime(int num) {
	    if (num < 2) return false;
	    else if (num == 2) return true;
	    else if (num % 2 == 0) return false;
	    double sqrtNum = Math.sqrt(num);
	    for (int i = 3; i <= sqrtNum; i += 2) {
	        if (num % i == 0) {return false;}
	    }
	    return true;
	}
}				
