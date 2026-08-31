import java.util.Scanner;


public class CF284_D2_B {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		in.nextInt();
		char[] status = in.next().toCharArray();
		int A = 0;
		int F = 0;
		int I = 0;
		
		for (char x : status) {
			if (x == 'A') {
				A++;
			} else if (x == 'F') {
				F++;
			} else {
				I++;
			}
		}
		
		if (I > 1) {
			System.out.println(0);
		} else if (I == 0) {
			System.out.println(A);
		} else {
			System.out.println(1);
		}
		
		in.close();
	}
}
