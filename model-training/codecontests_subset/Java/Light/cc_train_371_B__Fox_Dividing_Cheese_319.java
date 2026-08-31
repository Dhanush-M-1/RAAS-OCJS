import java.io.*;
import java.util.*;

public class cf371b {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] s = in.readLine().split("\\s+");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);

		ArrayList<Integer> afactors = new ArrayList<Integer>();
		ArrayList<Integer> bfactors = new ArrayList<Integer>();

		for(int i = 2; i <= 5; i++) {
			while(a % i == 0) {
				afactors.add(i);
				a /= i;
			}

			while(b % i == 0) {
				bfactors.add(i);
				b /= i;
			}
		}

		ArrayList<Integer> sharedfactors = new ArrayList<Integer>();

		for(int i = 0; i < afactors.size(); i++) {
			if(bfactors.contains(afactors.get(i))) {
				sharedfactors.add(afactors.get(i));
				bfactors.remove((Integer) afactors.remove(i));
				i--;
			}
		}

		if(a != b) { System.out.println(-1); return; }

		System.out.println(afactors.size() + bfactors.size());
	}
}
