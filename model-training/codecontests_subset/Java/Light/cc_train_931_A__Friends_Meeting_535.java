import java.util.*;
public class solution {
	static Scanner s;
	static long a;
	static long b;
	public static void main(String[]args) {
		s = new Scanner(System.in);
		a = s.nextLong();
		b = s.nextLong();
		long length = mod(a ,b);
		long one = length/2;
		long two = length-one;
		long result = cal(one) + cal(two);
		System.out.println(result);
	}
	static long mod(long a , long b) {
		if(a >=b) {
			return a-b;
		}
		return b-a;
	}
	
	static long cal(long n) {
		long result = n*(n+1);
		result/=(2);
		return result;
	}
}
