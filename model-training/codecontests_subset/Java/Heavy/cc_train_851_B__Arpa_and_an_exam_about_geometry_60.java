import java.util.*;

public class Test2 {
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in); 
	    String input = in.nextLine(); 
		String[] strs = input.trim().split(" ");
		long[] ins = new long[strs.length];

		for (int i = 0; i < strs.length; i++) {
			ins[i] = Long.parseLong(strs[i]);
		}

		boolean b1 = false;
		boolean b2 = false;
		boolean b3 = false;
		boolean ans;

		long x1 = ins[0];
		long y1 = ins[1];
		long x2 = ins[2];
		long y2 = ins[3];
		long x3 = ins[4];
		long y3 = ins[5];

		long d1 = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
        long d2 = ((x3 - x2) * (x3 - x2)) + ((y3 - y2) * (y3 - y2));
        if(((y3 - y2) * (x2 - x1)) != ((y2 - y1) * (x3 - x2))) b1 = true;
        if(((y3 - y1) * (x1 - x2)) != ((y1 - y2) * (x3 - x1))) b2 = true;
        if(((y2 - y3) * (x3 - x1)) != ((x2 - x3) * (y3 - y1))) b3 = true;

        ans = (b1 & b2 & b3); 
        ans &= (d1 == d2);
        System.out.println( ans ? "Yes" : "No");
	}
}