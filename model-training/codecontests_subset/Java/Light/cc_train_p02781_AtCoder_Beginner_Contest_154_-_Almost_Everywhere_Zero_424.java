import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		new Main(new Scanner(System.in), System.out, System.err).exec();
	}
	public final Scanner sc;
	public final PrintStream out, err;
	public Main(final Scanner sc, final PrintStream out, final PrintStream err) {
		this.sc = sc;this.out = out;this.err = err;
	}
	static public final long pair(int a, int b) {return (((long)a) << 32) + b;}
	static public final int getPair1(long v) {return (int)(v >> 32);}
	static public final int getPari2(long v) {return (int)(v & 0xFFFFFFFF);}

	static public final long quad(long a, long b, long c, long d) {
		return ((a&0xFFFF)<< 48) + ((b&0xFFFF)<< 32) + ((c&0xFFFF)<< 16) +(d&0xFFFF);}
	static public final int getQuad1(long v) {return (int)( v >> 48          );}
	static public final int getQuad2(long v) {return (int)((v >> 32) & 0xFFFF);}
	static public final int getQuad3(long v) {return (int)((v >> 16) & 0xFFFF);}
	static public final int getQuad4(long v) {return (int)( v        & 0xFFFF);}

	static public final long record(int e, int m, int i) {
		return quad(-1, e, m, i);
	}
	static public final int re(long record) {
		return getQuad2(record);
	}
	static public final int rm(long record) {
		return getQuad3(record);
	}
	static public final int ri(long record) {
		return getQuad4(record);
	}

	//------------------------------------------

	private int p;
	private int[] inv;
	private int[] fact;
	private int[] finv;
	public final int mod(long v) {
		v %= p;
		return (int)(v < 0 ? v+p : v);
	}
	public final int mul(long a, long b) {
		return mod(a*b);
	}
	public final void initFact(double limit, double p) {
		initFact((int)limit, (int)p);
	}
	public final void initFact(int limit, int p) {
		this.p = p;
		this.inv = new int[limit+1];
		this.fact = new int[limit+1];
		this.finv = new int[limit+1];
		fact[1] = finv[1] = inv[0] = inv[1] = 1;
		for(int i=2;i<=limit;i++) {
			int a = p / i;
			int b = p % i;
			inv[i]  = mul(-a, inv[b]);
			fact[i] = mul(fact[i-1], i);
			finv[i] = mul(finv[i-1], inv[i]);
		}
	}
	public final int comb(int m, int n) {
		return mul(mul(fact[m], finv[n]), finv[m-n]);
	}
	//------------------------------------------
	static long lcm (long a, long b) {
		long temp;
		long c = a;
		c *= b;
		while((temp = a%b)!=0) {
			a = b;
			b = temp;
		}
		return (long)(c/b);
	}

	//------------------------------------------



	public void exec() throws Exception{
		final String N = sc.next();
		final int K = sc.nextInt();

		// 桁数が足りない場合は1件もない。
		if(N.length()<K) {
			out.println(0);
			return;
		}
		final int[] ni = new int[N.length()];
		for(int i=0;i<N.length();i++) {
			ni[i] = N.charAt(i)-'0';
		}

		// 桁数が同じ場合は全探索してしまう。
		if(N.length()==K) {
			out.println(countFull(ni, K, 0));
			return;
		}

		out.println(count(ni, K, 0));

	}
	static public int countFull(int[] ni, int k, int index) {
		if(k==1) {
			return ni[index];
		}
		// 2けた
		if(k==2) {
			int max = ni[index]*10+ ni[index+1];
			int cnt = 0;
			for(int b=1;b<=9;b++) {
				int nb = b*10;
				for(int c=1;c<=9;c++) {
					int nbc = nb+c;
					if(nbc <= max) {
						cnt ++;
					}else {
						return cnt;
					}
				}
			}
		}
		// 3けた
		int max = ni[index]*100+ ni[index+1]*10+ni[index+2];
		int cnt = 0;
		for(int a=1;a<=9;a++) {
			int na = 100*a;
			for(int b=1;b<=9;b++) {
				int nab = na + b*10;
				for(int c=1;c<=9;c++) {
					int nabc = nab+c;
					if(nabc <= max) {
						cnt ++;
					}else {
						return cnt;
					}
				}
			}
		}
		return cnt;
	}
	static public int count(int[] ni, int k, int index) {
		if(ni[index]==0) {
			// 先頭が0しか選べない。
			if(ni.length-index-1 == k) {
				// 選択の余地がない
				return 0;
			}else {
				// 先頭はゼロで、下位からk個選択する。
				return count(ni, k, index+1);
			}
		}
		int cnt = 0;
		// 先頭が0のケース
		{
			// 上位一桁が0の場合、それ以下での任意のけたで3つ数字が選択される。
			final int LEN = ni.length-index;
			int a = 1;
			int b = 1;
			int c = 1;
			for(int i=1;i<=k;i++) {
				a *= LEN-i;
				b *= i;
				c *= 9;
			}
			cnt += (a / b) * c;
		}
		if(k==1) {
			// 先頭のけたしか選択できない場合
			cnt += ni[index];
			return cnt;
		}

		// 先頭が0以外、かつni[index]以外のケース
		{
			// 上位一桁が0の場合、それ以下での任意のけたで3つ数字が選択される。
			final int LEN = ni.length-index;
			int a = 1;
			int b = 1;
			int c = 1;
			for(int i=1;i<=k-1;i++) {
				a *= LEN-i;
				b *= i;
				c *= 9;
			}
			cnt += (ni[index]-1) * (a / b) * c;
		}

		// 先頭がni[index]のケース

		cnt += count(ni, k-1, index+1);
		return cnt;
	}
}
