import java.util.Scanner;

public class App3 {

	public static void main(String[] args) {
		
		int f = 0, sec = 0, b = 0;
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int n = in.nextInt();
		String temp = "";
		while (n-- > 0) {
			temp = in.next();
			if (temp.charAt(0) == s.charAt(1))
				sec = 1;
			if (temp.charAt(1) == s.charAt(0))
				f = 1;
			if (temp.equals(s))
				b = 1;
		}
		if (b == 1 || sec + f == 2) {
			System.out.println("YES");			
		} else 
			System.out.println("NO");
	}

}
