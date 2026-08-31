import java.math.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long x=sc.nextLong();
		long a=1,b=1;
		for(int i=1;i<Math.sqrt(x);i++){
			if(x%i==0){
				if(BigInteger.valueOf(i).gcd(BigInteger.valueOf((long)(x/i))).compareTo(BigInteger.valueOf(1))==0){
					a=i;
					b=x/i;
				}
			}
		}
		System.out.println(a+" "+b);
	}
}