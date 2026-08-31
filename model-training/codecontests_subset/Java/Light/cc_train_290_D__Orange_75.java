import java.util.Scanner;

public class D {

	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		String s = in.next();
		int k = in.nextInt();
		for(int i= 0 ; i < s.length(); i++) {
			if(Character.isUpperCase(s.charAt(i)) && s.charAt(i) - 'A' < k || Character.isLowerCase(s.charAt(i)) && s.charAt(i) - 'a'  < k) 
				System.out.print(Character.toUpperCase(s.charAt(i)));
			else
				System.out.print(Character.toLowerCase(s.charAt(i)));
		}
		System.out.println();
	}

}