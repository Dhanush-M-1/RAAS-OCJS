import static java.lang.Math.*;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.exit;
import static java.lang.System.arraycopy;
import static java.util.Arrays.sort;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.fill;
import java.util.*;
import java.io.*;

import com.sun.corba.se.spi.ior.MakeImmutable;

public class Main {

	public static void main(String[] args) throws IOException {
		try {
			if (new File("input.txt").exists())
				System.setIn(new FileInputStream("input.txt"));
		} catch (SecurityException e) {
		}
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new Main().run();
				} catch (Throwable e) {
					e.printStackTrace();
					exit(999);
				}
			}
		}, "1", 1 << 23).start();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	int gcd(int a, int b){
		while(a != 0){
			b %= a;
			a ^= b;
			b ^= a;
			a ^= b;
		}
		return b;
	}
	
	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	HashMap<String, Integer> dhm = new HashMap<String, Integer>();
	HashMap<String, Integer> rhm = new HashMap<String, Integer>();
	
	int gc(HashMap<String, Integer> hm, int x){
		int a = x;
		int b = rev(a);
		int g = gcd(a, b);
		a/=g;
		b/=g;
		String s = new String(a + " / " + b);
		if(hm.containsKey(s))
			return hm.get(s);
		else
			return 0;
	}
	void add(HashMap<String, Integer> hm, int x){
		int a = x;
		int b = rev(a);
		int g = gcd(a, b);
		a/=g;
		b/=g;
		String s = new String(b + " / " + a);
		if(hm.containsKey(s)){
			hm.put(s, hm.get(s) + 1);
		}
		else{
			hm.put(s, 1);
		}
	}
	void rem(HashMap<String, Integer> hm, int x){
		int a = x;
		int b = rev(a);
		int g = gcd(a, b);
		a/=g;
		b/=g;
		String s = new String(b + " / " + a);
		int c = hm.get(s);
		if(c == 1)
			hm.remove(s);
		else
			hm.put(s, c - 1);
	}
	private void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		int mx = nextInt();
		int my = nextInt();
		int w = nextInt();
		int max = max(mx,my);
		int MY = min(mx, my);
		int ax = 0;
		int ay = 0;
		long mc[] = new long[max + 2];
		for(int i = 1; i <= max; i++){
			mc[i] = mc[i-1] + 2 * gc(hm, i);
			if(i == rev(i))
				mc[i]++;
			add(hm, i);
		}
		int miny[] = new int[max + 1];
		long rez[] = new long[max + 1];
		int low = 0;
		long A = Long.MAX_VALUE;
		for(int x = 1; x <= max; x++){
			if(mc[x] < w){
				miny[x] = x;
				add(rhm, x);
				add(dhm, x);
				rez[x] = mc[x];
				low = x;
				continue;
			}
			else{
				long sum = rez[x-1];
				sum += gc(rhm, x);
				add(dhm, x);
				while(sum >= w && low > 0){
					rem(rhm, low);
					sum -= gc(dhm, low);
					low--;
				}
				if(sum < w ){
					low++;
					add(rhm, low);
					sum += gc(dhm, low);
				}
				rez[x] = sum;
				if(x * low < A && low <= MY){
					ax = x;
					ay = low;
					A = x * low;
				}
			}
		}
		if(ax > mx){
			ax ^= ay;
			ay ^= ax;
			ax ^= ay;
		}
		if(A != Long.MAX_VALUE )
			out.println(ax + " " + ay);
		else
			out.println("-1");
//		int ans = 0;
//		for(int i = 1; i <= ax; i++)
//			for(int j = 1; j <= ay; j++)
//				if(i * j == rev(i) * rev(j))
//					ans++;
//		out.println(ans);
		
		in.close();
		out.close();
	}
	int dop[] = new int[10];
	int rev(int a){
		int ans = 0;
		int pos = 0;
		while(a != 0){
			dop[pos++] = a%10;
			a/=10;
		}
		int pow = 1;
		for(int i = pos - 1; i >= 0; i--){
			ans += pow * dop[i];
			pow *= 10;
		}
		return ans;
	}
	
	void chk(boolean b) {
		if (b)
			return;
		System.out.println(new Error().getStackTrace()[1]);
		exit(999);
	}
	void deb(String fmt, Object... args) {
		System.out.printf(Locale.US, fmt + "%n", args);
	}
	String nextToken() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null)
				return true;
			st = new StringTokenizer(s);
		}
		return false;
	}
}
