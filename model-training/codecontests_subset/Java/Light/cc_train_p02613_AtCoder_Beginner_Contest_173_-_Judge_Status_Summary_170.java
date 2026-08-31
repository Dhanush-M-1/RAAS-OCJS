import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numAC = 0;
		int numWA = 0;
		int numTLE = 0;
		int numRE = 0;

		int n = in.nextInt();
		while (n-- > 0) {
			String s = in.next();
			if (s.equals("AC"))
				numAC++;
			else if (s.equals("WA"))
				numWA++;
			else if (s.equals("TLE"))
				numTLE++;
			else
				numRE++;
		}

		System.out.println("AC x " + numAC);
		System.out.println("WA x " + numWA);
		System.out.println("TLE x " + numTLE);
		System.out.println("RE x " + numRE);
	}
}

