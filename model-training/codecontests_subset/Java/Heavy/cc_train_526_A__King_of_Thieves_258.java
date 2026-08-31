import java.io.*;
import java.util.*;

public class cfzA {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader in = new BufferedReader(new FileReader("cfzA.in"));

		int n = Integer.parseInt(in.readLine());
		boolean works = false;
		String str = in.readLine();
		for(int i = 0; i < 100; i++) {
			for(int j = 1; j < 100; j++) {
				boolean works2 = true;
				for(int k = 0; k < 5; k++) {
					if(!(i + j * k < n && str.charAt(i + j * k) == '*')) {
						works2 = false;
					}
				}
				if(works2) {
					works = true;
				}
			}
		}
		System.out.println(works ? "yes" : "no");
	}
}