import java.util.Scanner;


public class C {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		long n = scr.nextInt();
		
		long n1 = n, n2 = n, n3 = n;
		long see = n;
		
		bound: for (n2 = n1; n2 > 0; n2--){
			if (gcd(n1, n2) == 1) {
				for (n3 = n2; n3 > 0; n3--){
					if ((gcd(n2, n3) == 1) && (gcd(n1, n3) == 1)) {
						see = n3;
						break bound;
					}
				}
			}
		}
		
		long nok = n1*n2*n3;
				
		for (n1 = n-1; n1 >= see; n1--){
			for (n2 = n1-1; n2 >= see; n2--){
				if (gcd(n1, n2) == 1) {
					for (n3 = n2; n3 >= see; n3--){
						if ((gcd(n2, n3) == 1) && (gcd(n1, n3) == 1)) {
							if ((n1*n2*n3) > nok) {
								nok = n1*n2*n3;
							}							
						}	
					}
				}
			}
		}
		
		System.out.println(nok);
		//System.out.println("\n" + n1 + " " + n2 + " " + n3);

	}
	
	static long gcd(long a, long b){
		while ((a > 0) && (b > 0)) {
			if (a > b) a = a%b;
			else b = b%a;
		}
		return ((a == 0)?b:a);
	}

}
