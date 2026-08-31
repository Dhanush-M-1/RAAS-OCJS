import java.util.*;
import static java.lang.System.*;

public class Main {

	Scanner sc = new Scanner(in);
	
	void run() {
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			String n = sc.next();
			int count = 0;
			while (n.length() > 1) {
				int max = -1;
				for (int j = 0; j < n.length()-1; j++) {
					max = Math.max(max, Integer.parseInt(n.substring(0, j+1))*Integer.parseInt(n.substring(j+1)));
				}
				n = String.valueOf(max);
				count++;
			}
			out.println(count);
		}
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}