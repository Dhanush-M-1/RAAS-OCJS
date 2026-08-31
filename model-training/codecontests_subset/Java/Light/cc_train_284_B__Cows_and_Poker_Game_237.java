
import java.io.*;
import java.util.*;
import java.math.*;

public class solveB {
	public static void main(String[] args) throws IOException {
		Scanner f = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(f.nextLine());

		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(f.nextLine());
		char[] letters = st.nextToken().toCharArray();

		int allin = 0;
		int in = 0;
		for (int i = 0; i < n; i++) {
			if (letters[i] == 'A')
				allin++;
			if (letters[i] == 'I')
				in++;
		}

		if (in == 0)
			System.out.println(allin);
		else if (in == 1)
			System.out.println(1);
		else
			System.out.println(0);

	}
}