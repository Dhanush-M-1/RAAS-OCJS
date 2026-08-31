import java.util.Scanner;
import java.util.Arrays;
import java.util.Vector;

public class D{
	static final long REMAIN = 998_244_353L;
	static int length(long t){
		int l = 0;
		while(t>0){
			t/=10;
			l++;
		}
		return l;
	}
	static void buildPos(long[] pos){
		pos[0] = 1;
		long cur = 1;
		for(int i =1;i<=18;++i){
			pos[i] = cur;
			cur = cur *10;
		}
	}
	static long doubled(long a){
		long res = 0;
		long pos = 1;
		while(a>0){
			res = (res + (a%10 *10 + a%10)*pos)%REMAIN;
			pos*=100;
			a /=10;
		}
		return res;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[n];
		long[] posses = new long[19];
		buildPos(posses);
		int[] counts = new int[12];
		for(int i = 0;i<n;++i){
			long t = in.nextLong();
			a[i] = t;
			counts[length(t)]++;
		}
		long res = 0;
		//System.out.println(Arrays.toString(counts));
		//System.out.println(Arrays.toString(posses));
		//System.out.println(Long.MAX_VALUE);
		for(int i = 0;i<n;++i){
			long t = a[i];
			int curpos = 1;
			//int step = 0;
			//System.out.println("a[i] = " + a[i] + " | prevres = " + res );
			while(t > 0){
				long digit = t%10;
				t /=10;
				for(int j =1;j<=10;++j){
					res = (res +  (digit*posses[curpos]%REMAIN * 10 *posses[Math.min(curpos,j)]%REMAIN*counts[j]))%REMAIN;
				}
				curpos++;
			}
			//System.out.println("a[i] = " + a[i] + " | midres = " + res );
			t = a[i];
			curpos = 1;
			while(t > 0){
				long digit = t%10;
				t /=10;
				for(int j =1;j<=10;++j){
					res = (res +  (digit*posses[curpos] %REMAIN * (curpos >=2 ? 10:1) *posses[Math.min(curpos-1,j)]%REMAIN*counts[j]))%REMAIN;
				}
				curpos++;
			}
			//res = res - doubled(a[i]);
			//counts[length(a[i])];
		}
		System.out.println(res);
		//System.out.println(1l * 11_000_000 * 1_000_000 % REMAIN * 1_000_000 %REMAIN * 4 %REMAIN);
	}
}
