
import java.io.*;
import java.util.*;
import java.math.*;

public class solveD {
	public static void main(String[] args) throws IOException {
		Scanner f = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(f.nextLine());
		String a = st.nextToken();
		st = new StringTokenizer(f.nextLine());
		String b = st.nextToken();

		if(equivalent(a,b))
			System.out.println("YES");
		else
			System.out.println("NO");


	}

	public static boolean equivalent(String a, String b) {
		return smallest(a).equals(smallest(b));
		/*if(a.length() == b.length()) {
			if(a.length()%2 != 0) {
				return a.equals(b);
			}

			else if(a.equals(b)) {
				return true;
			}

			else {
				String a1 = a.substring(0, a.length()/2);
				String a2 = a.substring(a.length()/2, a.length());
				String b1 = b.substring(0, b.length()/2);
				String b2 = b.substring(b.length()/2, b.length());

				return (equivalent(a1, b1) && equivalent(a2, b2)) || (equivalent(a1, b2) && equivalent(a2,b1));
			}
		}

		else
		{
			return false;
		}*/
	}

	public static String smallest(String a) {
		if(a.length()%2 == 1)
			return a;
		else {
			String x = smallest(a.substring(0, a.length()/2));
			String y = smallest(a.substring(a.length()/2, a.length()));

			if(x.compareTo(y) < 0)
				return x+y;
			else
				return y+x;
		}
	}
}