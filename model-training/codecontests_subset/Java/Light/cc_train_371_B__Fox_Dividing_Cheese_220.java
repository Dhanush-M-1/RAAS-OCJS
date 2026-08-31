import java.util.Scanner;


public class B {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt(); int b = s.nextInt();
		int c = 0; 
		int g = gcd(a,b);
		a = a/g; b = b/g;
		boolean f = true;
		while(a != 1 && f) {
			f = false;
			if(a%2 == 0) {
				f = true; a /= 2; c++;
			}
			if(a%3 == 0) {
				f = true; a /= 3; c++;
			}
			if(a%5 == 0) {
				f = true; a /= 5; c++;
			}
		}
		
		while(b != 1 && f) {
			f = false;
			if(b%2 == 0) {
				f = true; b /= 2; c++;
			}
			if(b%3 == 0) {
				f = true; b /= 3; c++;
			}
			if(b%5 == 0) {
				f = true; b /= 5; c++;
			}
		}
		
		if(!f) System.out.println(-1);
		else System.out.println(c);
	}
	
	
	static int gcd(int a, int b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}

}
