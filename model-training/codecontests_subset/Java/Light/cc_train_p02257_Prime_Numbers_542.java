import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);

	while(sc.hasNext()){
	    int cnt = 0;
	    for(int i = sc.nextInt(); i >= 1; --i){
		BigInteger bi = new BigInteger(sc.next());
		if(bi.isProbablePrime(5)) ++cnt;
	    }
	    System.out.printf("%d\n", cnt);
	}
    }
}