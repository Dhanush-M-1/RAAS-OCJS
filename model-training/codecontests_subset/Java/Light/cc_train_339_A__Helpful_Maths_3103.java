import java.io.*;
import java.util.*;

public class learn {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String s = in.next();
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i += 2) {
			a.add(Integer.parseInt(s.charAt(i)+""));
		}
		Integer[] b = a.toArray(new Integer[0]);
		Arrays.sort(b);
		for (int i = 0; i < b.length-1; i++) {
			out.print(String.valueOf(b[i])+'+');
		}
		out.print(b[b.length-1]);
		out.close();
	}

}
