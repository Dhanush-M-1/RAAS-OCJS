import java.util.*;
import java.io.*;
public class B {
	int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public void solve() throws IOException {
		String string = nextToken();
		char[] str = string.toCharArray();
		char zero = '0';
		boolean[] num = new boolean[str.length];
		for(int i = 0; i < str.length; i++){
			if( Character.isDigit(str[i]) ){
				num[i] = true;
			}
		}
		int max = 0;
		String ans = new String();
		int[][][] map = new int[3][13][32];
	out:
		for(int i = 0; i < str.length-9; i++){
	//		writer.println(string.substring(i, i+10));
			if( str[i+2] != '-' && str[i+5] != '-' ){
				continue;
			}
			for(int j = 0; j < 10; j++){
				if( j == 2 || j == 5 ){
					if( num[i+j] ){
						continue out;	
					}
					continue;
				}
				if( !num[i+j] ){
					continue out;
				}
			}
			int year = str[i+6]*1000+str[i+7]*100+str[i+8]*10+str[i+9]-1111*zero;
			int day = str[i]*10+str[i+1]-11*zero;
			int month = str[i+3]*10+str[i+4]-11*zero;
	//		writer.println(string.substring(i, i+10) + " " + year + " " + month + " " + day);
			if( year < 2013 || year > 2015 || month < 1 || month > 12 ){
				continue;
			}
			if( day >= 1 && day <= days[month-1] ){
				String sub = string.substring(i, i+10);
				map[year-2013][month][day]++;
				if( max < map[year-2013][month][day] ){
					max = map[year-2013][month][day];
					ans = sub;
				}
			}
		}
		writer.println(ans);
	}

	public static void main(String[] args) throws IOException {
		new B().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() throws IOException {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
			writer = new PrintWriter(System.out);
			solve();
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

}
