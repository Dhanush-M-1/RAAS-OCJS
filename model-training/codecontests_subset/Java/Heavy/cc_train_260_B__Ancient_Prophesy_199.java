// 21:38
// 22:09
import java.util.*;
import java.util.regex.Pattern;

public class B {
	Scanner sc = new Scanner(System.in);
	Pattern pat = Pattern.compile("[0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]");
	void doIt()
	{
		TreeMap<Date, Integer> rec = new TreeMap<Date, Integer>();
		String line = sc.nextLine();
		for(int i = 0; i <= line.length() - 10; i++) {
			String d = line.substring(i, i+10);
			if(pat.matcher(d).matches()) {
				Date cand = new Date(Integer.parseInt(d.substring(6)),
						Integer.parseInt(d.substring(3, 5)),
						Integer.parseInt(d.substring(0, 2)));
				if(cand.isValid()) {
					//System.out.println(d);
					if(rec.containsKey(cand)) rec.put(cand, rec.get(cand) + 1);
					else rec.put(cand, 1);
				}
			}
		}
		Date ans = null;
		int max_v = 0;
		for(Date d : rec.keySet()) {
			if(rec.get(d) > max_v) {
				max_v = rec.get(d);
				ans = d;
			}
		}
		System.out.println(ans);
		
	}
	public static void main(String[] args) {
		new B().doIt();
	}
	class Date implements Comparable<Date>{
		int year, month, day;
		Date(int year, int month, int day) {
			this.year = year; 
			this.month = month;
			this.day = day;
		}
		boolean isValid() {
			if(year <= 2012) return false;
			if(year >= 2016) return false;
			if(month <= 0) return false;
			if(month >= 13) return false;
			int d = 31;
			if(month == 2) d = 28;
			else if(month >= 8) {
				if (month % 2 != 0) d = 30;
			} else {
				if (month % 2 == 0) d = 30;
			}
			if(day <= 0 || day > d) return false;
			return true;
		}
		public int compareTo(Date d)
		{
			int s1 = year * 500 + month * 40 + day;
			int s2 = d.year * 500 + d.month * 40 + d.day;
			return s1 - s2;
		}
		public String toString()
		{
			String ans = String.format("%02d-%02d-%04d", day, month, year);
			return ans;
		}
	}
}
