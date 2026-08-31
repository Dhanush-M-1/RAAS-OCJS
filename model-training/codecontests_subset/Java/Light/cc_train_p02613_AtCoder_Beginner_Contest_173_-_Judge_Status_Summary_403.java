import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t;
		HashMap<String, Integer> stat = new HashMap<String, Integer> ();
		stat.put("AC", 0);
		stat.put("WA", 0);
		stat.put("TLE", 0);
		stat.put("RE", 0);
		Scanner in = new Scanner(System.in);
		
		t = in.nextInt();
		while(t-- > 0) {
			String s = in.next();
			stat.put(s, stat.get(s) + 1);
		}
		
		for(String s : new String[]{"AC", "WA", "TLE", "RE"}) {
			System.out.printf("%s x %d\n", s, stat.get(s));
		}
		

	}
}