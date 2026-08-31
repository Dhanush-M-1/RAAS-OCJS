import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C1244 {

	public static void main(String[] args) throws Exception {
//		StringTokenizer stok = new StringTokenizer(new Scanner(new File("F:/books/input.txt")).useDelimiter("\\A").next());
		StringTokenizer stok = new StringTokenizer(new Scanner(System.in).useDelimiter("\\A").next());
		StringBuilder sb = new StringBuilder();
		Long n = Long.parseLong(stok.nextToken());
		Long p = Long.parseLong(stok.nextToken());
		Long w = Long.parseLong(stok.nextToken());
		Long d = Long.parseLong(stok.nextToken());
		long gcd = GCD(GCD(p,w),d);
		p /= gcd;
		w /= gcd;
		d /= gcd;
		long x = p/w;
		long r = (p%w)%d;
		long wd = w%d;
		long v = calc(r,wd,d);
		if(v==-1) {
			System.out.println("-1");
			System.exit(0);
		}
		x -= v;
		long y = (p-x*w)/d;
		if(x>=0 && y>=0 && (x+y)<=n) sb.append(x+" "+y+" "+(n-x-y));
		else sb.append("-1");
		System.out.print(sb);
	}
	
	private static long calc(long r, long wd, Long d) {
		for(long i=0;i<d;i++) if((r+i*wd)%d==0) return i;
		return -1;
	}

	private static long GCD(long x, long y) {
		if(x==0) return y;
		return GCD(y%x,x);
	}
	
}
