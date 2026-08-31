import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			int ct = 0;
			for(int i = sc.nextInt(); i>=1; --i){
				BigInteger b = new BigInteger(sc.next());
				if(b.isProbablePrime(5)) ++ct;
			}
			System.out.printf("%d\n", ct);
		}
	}
}
