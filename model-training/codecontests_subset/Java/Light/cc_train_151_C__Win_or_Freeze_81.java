
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    public static long y;

    public static Vector<Long> v = new Vector<Long>();

    public static long isPrime(long n){
	for(int i=2;i<=Math.sqrt(n);i++){
		if(n%i==0){
			v.add((long)i);
			return n/i;
		}
	}
	return 0;
}

    public static void main(String[] args) {
        try {

            Scanner in = new Scanner(System.in);

            long n=in.nextLong(),k=0,p=0;

            if((k=isPrime(n))==0){
                    System.out.println(1);
                    System.out.println(0);
            }else{
                    if((p=isPrime(k))==0){
                            System.out.println(2);
                    }else{
                            System.out.println(1);
                            System.out.println(v.elementAt(0)*v.elementAt(1));
                    }
            }

        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
