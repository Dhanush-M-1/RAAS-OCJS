import java.io.PrintWriter;
import java.util.*;

public class D {
	
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int number = sc.nextInt();
		
		input = input.toLowerCase();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if ((int)c < number + 97) {
				sb.append(Character.toUpperCase(c));
			} else {
				sb.append(Character.toLowerCase(c));
			}
		}
		
		out.println(sb.toString());
		
		sc.close();
		out.close();
	}
}
