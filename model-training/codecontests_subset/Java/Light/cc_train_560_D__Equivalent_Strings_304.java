import java.util.*;
public class codeD {
	public static void main(String [] args) {
		Scanner scn = new Scanner (System.in);
		String s1 = scn.next();
		String s2 = scn.next();

		if(smallest(s1).equals(smallest(s2)))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	static String smallest(String s) {
	    if ((s.length() % 2) == 1) return s;
	    String s1 = smallest(s.substring(0, s.length()/2));
	    String s2 = smallest(s.substring(s.length()/2));
	    if (s1.compareTo(s2) < 1) return s1 + s2;
	    else return s2 + s1;
	}
}

