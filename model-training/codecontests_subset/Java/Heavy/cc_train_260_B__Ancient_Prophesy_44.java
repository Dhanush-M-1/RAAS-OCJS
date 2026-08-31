import java.io.*;
import java.util.*;

public class Main {
//	static Scanner in; static int next() throws Exception {return in.nextInt();};
//	static StreamTokenizer in; static int next() throws Exception {in.nextToken(); return (int) in.nval;}
	static BufferedReader in;
	static PrintWriter out;

	static String format(int n) {
		if (n < 10) return "0" + n;
		else return "" + n;
	}

	public static void main(String[] args) throws Exception {
//		in = new Scanner(System.in);
//		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		String s = in.readLine();

		int[] l = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		int sum = 0;
		for (int i = 0; i < 12; i++) sum += l[i];
		
		String[] date = new String[sum];

		for (int i = 0, t = 0; i < 12; i++)
			for (int j = 1; j <= l[i]; j++, t++) date[t] = format(j) + "-" + format(i + 1);
		
		int[][] kol = new int[3][sum];

		for (int i = 5; i <= s.length() - 5; i++) {
			if (s.substring(i, i + 4).equals("-201"))
				if ('3' <= s.charAt(i + 4) && s.charAt(i + 4) <= '5') {
					int x = s.charAt(i + 4) - '3';
					String ss = s.substring(i - 5, i);
					for (int j = 0; j < sum; j++) if (ss.equals(date[j])) kol[x][j]++;
				}
		}

		int maxx = 0;
		int maxd = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < sum; j++) if (kol[i][j] > kol[maxx][maxd]) {
				maxx = i;
				maxd = j;
			}

		out.println(date[maxd] + "-" + (maxx + 2013));

		out.close();
	}
}