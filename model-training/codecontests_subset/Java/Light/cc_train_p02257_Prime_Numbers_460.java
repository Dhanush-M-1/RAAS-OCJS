
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int i, cnt = 0;
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(i = 0; i < n; i++) {
        	String a = sc.next();
        	BigInteger b = new BigInteger(a);
        	if(b.isProbablePrime(5)) cnt++;
        }
        System.out.println(cnt);
	}
}
