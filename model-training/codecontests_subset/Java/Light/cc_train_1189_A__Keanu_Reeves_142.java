import java.io.*;
import java.util.*;
public class KeanuReeves {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String s = br.readLine();
		if(s.length() == 1 || isGood(s)) {
			System.out.println(1);
			System.out.println(s);
			return;
		}
		String a = String.valueOf(s.charAt(0));
		s = s.substring(1);
		System.out.println(2);
		System.out.print(a+" "+s);
	}
	public static boolean isGood(String s) {
		int zero = 0;
		int one = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0') zero++;
			else one++;
		}
		return zero != one;
	}
}
