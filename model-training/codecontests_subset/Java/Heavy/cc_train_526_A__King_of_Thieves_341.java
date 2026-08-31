import java.io.*;
import java.util.*;

public class a1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		String s = in.next();
		boolean fl = false;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (i + 4 * j <= n - 1){
					boolean flag = true;
					for (int j2 = i; j2 < i + 5 * j; j2 += j) {
						if (s.charAt(j2) != '*'){
							flag = false;
							break;
						}
					}
					if (flag){
						fl = true;
						break;
					}
				}
			}
		}
		if (fl){
			out.println("yes");
		}
		else{
			out.println("no");
		}
		out.close();
	}
}
