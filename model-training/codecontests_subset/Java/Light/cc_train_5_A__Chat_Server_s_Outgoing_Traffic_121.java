import java.util.*;

public class TaskA {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String st, t = "";
		int N, res;
		
		N = res = 0;
		while (in.hasNextLine()) {
			st = in.nextLine();
			if (st.charAt(0) == '+') N++; else
			if (st.charAt(0) == '-') N--; else {
				st += " ";
				t = st.split(":")[1];
				if (t != " ") res += (t.length() * N - N);
			}
		}
		
		System.out.print(res);
		in.close();
	}
}
