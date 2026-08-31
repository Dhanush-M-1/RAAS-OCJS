import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BufferedReader buff = new BufferedReader(new InputStreamReader(
				System.in));
		long n = scan.nextLong();
		long acount = 0;
		long fcount = 0;
		long icount = 0;
		char[] input = scan.next().toCharArray();
		for (int i = 0; i < n; i++) {
			if (input[i] == 'F')
				fcount++;
			else if (input[i] == 'A')
				acount++;
			else if (input[i] == 'I')
				icount++;
		}
		if (icount == 0)
			System.out.println(acount);
		else if (icount == 1)
			System.out.println(icount);
		else
			System.out.println(0);
	}

}
