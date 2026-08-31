
import java.util.*;
import java.io.*;

public class Codeforces {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void newST() throws IOException {st = new StringTokenizer(in.readLine());}
	static int stInt() {return Integer.parseInt(st.nextToken());}
	static String stStr() {return st.nextToken();}
	static int[] getInts(int n) throws IOException {newST(); int[] arr = new int[n]; for (int i = 0; i < n; i++) arr[i] = stInt(); return arr;}
	static int readInt() throws IOException {return Integer.parseInt(in.readLine());}
	static void println(Object o) {System.out.println(o);}
	static void print(Object o) {System.out.print(o);}
	static final int[] check = new int[] {1,2,3,5,6,7,9,10,11};
	static final int dim = check.length;
	public static void main(String[] args) throws Exception {
		newST();
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		double z = Double.parseDouble(st.nextToken());
		Expr max = new Expr(x,y,z,0);
		int mdx = 1;
		for (int i : check) {
			Expr k = get(x,y,z,i);
			//System.out.println(k.loglog());
			if (max.isBigger(k)) {
				max = k;
				mdx = i;
			}
		}
		println(str(mdx));
		//println(new Expr(4.0,133.2,.6, 1).loglog());
	}
	public static Expr get(double x, double y, double z, int q) {
		switch (q) {
		case  1: return new Expr(x,y,z,0);
		case  2: return new Expr(x,z,y,0);
		case  3: return new Expr(x,y,z,1);
		case  4: return new Expr(x,z,y,1);
		case  5: return new Expr(y,x,z,0);
		case  6: return new Expr(y,z,x,0);
		case  7: return new Expr(y,x,z,1);
		case  8: return new Expr(y,z,x,1);
		case  9: return new Expr(z,x,y,0);
		case 10: return new Expr(z,y,x,0);
		case 11: return new Expr(z,x,y,1);
		case 12: return new Expr(z,y,x,1);
		default: return new Expr(0,0,0,0);
		}
	}
	public static String str(int q) {
		switch (q) {
		case 1: return "x^y^z";
		case 2: return "x^z^y";
		case 3: return "(x^y)^z";
		case 4: return "(x^z)^y";
		case 5: return "y^x^z";
		case 6: return "y^z^x";
		case 7: return "(y^x)^z";
		case 8: return "(y^z)^x";
		case 9: return "z^x^y";
		case 10: return "z^y^x";
		case 11: return "(z^x)^y";
		case 12: return "(z^y)^x";
		default: return "";
		}
	}
	public static double f1(double x, double y, double z) {
		return z*Math.log(y)+Math.log(Math.log(x));
	}
	public static double f2(double x, double y, double z) {
		return Math.log(y*z*Math.log(x));
	}
	public static boolean check(double x, double y) {
		return y > x+.000001;
	}
}
class Expr {
	double x, y, z;
	int t;
	public Expr(double xx, double yy, double zz, int tt) {
		x = xx;
		y = yy;
		z = zz;
		t = tt;
	}
	public int signl1() {
		if (x == 1) return 0;
		else if (x > 1) return 1;
		else return -1;
	}
	public Double loglog() {
		int sl1 = signl1();
		if (sl1 == 0) return null;
		double lx = Math.log(x);
		if (sl1 == -1) lx = -lx;
		double ans;
		if (t == 0) {
			ans = z*Math.log(y)+Math.log(lx);
		}
		else ans = Math.log(y)+Math.log(z)+Math.log(lx);
		if (sl1 == -1) ans *= -1;
		return ans;
	}
	public boolean isBigger(Expr e) {
		if (signl1() > e.signl1()) return false;
		if (signl1() < e.signl1()) return true;
		if (signl1() == 0) return false;
		return loglog() + .000001 < e.loglog();
	}
}