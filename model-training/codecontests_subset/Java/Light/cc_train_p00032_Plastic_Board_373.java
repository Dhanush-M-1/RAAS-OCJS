import java.util.*;
import static java.lang.System.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int rectangle = 0;
		int diamond = 0;
		int a,b,c;
		String[] s = new String[3];
		while (sc.hasNext()) {
			String temp = sc.next();
			s = temp.split(",");
			a = Integer.parseInt(s[0]);
			b = Integer.parseInt(s[1]);
			c = Integer.parseInt(s[2]);
			if (c*c == (a*a)+(b*b)) {rectangle++;}
			else if (a==b) {diamond++;}
		}
		out.println(rectangle+"\n"+diamond);
	}
}
