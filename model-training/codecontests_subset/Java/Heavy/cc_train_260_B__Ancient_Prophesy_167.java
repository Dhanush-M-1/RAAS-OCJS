import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {
	static final int[] monthDay = {
		0,
		31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	};
	
	static class Date implements Comparable<Date> {
		int day;
		int month;
		int year;
		Date(String s) {
			try {
				day = Integer.valueOf(s.substring(0, 2));
				month = Integer.valueOf(s.substring(3, 5));
				year = Integer.valueOf(s.substring(6, 10));
				if (s.charAt(2) != '-' || s.charAt(5) != '-') {
					throw new Exception();
				}
				int ct = 0;
				for (int c = 0 ; c < 10 ; c++) {
					if (s.charAt(c) == '-') {
						ct++;
					}
				}
				if (ct != 2) {
					throw new Exception();
				}
				if (2013 <= year && year <= 2015) {
				} else {
					throw new Exception();
				}
				if (1 <= month && month <= 12) {
				} else {
					throw new Exception();
				}
				if (1 <= day && day <= monthDay[month]) {
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				day = month = year = -1;
			}
		}
		@Override
		public int compareTo(Date arg0) {
			return Long.signum(encode() - arg0.encode());
		}
		
		public long encode() {
			return 1L * year * 10000 + 1L * month * 100 + day;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		String line = in.nextLine();
		int len = line.length();
		Date best = null;
		for (int i = 0 ; i <= len - 10 ; i++) {
			Date date = new Date(line.substring(i, i+10));
			if (date.day != -1) {
				long code = date.encode();
				if (!map.containsKey(code)) {
					map.put(code, 0);
				}
				map.put(code, map.get(code) + 1);
				if (best == null || map.get(best.encode()) < map.get(code)) {
					best = date;
				}
			}
		}
		
		out.println(String.format("%02d-%02d-%04d", best.day, best.month, best.year));
		out.flush();
	}
	
	public static void debug(Object... o) {
		System.err.println(Arrays.deepToString(o));
	}
}

