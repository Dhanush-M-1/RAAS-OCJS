import java.io.*;
import java.util.*;

public class KeanuReeves {
	
	public static boolean isGood(String str) {
		int zeroes = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i+1).equals("0")) {
				zeroes++;
			}
		}
		if (zeroes * 2 == str.length()) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int length = sc.nextInt();
		String str = sc.next();
		
		if (isGood(str) == false) {
			pw.print("1" + "\n" + str);
		}
		else pw.print("2" + "\n" + str.substring(0, str.length()-1) + " " + str.substring(str.length()-1, str.length()));
		//
		sc.close();
		pw.close();
	}
}
