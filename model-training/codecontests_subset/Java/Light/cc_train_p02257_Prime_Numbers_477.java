import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;
        for(int i = 0;i < n;i++){

        	// 	isProbablePrime()はこのBigIntegerが素数である可能性が高い場合はtrue、必ず合成数である場合はfalseを返します
            BigInteger bi = new BigInteger(sc.next());
            if(bi.isProbablePrime(5)) count++;

        }
        System.out.println(count);

	}

}

