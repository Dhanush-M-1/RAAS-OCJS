import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B {
	static BufferedReader stdin = new BufferedReader(new
			InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");
	static HashMap<Date, Integer> hm = new HashMap<Date, Integer>();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	static char[] carr = {};
	
	public static void main(String[] args) throws Exception {
		sdf.setLenient(false);
		carr = readString().toCharArray();
		for (int i = 0; i < carr.length; i++){
			if (carr[i] == '-')
				addIfLegal(i-2);
		}
		int best = 0;
		Date b = null;
		for (Date d : hm.keySet()){
			int cur = hm.get(d);
			if (best < cur){
				b = d;
				best = cur;
			}
		}
		Calendar c = Calendar.getInstance();
		c.setTime(b);
		System.out.printf("%02d-%02d-%04d\n", c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH)+1,
				c.get(Calendar.YEAR));
	}
	
	static void addIfLegal(int start){
		if (start < 0 ||
		    carr.length <= start + 9 ||
		    carr[start+2] != '-' || carr[start+5] != '-') return;
		try {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 10; i++)
				sb.append(carr[start+i]);
			Date d = sdf.parse(sb.toString());
			if (d != null){
				if ((2012-1900) < d.getYear() && d.getYear() < (2016-1900)){
					if (!hm.containsKey(d)){
						hm.put(d, 0);
					}
					hm.put(d, hm.get(d)+1);
				}
			}
		} catch (Exception e){
			
		}
	}
	
	static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}
	
	static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
	
	static long readLong() throws Exception {
		return Long.parseLong(readString());
	}
	
	static double readDouble() throws Exception {
		return Double.parseDouble(readString());
	}
}
