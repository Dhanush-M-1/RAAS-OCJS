import java.util.*;
import java.math.*;
public class Main{
    public static void main(String[] args){
	Scanner s = new Scanner(System.in);
	while(s.hasNext()){
	    int c = 0;
	    for(int i=s.nextInt();i>0;--i){
		BigInteger b = new BigInteger(s.next());
		if(b.isProbablePrime(5))++c;
	    }
	    System.out.printf("%d\n",c);
	}
    }
}