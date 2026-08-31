
import java.util.Scanner;

public class cf559b2 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		
		boolean equivalent = equivalent(cs1,0,s1.length()-1, cs2,0,s2.length()-1);
		
		if (equivalent) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}
	
	public static boolean equals(char[] s1, int b1, int e1, 
			char[] s2, int b2) {
		for (int i = b1; i <= e1; i++) {
			if (s1[i] != s2[b2]) {
				return false;
			}
			b2++;
		}
		return true;
	}
	public static boolean equivalent(char[] s1, int b1, int e1, 
			char[] s2, int b2, int e2) {
		if (equals(s1, b1, e1, s2, b2)) {
			return true;
		} else {
			int tam = e1-b1+1;
			if (tam % 2 != 0) return false;
			int half = tam/2;
			if (equivalent(s1, b1, b1+half-1, s2, b2+half, e2) &&
			equivalent(s1, b1+half, e1, s2, b2, b2+half-1)) {
				return true;
			}
			if (equivalent(s1, b1, b1+half-1, s2, b2, b2+half-1) &&
					equivalent(s1, b1+half, e1, s2, b2+half, e2)) {
				return true;
			}	
			return false;
		}
	}

}