import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	static String input;
	
	static String[] monthes = {
		"01", "02" , "03" , "04" , "05" , "06" , "07" , "08" , "09"
		,"10" , "11" , "12"
	};
	
	static boolean validYear(String x) {
		return x.equals("2013") || x.equals("2014") || x.equals("2015");
	}
	
	static boolean validmonth(String t) {
		for(int i = 0 ; i < 12 ; ++i)
			if ( t.equals(monthes[i]))
				return true;
		return false;
	}
	
	static boolean is30(int x) {
		return x == 4 || x == 6 || x == 9 || x == 11;
	}
	
	static boolean validDay(String t, int month, int year) {
		if(t.length() != 2 || !Character.isDigit(t.charAt(0))
				|| !Character.isDigit(t.charAt(1))) return false;
		int tt = Integer.parseInt(t);
		if(month == 2) return tt >= 1 && tt <= 28;
		if( is30(month) ) return tt >= 1 && tt <= 30;
		return tt >= 1 && tt <= 31;
	}
	
	static int[][][] table = new int[33][14][2017];
	
	public static void main(String[] args) throws IOException {
		input = in.readLine();
		StringBuilder year = new StringBuilder(input.substring(0, 3));
		StringBuilder month, day;
		int ans_d = 0, ans_m = 0, ans_y = 0, cnt = -1;
		for(int i = 3 ; i < input.length() ; ++i) {
			year.append(input.charAt(i));
			if ( validYear(year.toString()) ) {
				if( i >= 9 ) {
					if ( input.charAt(i-7) == '-'
							&& input.charAt(i-4) == '-'
							&&input.charAt(i-6) != '-'
							&& input.charAt(i-5) != '-'
							&& input.charAt(i-8) != '-'
							&& input.charAt(i-9) != '-') {
						month = new StringBuilder("");
						month.append(input.charAt(i-6));
						month.append(input.charAt(i-5));
						day = new StringBuilder("");
						day.append(input.charAt(i-9));
						day.append(input.charAt(i-8));
						if ( validmonth(month.toString()) 
								&& validDay(day.toString(), Integer.parseInt(month.toString())
										, Integer.parseInt(year.toString()))) {
							++table[Integer.parseInt(day.toString())]
								 [Integer.parseInt(month.toString())]
								 [Integer.parseInt(year.toString())];
							if(table[Integer.parseInt(day.toString())]
								 [Integer.parseInt(month.toString())]
								 [Integer.parseInt(year.toString())] > cnt) {
								cnt = table[Integer.parseInt(day.toString())]
										 [Integer.parseInt(month.toString())]
												 [Integer.parseInt(year.toString())];
								ans_d = Integer.parseInt(day.toString());
								ans_m = Integer.parseInt(month.toString());
								ans_y = Integer.parseInt(year.toString());
							}
						}
							
					}
				}
			}
			year.deleteCharAt(0);
		}
		System.out.printf("%02d-%02d-%d",ans_d,ans_m,ans_y);
	}
}
