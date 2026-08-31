import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		int len[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Scanner myScanner = new Scanner(System.in);
		char[] s = myScanner.next().toCharArray();
		int freq[][][] = new int[32][13][3];
		int max = 0, maxday = 0, maxmonth = 0, maxyear = 0;
		label: for (int i = 0; i + 9 < s.length; i++) {
			if (s[i + 2] != '-' || s[i + 5] != '-')
				continue;
			for (int j = 0; j < 10; j++)
				if (j != 2 && j != 5 && s[i + j] == '-')
					continue label;
			int day = new Integer("" + s[i] + "" + s[i + 1]);
			int month = new Integer(s[i + 3] + "" + s[i + 4] + "");
			int year = new Integer(s[i + 6] + "" + "" + s[i + 7] + "" + ""
					+ s[i + 8] + "" + s[i + 9] + "");
			if (month > 12 || day < 1 || day > len[month] || year < 2013
					|| year > 2015)
				continue;

			freq[day][month][year - 2013]++;
			if (freq[day][month][year - 2013] > max) {
				max = freq[day][month][year - 2013];
				maxday = day;
				maxmonth = month;
				maxyear = year;
			}
		}

		String d = maxday + "";
		if (d.length() == 1)
			d = '0' + d;
		String m = maxmonth + "";
		if (m.length() == 1)
			m = '0' + m;
		System.out.println(d + "-" + m + "-" + maxyear);
	}
}
