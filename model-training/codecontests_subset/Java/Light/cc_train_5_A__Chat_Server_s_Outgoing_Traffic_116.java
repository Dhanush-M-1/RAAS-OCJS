import java.util.Scanner;


public class Op {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l = 0;
		int c = 0;
		String s;
		
		while (in.hasNextLine()) {
			s = in.nextLine();
		
			if (s.charAt(0) == '+') 
				c++;
			else if (s.charAt(0) == '-')
				c--;
			else {
				l += c*(s.length() - s.indexOf(':') - 1);
			}
		}

		System.out.println(l);
	}

}