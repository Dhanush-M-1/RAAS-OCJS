import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class A805 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(System.in);
		long a = scan.nextInt(), b = scan.nextInt();
		long diff = b - a;
		if(diff ==1 || diff == 0) {
			System.out.println(b);
		
		}
		else {
			System.out.println(2);
		}

	}
}