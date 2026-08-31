import java.util.*;
import java.io.*;

public class aaaaaaaaaaaaaaaa {
	public void run() throws Exception {
		Scanner file = new Scanner(System.in);
		int len = file.nextInt();
		String s = file.next();
		int index = -1;
		boolean b = false;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) > s.charAt(i+1)) {
				index = i;
				b = true;
				break;
			}
		}
		if (!b) System.out.println("NO");
		else {
			System.out.println("YES");
			System.out.println(index + 1 + " " + (index + 2));
		}
	}

	public static void main(String[] args) throws Exception {
		new aaaaaaaaaaaaaaaa().run();
	}

}