import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		for(int i = 0; i < n; i++) {
			String a = stdIn.next();
			String b = stdIn.next();
			for(int j = a.length()-1; j >= 0; j--) {
				if(a.charAt(j) == 'J') {
					b = J(b);
					continue;
				}
				if(a.charAt(j) == 'C') {
					b = C(b);
					continue;
				}
				if(a.charAt(j) == 'E') {
					b = E(b);
					continue;
				}
				if(a.charAt(j) == 'A') {
					b = A(b);
					continue;
				}
				if(a.charAt(j) == 'P') {
					b = M(b);
					continue;
				}
				if(a.charAt(j) == 'M') {
					b = P(b);
					continue;
				}
				
			}
			System.out.println(b);
		}
		
	}
	
	public static String J(String a) {
		String b1 = a.substring(a.length()-1, a.length());
		String b2 = a.substring(0, a.length()-1);
		return b1 + b2;
	}
	
	public static String C(String a) {
		String b1 = a.substring(0, 1);
		String b2 = a.substring(1, a.length());
		return b2 + b1;
	}
	
	public static String E(String a) {
		String b1 = "";
		String b2 = "";
		String b3 = "";
		if(a.length() % 2 == 1) {
			b1 = a.substring(0, a.length()/2);
			b2 = a.substring(a.length()/2, a.length()/2 + 1);
			b3 = a.substring(a.length()/2+1, a.length());
		}
		else {
			b1 = a.substring(0, a.length()/2);
			b3 = a.substring(a.length()/2, a.length());
		}
		return b3 + b2 + b1;
	}
	
	public static String A(String a) {
		String b1 = "";
		for(int i = a.length()-1; i >= 0; i--) {
			b1 += String.valueOf(a.charAt(i));
		}
		return b1;
	}
	
	public static String P(String a) {
		String b1 = "";
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '0') {
				b1 += "1";
			}
			else if(a.charAt(i) == '1') {
				b1 += "2";
			}
			else if(a.charAt(i) == '2') {
				b1 += "3";
			}
			else if(a.charAt(i) == '3') {
				b1 += "4";
			}
			else if(a.charAt(i) == '4') {
				b1 += "5";
			}
			else if(a.charAt(i) == '5') {
				b1 += "6";
			}
			else if(a.charAt(i) == '6') {
				b1 += "7";
			}
			else if(a.charAt(i) == '7') {
				b1 += "8";
			}
			else if(a.charAt(i) == '8') {
				b1 += "9";
			}
			else if(a.charAt(i) == '9') {
				b1 += "0";
			}
			else {
				b1 += String.valueOf(a.charAt(i));
			}
		}
		return b1;
	}
	public static String M(String a) {
		String b1 = "";
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '0') {
				b1 += "9";
			}
			else if(a.charAt(i) == '1') {
				b1 += "0";
			}
			else if(a.charAt(i) == '2') {
				b1 += "1";
			}
			else if(a.charAt(i) == '3') {
				b1 += "2";
			}
			else if(a.charAt(i) == '4') {
				b1 += "3";
			}
			else if(a.charAt(i) == '5') {
				b1 += "4";
			}
			else if(a.charAt(i) == '6') {
				b1 += "5";
			}
			else if(a.charAt(i) == '7') {
				b1 += "6";
			}
			else if(a.charAt(i) == '8') {
				b1 += "7";
			}
			else if(a.charAt(i) == '9') {
				b1 += "8";
			}
			else {
				b1 += String.valueOf(a.charAt(i));
			}
		}
		return b1;
	}
}