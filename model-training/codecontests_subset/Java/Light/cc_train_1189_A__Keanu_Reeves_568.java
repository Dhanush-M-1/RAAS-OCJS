import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.regex.*;
import java.io.*;


public class KeanuReeves {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = Integer.parseInt(in.nextLine());
		String str = in.nextLine();
		if(!isGood(str)) {
			System.out.println(1);
			System.out.println(str);
		}
		else {
			System.out.println(2);
			System.out.println(str.charAt(0) + " " + str.substring(1));
		}

	}

	public static boolean isGood(String s) {
		return s.replaceAll("1", "").length() == s.replaceAll("0", "").length();
	}
}
