import java.util.Scanner;

public class D {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next(), s2 = scan.next();
		s1 = simple(s1);
		s2 = simple(s2);
		System.out.println(s1.equals(s2) ? "YES" : "NO");
	}
	
	public static String simple(String s) {
		if(s.length()/2 != (s.length()+1)/2)
			return s;
		String s1 = simple(s.substring(0,s.length()/2));
		String s2 = simple(s.substring(s.length()/2));
		String ans1 = s1 + s2;
		String ans2 = s2 + s1;
		if(ans1.compareTo(ans2) <= 0)
			return ans1;
		return ans2;
	}
}
