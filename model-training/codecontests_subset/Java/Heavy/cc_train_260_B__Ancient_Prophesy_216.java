import java.io.PrintWriter;
import java.util.Scanner;


public class TaskB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		TaskB solver = new TaskB();
		solver.solve(in, out);
		in.close();
		out.close();
	}
	
	private static final int[] months = 
		{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private int[][][] counter = new int[35][15][5];
	private int max = 0;
	private String prophecy;
	private String current;
	private int lastDay, lastMonth, lastYear;
	
	private void solve(Scanner in, PrintWriter out) {
		prophecy = in.next();
		int last = prophecy.length() - 9;
		boolean bad;
		for (int i = 0; i < last; ++i) {
			current = prophecy.substring(i, i + 10);
			bad = false;
			for (int j = 0; j < 10; ++j)
				if (j != 5 && j != 2) {
					if (!(current.charAt(j) <= '9') || !(current.charAt(j) >= '0')) {
						bad = true;
						break;
					}
				} else if (current.charAt(j) != '-') {
					bad = true;
					break;
				}
			if (bad)
				continue;
			int day = 10 * (current.charAt(0) - '0') + (current.charAt(1) - '0');
			int month = 10 * (current.charAt(3) - '0') + (current.charAt(4) - '0');
			int year = 1000 * (current.charAt(6) - '0') + 100 * (current.charAt(7) - '0') +
					10 * (current.charAt(8) - '0') + (current.charAt(9) - '0');
			if (isValid(day, month, year)) {
				++counter[day][month][year - 2013];
				if (counter[day][month][year - 2013] > max) {
					max = counter[day][month][year - 2013];
					lastDay = day;
					lastMonth = month;
					lastYear = year;
				}
			}
		}
		out.print(lastDay / 10);
		out.print(lastDay % 10);
		out.print("-");
		out.print(lastMonth / 10);
		out.print(lastMonth % 10);
		out.print("-");
		out.print(lastYear);
	}
	
	private boolean isValid(int day, int month, int year) {
		return (month > 0 && month < 13) && (day > 0 && day <= months[month]) && 
				(year < 2016 && year > 2012);
	}

}
