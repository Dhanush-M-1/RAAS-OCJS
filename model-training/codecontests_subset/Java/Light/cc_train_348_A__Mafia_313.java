import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class l033 {

	public static void main(String[] args) throws Exception {
//		StringTokenizer stok = new StringTokenizer(new Scanner(new File("F:/books/input.txt")).useDelimiter("\\A").next());
		StringTokenizer stok = new StringTokenizer(new Scanner(System.in).useDelimiter("\\A").next());
		StringBuilder sb = new StringBuilder();
		Integer n = Integer.parseInt(stok.nextToken());
		Long[] a = new Long[n];
		for(int i=0;i<n;i++) a[i] = Long.parseLong(stok.nextToken());
		Arrays.sort(a,Collections.reverseOrder());
		long lo = a[0];
		if(check(lo,a)) {
			System.out.println(lo);
			System.exit(0);
		}
		long hi = lo*2;
		while(!check(hi,a)) hi*=2;
		while(lo!=hi) {
			long m = (lo+hi)/2;
			if(check(m,a)) hi=m;
			else lo=m+1;
		}
		System.out.println(lo);
	}

	private static boolean check(long n, Long[] a) {
		long tot = 0;
		for(int i=0;i<a.length;i++) {
			tot += n-a[i];
		}
		return tot>=n?true:false;
	}

}
