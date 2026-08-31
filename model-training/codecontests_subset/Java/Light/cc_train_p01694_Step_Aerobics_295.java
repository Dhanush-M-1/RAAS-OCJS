import java.util.*;
public class Main {
	static char[] l = new char[] {'q','w','e','r','t','a','s','d','f','g','z','x','c','v','b'};
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		while (true) {
			int n = stdIn.nextInt();
			if(n == 0) break;
			int counter = 0;
			boolean isd = true;
			boolean isld = true;
			boolean isrd = true;
			for(int i = 0; i < n; i++) {
				String a = stdIn.next();
				if(a.equals("lu")) {
					isld = false;
				}
				if(a.equals("ru")) {
					isrd = false;
				}
				if(a.equals("ld")) {
					isld = true;
				}
				if(a.equals("rd")) {
					isrd = true;
				}
				if(isd && !isld && !isrd) {
					isd = false;
					counter++;
				}
				if(!isd && isld && isrd) {
					isd = true;
					counter++;
				}
 			}
			System.out.println(counter);
		}
	}
}