import java.util.*;
public class B{
	static final int [] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		final String line = s.nextLine();
		String res = "";
		int count = 0;
		for (int y = 2013; y <= 2015; ++y){
			for (int m = 1; m <= 12; ++m){
				for (int d = 1; d <= DAYS[m - 1]; ++d){
					final String date = String.format("%02d-%02d-%04d", d, m, y);
					int c = 0;
					for (int i = line.indexOf(date, 0); i >= 0; i = line.indexOf(date, i + 1)){
						c++;
					}
					if (c > count){
						count = c;
						res = date;
					}
				}
			}
		}
		System.out.println(res);
	}
}