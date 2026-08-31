import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class B {
	
	static StringTokenizer st;
	static BufferedReader in;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s = next();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i <= s.length()-10; i++) {
			String []ss = s.substring(i, i+10).split("-");
			String w = s.substring(i, i+10);
			if (w.startsWith("-") || w.endsWith("-"))
				continue;
			if (ss.length==3 && ss[0].length()==2 && ss[1].length()==2 && ss[2].length()==4) {
				boolean f = true;
				for (int j = 0; j < 3; j++) {
					if (ss[j].length()==0) {
						f = false;
					}
				}
				if (f) {
					int dd = Integer.parseInt(ss[0]), mm = Integer.parseInt(ss[1]), yy = Integer.parseInt(ss[2]);
					if (yy >= 2013 && yy <= 2015 && mm >= 1 && mm <= 12) {
						int max = 31;
						if (mm==4 || mm==6 || mm==9 || mm==11)
							max = 30;
						if (mm==2)
							max = 28;
						if (dd > 0 && dd <= max) {
							String m = mm+"";
							if (mm < 10)
								m = "0"+m;
							String d = dd+"";
							if (dd < 10)
								d = "0"+d;
							String q = d+"-"+m+"-"+yy;
							if (!map.containsKey(q))
								map.put(q, 1);
							else
								map.put(q, map.get(q)+1);
						}
					}
				}
			}
		}
		int ans = 0;
		String q = "";
		for (String i : map.keySet()) {
			if (map.get(i) > ans) {
				ans = map.get(i);
				q = i;
			}
		}
		System.out.println(q);
		pw.close();
	}
	private static int nextInt() throws IOException{
		return Integer.parseInt(next());
	}
	
	private static long nextLong() throws IOException{
		return Long.parseLong(next());
	}
	
	private static double nextDouble() throws IOException{
		return Double.parseDouble(next());
	}
	
	private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
}
//777-444---21-12-2003-12-2003-12-2003--444-777