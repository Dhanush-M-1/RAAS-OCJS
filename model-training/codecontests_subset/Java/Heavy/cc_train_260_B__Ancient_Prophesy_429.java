import java.util.Scanner;
import java.util.Map;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	public void solve(int testNumber, Scanner in, PrintWriter out) {
		String s = in.next();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i + 10 <= s.length(); ++i) {
			String dateStr = s.substring(i, i + 10);
			StringTokenizer st = new StringTokenizer(dateStr, "-");
			if (st.countTokens() != 3) continue;
			String ds = st.nextToken();
			if (ds.length() != 2) continue;
			String ms = st.nextToken();
			if (ms.length() != 2) continue;
			String ys = st.nextToken();
			if (ys.length() != 4) continue;
			int d = Integer.parseInt(ds);
			int m = Integer.parseInt(ms);
			int y = Integer.parseInt(ys);
			if (2013 <= y && y <= 2015)
				if (1 <= m && m <= 12) {
					Calendar calendar = Calendar.getInstance();
					int year = y;
					int month = m - 1;
					int date = 1;
					calendar.set(year, month, date);
					int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					if (1 <= d && d <= days) {
						if (map.containsKey(dateStr)) {
							int cnt = map.get(dateStr);
							map.put(dateStr, cnt + 1);
						} else {
							map.put(dateStr, 1);
						}
					}
				}
		}
		int cnt = 0;
		String res = "";
		for (String key : map.keySet()) {
			if (map.get(key) > cnt) {
				cnt = map.get(key);
				res = key;
			}
		}
		out.println(res);
	}
}

