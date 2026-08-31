import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Works good for CF
 * 
 * @author cykeltillsalu
 */
public class B {

	// some local config
	static boolean test = false;
	static String testDataFile = "testdata.txt";
	static String feedFile = "feed.txt";
	CompetitionType type = CompetitionType.CF;
	private static String ENDL = "\n";

	int[] len = new int[]{31,28,31,30,31,30,31,31,30, 31, 30, 31};
	
	// solution
	private void solve() throws Throwable {
		String wrd = wread();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < wrd.length()-9; i++) {

			String substring = wrd.substring(i, i + 10);
			if (substring.charAt(2) != '-' || substring.charAt(5) != '-') {
				continue;
			}
			try {
				int day = Integer.parseInt(substring.substring(0, 2));
				int month = Integer.parseInt(substring.substring(3, 5));
				int year = Integer.parseInt(substring.substring(6, 10));
				
				if(month >= 1 && month <= 12 && day >= 1 && day <= len[month-1] && year >= 2013 && year <= 2015){
					Integer val = map.get(substring);
					if(val == null){
						val = 0;
					}
					map.put(substring, val + 1);
				}
				
			} catch (Throwable t) {
				t.printStackTrace();
				continue;
			}
		}
		
		int max = 0;
		String maxStr = "";
		for (String key : map.keySet()) {
			Integer integer = map.get(key);
			if(integer > max){
				max = integer;
				maxStr = key;
			}
		}
		System.out.println(maxStr);
	}

	public int iread() throws Exception {
		return Integer.parseInt(wread());
	}

	public double dread() throws Exception {
		return Double.parseDouble(wread());
	}

	public long lread() throws Exception {
		return Long.parseLong(wread());
	}

	public String wread() throws IOException {
		StringBuilder b = new StringBuilder();
		int c;
		c = in.read();
		while (c >= 0 && c <= ' ')
			c = in.read();
		if (c < 0)
			return "";
		while (c > ' ') {
			b.append((char) c);
			c = in.read();
		}
		return b.toString();
	}

	public static void main(String[] args) throws Throwable {

		if (test) { // run all cases from testfile:
			BufferedReader testdataReader = new BufferedReader(new FileReader(testDataFile));
			String readLine = testdataReader.readLine();
			int casenr = 0;
			out: while (true) {
				BufferedWriter w = new BufferedWriter(new FileWriter(feedFile));
				if (!readLine.equalsIgnoreCase("input")) {
					break;
				}
				while (true) {
					readLine = testdataReader.readLine();
					if (readLine.equalsIgnoreCase("output")) {
						break;
					}
					w.write(readLine + "\n");
				}
				w.close();
				System.out.println("Answer on case " + (++casenr) + ": ");

				new B().solve();
				System.out.println("Expected answer: ");

				while (true) {
					readLine = testdataReader.readLine();

					if (readLine == null) {
						break out;
					}
					if (readLine.equalsIgnoreCase("input")) {
						break;
					}
					System.out.println(readLine);
				}
				System.out.println("----------------");
			}
			testdataReader.close();
		} else { // run on server
			new B().solve();
		}
		out.close();
	}

	public B() throws Throwable {
		if (test) {
			in = new BufferedReader(new FileReader(new File(feedFile)));
		}
	}

	InputStreamReader inp = new InputStreamReader(System.in);
	BufferedReader in = new BufferedReader(inp);
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	enum CompetitionType {
		CF, OTHER
	};
}