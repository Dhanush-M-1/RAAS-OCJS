import java.util.Scanner;


public class Orange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder s = new StringBuilder(sc.next());
		int n = sc.nextInt();
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.toUpperCase(s.charAt(i)) - 'A' < n)
				s.setCharAt(i, Character.toUpperCase(s.charAt(i)));
			else
				s.setCharAt(i, Character.toLowerCase(s.charAt(i)));
		}
		
		System.out.println(s);
		sc.close();
	}

}
