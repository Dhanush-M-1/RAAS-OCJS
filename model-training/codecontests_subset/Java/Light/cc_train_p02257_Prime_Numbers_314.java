import java.util.Scanner;
import java.math.*;

public class Main{
    Main(){
	Scanner sc = new Scanner(System.in);
	BigInteger bi;

	while(sc.hasNext()){
	    int cnt = 0;
	    for(int i = sc.nextInt(); i >= 1; --i){
		bi = new BigInteger(sc.next());
		if(bi.isProbablePrime(1000)) ++cnt;
	    }
	    System.out.printf("%d\n", cnt);
	}
    }

    public static void main(String[] args){
	new Main();
    }
}