
import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p001 {
	public static void main(String args[]) throws Exception {
// 		StringTokenizer stok = new StringTokenizer(new Scanner(new File("C:/Users/Arunkumar/Downloads/input.txt")).useDelimiter("\\A").next());
		StringTokenizer stok = new StringTokenizer(new Scanner(System.in).useDelimiter("\\A").next());
		StringBuilder sb = new StringBuilder();
		long n = Long.parseLong(stok.nextToken());
		if(n<=2) System.out.println(n);
		else if(n%2==1) {
			System.out.println(n*(n-1)*(n-2));
		}
		else {
			long v = (Math.max((n*(n-1)*(n-2))/2, (n-3)*(n-1)*(n-2)));
			if(n%3!=0) v = Math.max(v, (n-3)*(n-1)*n);
			System.out.println(v);
		}
	}
}