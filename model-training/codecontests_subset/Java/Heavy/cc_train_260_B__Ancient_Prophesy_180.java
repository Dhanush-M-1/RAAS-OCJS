import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		int len[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Scanner myScanner = new Scanner(System.in);
		char[] s = myScanner.next().toCharArray();
		int freq[][][] = new int[32][13][3];
		int max = 0, md = 0, mm = 0, my = 0;
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
				md = day;
				mm = month;
				my = year;
			}
		}
		System.out.printf("%d%d-%d%d-%d\n", md / 10, md % 10, mm / 10, mm % 10,
				my);
	}
}
