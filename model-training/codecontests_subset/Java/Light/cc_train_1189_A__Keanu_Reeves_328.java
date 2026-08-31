import java.util.*;
import java.io.*;

public class A572 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String g = in.next();
		
		if(isGood(g)) {
			System.out.println(1);
			System.out.println(g);
		}
		else {
			System.out.println(2);
			System.out.println(g.substring(0, 1) + " " + g.substring(1));
		}

		in.close();
	}

	public static boolean isGood(String g ) {
		int[] count = new int[2];
		for(int i = 0; i < g.length(); i++)
			count[g.charAt(i) - '0']++;
		return (count[0] != count[1]);
	}
}

/*
Copy

1
1

Output
Copy

1
1

Input
Copy

2
10

Output
Copy

2
1 0

Input
Copy

6
100011

Output
Copy

2
100 011
*/