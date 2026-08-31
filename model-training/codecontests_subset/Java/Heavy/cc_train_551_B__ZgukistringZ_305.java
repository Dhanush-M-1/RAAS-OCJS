import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					long prevTime = System.currentTimeMillis();
					new Main().run();
					System.err.println("Total time: "
							+ (System.currentTimeMillis() - prevTime) + " ms");
					System.err.println("Memory status: " + memoryStatus());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "1", 1L << 24).start();
	}

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		Object o = solve();
		if (o != null)
			out.println(o);
		out.close();
		in.close();
	}

	private Object solve() throws IOException {
		String a = in.readLine();
		String b = in.readLine();
		String c = in.readLine();
		
		
		int[] chars_a = parse(a);
		int[] chars_b = parse(b);
		int[] chars_c = parse(c);
		
		int ret_b = 0;
		int ret_c = 0;
		
		for(int ret =0;ret<= 100000;ret++){
			int[] aux = chars_a.clone();
			
			for(int i =0;i<26;i++)
				aux[i]-= chars_b[i]* ret;
			boolean neg = false;
			for(int val : aux)
				if(val<0)
					neg = true;
			if(neg)
				break;
			int count =Integer.MAX_VALUE;
			for(int i =0;i<26;i++)
				if(chars_c[i]!=0)
					count = Math.min(count, aux[i]/chars_c[i]);
			if(ret_b + ret_c < ret + count){
				ret_b = ret;
				ret_c = count;
			}
		}
		
		StringBuilder str = new StringBuilder();
		for(int i =0;i < ret_b;i++){
			str.append(b);
			for(int j =0;j<26;j++)
				chars_a[j]-=chars_b[j];
		}
		
		for(int i =0;i < ret_c;i++){
			str.append(c);
			for(int j =0;j<26;j++)
				chars_a[j]-=chars_c[j];
		}
		
		for(int i =0;i<26;i++)
			while(chars_a[i]!=0){
				str.append((char) ('a' + i) );
				chars_a[i]--;
			}
		return str;
	}

	private int[] parse(String s) {
		int[] ret = new int[26];
		for(int i =0;i<s.length();i++)
			ret[s.charAt(i)-'a']++;
		
		return ret;
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer strTok = new StringTokenizer("");

	String nextToken() throws IOException {
		while (!strTok.hasMoreTokens())
			strTok = new StringTokenizer(in.readLine());
		return strTok.nextToken();
	}

	int ni() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nl() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nd() throws IOException {
		return Double.parseDouble(nextToken());
	}

	int[] nia(int size) throws IOException {
		int[] ret = new int[size];
		for (int i = 0; i < size; i++)
			ret[i] = ni();
		return ret;
	}

	long[] nla(int size) throws IOException {
		long[] ret = new long[size];
		for (int i = 0; i < size; i++)
			ret[i] = nl();
		return ret;
	}

	double[] nda(int size) throws IOException {
		double[] ret = new double[size];
		for (int i = 0; i < size; i++)
			ret[i] = nd();
		return ret;
	}

	String nextLine() throws IOException {
		strTok = new StringTokenizer("");
		return in.readLine();
	}

	boolean EOF() throws IOException {
		while (!strTok.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			strTok = new StringTokenizer(s);
		}
		return false;
	}

	void printRepeat(String s, int count) {
		for (int i = 0; i < count; i++)
			out.print(s);
	}

	void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}

	void printArray(long[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}

	void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.print(array[i]);
		}
		out.println();
	}

	void printArray(double[] array, String spec) {
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				out.print(' ');
			out.printf(Locale.US, spec, array[i]);
		}
		out.println();
	}

	void printArray(Object[] array) {
		boolean blank = false;
		for (Object x : array) {
			if (blank)
				out.print(' ');
			else
				blank = true;
			out.print(x);
		}
		out.println();
	}

	@SuppressWarnings("rawtypes")
	void printCollection(Collection collection) {
		boolean blank = false;
		for (Object x : collection) {
			if (blank)
				out.print(' ');
			else
				blank = true;
			out.print(x);
		}
		out.println();
	}

	static String memoryStatus() {
		return (Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory() >> 20)
				+ "/" + (Runtime.getRuntime().totalMemory() >> 20) + " MB";
	}

	public void pln() {
		out.println();
	}

	public void pln(int arg) {
		out.println(arg);
	}

	public void pln(long arg) {
		out.println(arg);
	}

	public void pln(double arg) {
		out.println(arg);
	}

	public void pln(String arg) {
		out.println(arg);
	}

	public void pln(boolean arg) {
		out.println(arg);
	}

	public void pln(char arg) {
		out.println(arg);
	}

	public void pln(float arg) {
		out.println(arg);
	}

	public void pln(Object arg) {
		out.println(arg);
	}

	public void p(int arg) {
		out.print(arg);
	}

	public void p(long arg) {
		out.print(arg);
	}

	public void p(double arg) {
		out.print(arg);
	}

	public void p(String arg) {
		out.print(arg);
	}

	public void p(boolean arg) {
		out.print(arg);
	}

	public void p(char arg) {
		out.print(arg);
	}

	public void p(float arg) {
		out.print(arg);
	}

	public void p(Object arg) {
		out.print(arg);
	}

}