import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class A1189 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		scan.nextLine();
		String s = scan.nextLine();
		int numZeroes = zeroes(s);
		int numOnes = ones(s);
		if(numZeroes != numOnes) {
			System.out.println(1);
			System.out.println(s);
			System.exit(0);
		}else {
			System.out.println(2);
			System.out.println(s.charAt(0) + " " + s.substring(1));
		}
	}
	
	//always possible to split into 2 substrings
	
	public static int zeroes(String s) {
		int sum = 0;
		for(int i =0 ;i < s.length(); i ++) {
			if(s.charAt(i) == '0') {
				sum ++;
			}
		}
		return sum;
	}
	public static int ones(String s) {
		int sum = 0;
		for(int i =0 ;i < s.length(); i ++) {
			if(s.charAt(i) == '1') {
				sum ++;
			}
		}
		return sum;
	}
}