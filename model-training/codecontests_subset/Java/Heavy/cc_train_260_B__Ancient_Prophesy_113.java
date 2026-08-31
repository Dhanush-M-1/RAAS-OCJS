import java.util.Arrays;
import java.util.Scanner;

public class Prob260B {
	public static void main(String[] Args) {
		int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
				31 };

		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int numDashes = 0;
		for (int i = 0; i < s.length(); i++)
			numDashes += s.charAt(i) == '-' ? 1 : 0;

		int[] dashes = new int[numDashes];
		numDashes = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == '-')
				dashes[numDashes++] = i;

		int[] dates = new int[numDashes];
		int numDates = 0;

		for (int i = 1; i < numDashes; i++)
			if (dashes[i - 1] >= 2 && dashes[i] < s.length() - 4)
				if (dashes[i] - dashes[i - 1] == 3
						&& isValid(s
								.substring(dashes[i - 1] - 2, dashes[i] + 5))) {
					int date = Integer.parseInt(s.substring(dashes[i - 1] - 2,
							dashes[i - 1]));
					int month = Integer.parseInt(s.substring(dashes[i - 1] + 1,
							dashes[i]));
					int year = Integer.parseInt(s.substring(dashes[i] + 1,
							dashes[i] + 5));

					if (year >= 2013 && year <= 2015)
						if (month >= 1 && month <= 12)
							if (date >= 1 && date <= months[month - 1])
								dates[numDates++] = (month * 32 + date) * 10000
										+ year;
				}

		Arrays.sort(dates);

		int index = dates.length - numDates;
		int maxOcc = dates[index];
		int maxOccTimes = 1;

		int curOcc = dates[index];
		int curOccTimes = 1;

		for (int i = index + 1; i < dates.length; i++) {
			if (curOcc == dates[i])
				curOccTimes++;
			else {
				if (curOccTimes > maxOccTimes) {
					maxOcc = curOcc;
					maxOccTimes = curOccTimes;
				}
				curOcc = dates[i];
				curOccTimes = 1;
			}
		}

		if (curOccTimes > maxOccTimes) {
			maxOcc = curOcc;
			maxOccTimes = curOccTimes;
		}

		String date = "" + (maxOcc / 10000 % 32);
		String month = "" + (maxOcc / 10000 / 32);
		String year = "" + (maxOcc % 10000);

		if (date.length() == 1)
			date = "0" + date;
		if (month.length() == 1)
			month = "0" + month;

		System.out.println(date + "-" + month + "-" + year);
	}

	private static boolean isValid(String s) {
		int[] indices = new int[] { 0, 1, 3, 4, 6, 7, 8, 9 };
		for (int i = 0; i < indices.length; i++)
			if (!Character.isDigit(s.charAt(indices[i])))
				return false;
		return true;
	}
}
