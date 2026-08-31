import java.util.*;

public class Main{

    public void run(){
	
	Scanner in = new Scanner(System.in);
	long n = in.nextLong();
	if (n == 1){
	    System.out.println(1);
	    return;
	}
	if (n == 2){
	    System.out.println(2);
	    return;
	}
	if (n == 3){
	    System.out.println(6);
	    return;
	}
	long max = 0;
	for(long i=n;i>3;i--){
	    long lcm = i * (i - 1);
	    long r = lcm(lcm, i-2);
	    max = Math.max(max, r);
	    r = lcm(lcm, i-3);
	    max = Math.max(max, r);
	    lcm = i * (i-2);
	    r = lcm(lcm, i-3);
	    max = Math.max(max, r);
	}

	System.out.println(max);
    }
    
    private long gcd(long a, long b){
	return (a % b == 0) ? b : gcd(b, a%b);
    }

    private long lcm(long a, long b) {
	return a * b / gcd(a, b);
    }

    public static void main(String ag[]){
	new Main().run();
    }
}